package com.telnor.curso.tadk.contentProviderReader;

import com.androidquery.AQuery;

import com.telnor.curso.tadk.MainActivity;
import com.telnor.curso.tadk.R;
import com.telnor.curso.tadk.listview.RowAdapter;
import com.telnor.curso.tadk.contentProvider.UsuarioContentProvider.*;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class UsuarioListProviderActivity extends Activity {
	AQuery aq;
	RowAdapter listado;
	
	private static final String uri = 
			"content://com.telnor.curso.tadk.contentprovider.usuariocontentprovider/usuario";
	
	public static final Uri CONTENT_URI = Uri.parse(uri);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario_list_provider);
		
		aq = new AQuery(this);
		listado = new RowAdapter(this);
		
		aq.id(R.id.usuarioListActivity_list).adapter(listado);
		
		consultar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuario_list, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home: {
			NavUtils.navigateUpTo(this, new Intent(this,
					MainActivity.class));
			return true;
		}
		case R.id.action_archivar:{
			mensaje("Archivar");
			return true;
		}
		case R.id.action_eliminar:{
			mensaje("Eliminando");
			return true;
		}
		case R.id.action_enviar:{
			mensaje("Enviando!");
			return true;
		}
		case R.id.action_nuevo:{
			mensaje("Nuevo");
			return true;
		}
		case R.id.action_refrescar:{
			mensaje("Refrescando");
			return true;
		}
		case R.id.action_settings:{
			mensaje("Configuracion");
			return true;
		}
			
		}
		return super.onOptionsItemSelected(item);
	}
	public void mensaje(String mensaje){
		Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
	}
	
	public void consultar(){
		listado.clear();
		//Columnas de la tabla a recuperar
        String[] projection = new String[] {
        		"_ID",
        		Usuario.COL_NOMBRE,
        		Usuario.COL_TELEFONO,
        		Usuario.COL_EMAIL };

        Uri clientesUri =  CONTENT_URI;

        ContentResolver cr = getContentResolver();
        
        //Hacemos la consulta
        Cursor cur = cr.query(clientesUri,
                                 projection, //Columnas a devolver
                                 null,       //Condición de la query
                                 null,       //Argumentos variables de la query
                                 null);      //Orden de los resultados
        if (cur.moveToFirst()) 
        {
            String nombre; 
            String telefono;
            String email;
            
            int colNombre = cur.getColumnIndex(Usuario.COL_NOMBRE); 
            int colTelefono = cur.getColumnIndex(Usuario.COL_TELEFONO);
            int colEmail = cur.getColumnIndex(Usuario.COL_EMAIL);
            
            do 
            {
            	
                nombre = cur.getString(colNombre);
                telefono = cur.getString(colTelefono);
                email = cur.getString(colEmail);
                
                listado.add(nombre + " - " + telefono + " - " + email);
                
            } while (cur.moveToNext());
        }
        
        listado.notifyDataSetChanged();
	}

}

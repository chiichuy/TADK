package com.telnor.curso.tadk.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.telnor.curso.tadk.R;
import com.telnor.curso.tadk.R.layout;
import com.telnor.curso.tadk.R.menu;
import com.telnor.curso.tadk.listview.RowAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class JsonActivity extends Activity {

	RowAdapter listado;
	AQuery aq;
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		
		aq = new AQuery(this);
		listado = new RowAdapter(this);
		pd = new ProgressDialog(this);
		pd.setTitle("Descargando..");
		pd.setMessage("ya casi!");
		
		aq.id(R.id.lv_json_activity).adapter(listado).itemClicked(this,"seleccionador");
		
		
		aq.progress(pd).ajax("http://192.168.1.81/",JSONObject.class,this,"leerJSon");
	}
	
	public void seleccionador(AdapterView<?> parent, View v, int pos,  long id){
		Toast.makeText(this, listado.getItem(pos), Toast.LENGTH_SHORT).show();
	}
	
	public void leerJSon(String url, JSONObject json, AjaxStatus status) {
		listado.clear();
		
		if(json != null){
			try {
				JSONArray usuarios = json.getJSONArray("usuarios");
				
				for(int i=0;i<usuarios.length();i++){
				
					listado.add(usuarios.getJSONObject(i).getString("nombre"));
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(":(");
		}
		listado.notifyDataSetChanged();
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.json, menu);
		return true;
	}

}

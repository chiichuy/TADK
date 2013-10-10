package com.telnor.curso.tadk.contentProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioSqliteHelper extends SQLiteOpenHelper {

	// Sentencia SQL para crear la tabla de Clientes
	String sqlCreate = "CREATE TABLE Usuario "
			+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " nombre TEXT, "
			+ " telefono TEXT, " + " email TEXT )";

	public UsuarioSqliteHelper(Context contexto, String nombre,
			CursorFactory factory, int version) {

		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Se ejecuta la sentencia SQL de creación de la tabla
		
		db.execSQL(sqlCreate);
 
        //Insertamos 15 clientes de ejemplo
        for(int i=1; i<=15; i++)
        {
            //Generamos los datos de muestra
            String nombre = "Usuario" + i;
            String telefono = "900-123-00" + i;
            String email = "email" + i + "@mail.com";
 
            //Insertamos los datos en la tabla Clientes
            db.execSQL("INSERT INTO Usuario (nombre, telefono, email) " +
                       "VALUES ('" + nombre + "', '" + telefono +"', '" + email + "')");
        }
        
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.
 
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuario");
 
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
	}

}

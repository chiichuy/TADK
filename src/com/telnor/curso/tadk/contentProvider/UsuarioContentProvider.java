package com.telnor.curso.tadk.contentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

public class UsuarioContentProvider extends ContentProvider {

	//Definición del CONTENT_URI
	private static final String uri =
	    "content://com.telnor.curso.tadk.contentprovider.usuariocontentprovider/usuario";
	 
	public static final Uri CONTENT_URI = Uri.parse(uri);
	
	//Necesario para UriMatcher	
	private static final int USUARIOS = 1;
	private static final int USUARIOS_ID = 2;
	private static final UriMatcher uriMatcher;
	
	//Base de datos
	private UsuarioSqliteHelper usuariosHelper;
	private static final String BD_NOMBRE = "DBUsuario";
	private static final int BD_VERSION = 2;
	private static final String TABLA_USUARIO = "Usuario";
	
	//Clase interna para declarar las constantes de columna
	public static final class Usuario implements BaseColumns
	{
	    private Usuario() {}
	 
	    //Nombres de columnas
	    public static final String COL_NOMBRE = "nombre";
	    public static final String COL_TELEFONO = "telefono";
	    public static final String COL_EMAIL = "email";
	}
	
	//Inicializamos el UriMatcher
	static {
	    uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	    uriMatcher.addURI("com.telnor.curso.tadk.contentprovider", "usuario", USUARIOS);
	    uriMatcher.addURI("com.telnor.curso.tadk.contentprovider", "usuario/#", USUARIOS_ID);
	}
	
	@Override
	public boolean onCreate() {
		System.out.println("Oncreate");
		usuariosHelper = new UsuarioSqliteHelper(
	            getContext(), BD_NOMBRE, null, BD_VERSION);
		System.out.println("create");
	    return true;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		System.out.println( "query" + uriMatcher.match(uri));
		  //Si es una consulta a un ID concreto construimos el WHERE
	    String where = selection;
	    if(uriMatcher.match(uri) == USUARIOS_ID){
	                where = "_id=" + uri.getLastPathSegment();
	        }
	    SQLiteDatabase db = usuariosHelper.getWritableDatabase();
	 
	    Cursor c = db.query(TABLA_USUARIO, projection, where,
	                    selectionArgs, null, null, sortOrder);
	    System.out.println(c.toString());
	    return c;
	}
	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int cont;
		 
	    //Si es una consulta a un ID concreto construimos el WHERE
	    String where = selection;
	    if(uriMatcher.match(uri) == USUARIOS_ID){
	            where = "_id=" + uri.getLastPathSegment();
	        }
	 
	    SQLiteDatabase db = usuariosHelper.getWritableDatabase();
	 
	    cont = db.update(TABLA_USUARIO, values, where, selectionArgs);
	 
	    return cont;
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int cont;
		 
	    //Si es una consulta a un ID concreto construimos el WHERE
	    String where = selection;
	    if(uriMatcher.match(uri) == USUARIOS_ID){
	            where = "_id=" + uri.getLastPathSegment();
	        }
	 
	    SQLiteDatabase db = usuariosHelper.getWritableDatabase();
	 
	    cont = db.delete(TABLA_USUARIO, where, selectionArgs);
	 
	    return cont;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
			long regId = 1;
		 
		    SQLiteDatabase db = usuariosHelper.getWritableDatabase();
		 
		    regId = db.insert(TABLA_USUARIO, null, values);
		 
		    Uri newUri = ContentUris.withAppendedId(CONTENT_URI, regId);
		 
		    return newUri;
	}


	@Override
	public String getType(Uri uri) {
		int match = uriMatcher.match(uri);
		 
	    switch (match)
	    {
	        case USUARIOS:
	            return "vnd.android.cursor.dir/vnd.telnor.usuario";
	        case USUARIOS_ID:
	            return "vnd.android.cursor.item/vnd.telnor.usuario";
	        default:
	            return null;
	    }
	}
	

}

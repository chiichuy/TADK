package com.telnor.curso.tadk;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.contentProvider.UsuarioContentProvider;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	AQuery aq;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		aq = new AQuery(this);
		
		aq.id(R.id.btn_mainActivity_contentProvider).clicked(this,"abrirContentProvider");
	}
	
	public void abrirContentProvider(){
		Intent intent = new Intent(this,UsuarioContentProvider.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

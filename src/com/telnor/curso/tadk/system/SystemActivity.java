package com.telnor.curso.tadk.system;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.R;
import com.telnor.curso.tadk.R.layout;
import com.telnor.curso.tadk.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.Toast;

public class SystemActivity extends Activity {

	AQuery aq;
	
	private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
	    @Override
	    public void onReceive(Context arg0, Intent intent) {
	      // TODO Auto-generated method stub
	      int level = intent.getIntExtra("level", 0);
	      String mensaje = String.valueOf(level) + "%";
	      
	      aq.id(R.id.system_battery_label).text(mensaje);
	    }
	  };
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system);
		
		aq = new AQuery(this);
		this.registerReceiver(this.mBatInfoReceiver, 
			    new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.system, menu);
		return true;
	}

}

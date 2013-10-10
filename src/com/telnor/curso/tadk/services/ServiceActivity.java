package com.telnor.curso.tadk.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.R;

public class ServiceActivity extends Activity {
	AQuery aq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		// aq = new AQuery(getApplicationContext());

		// aq.id(R.id.startButton).clicked(this, "startService_");
		// aq.id(R.id.stopButton).clicked(this, "stopService_");
	}

	// start the service
	public void onClickStartService(View V) {
		// start the service from here //MyService is your service class name
		startService(new Intent(this, MyService.class));
	}

	// Stop the started service
	public void onClickStopService(View V) {
		// Stop the running service from here//MyService is your service class
		// name
		// Service will only stop if it is already running.
		stopService(new Intent(this, MyService.class));
	}
}
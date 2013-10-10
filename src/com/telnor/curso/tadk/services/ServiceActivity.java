package com.telnor.curso.tadk.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.telnor.curso.tadk.R;

public class ServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);

		Button start = (Button) findViewById(R.id.startButton);
		Button stop = (Button) findViewById(R.id.stopButton);

		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent service = new Intent(ServiceActivity.this,
						MyService.class);
				startService(service);
			}
		});

		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent service = new Intent(ServiceActivity.this,
						MyService.class);
				stopService(service);
			}
		});

	}

}
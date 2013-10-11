package com.telnor.curso.tadk.sensors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.telnor.curso.tadk.R;

public class SensorActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor);

		findViewById(R.id.sensorsaccel).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorAccel.class));
					}

				});

		findViewById(R.id.sensorgyroscope).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorGyro.class));
					}

				});

		findViewById(R.id.sensorrotate).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorRotationVector.class));
					}

				});

		findViewById(R.id.sensorlinear).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorRotationVector.class));
					}

				});

		findViewById(R.id.sensorgravity).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorGravity.class));
					}

				});

		findViewById(R.id.sensorlight).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorLight.class));
					}

				});

		findViewById(R.id.sensormagnetic).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorMagnetic.class));
					}

				});

		findViewById(R.id.sensorpressure).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorPressure.class));
					}

				});

		findViewById(R.id.sensorproximity).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorProximity.class));
					}

				});

		findViewById(R.id.sensortemp).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								SensorTemp.class));
					}

				});

		findViewById(R.id.gesture).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(),
								GestureView.class));
					}

				});

		findViewById(R.id.nfc233).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent(getBaseContext(), NFC233.class));
					}

				});

		findViewById(R.id.nfc40).setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), NFC40.class));
			}

		});
	}
}
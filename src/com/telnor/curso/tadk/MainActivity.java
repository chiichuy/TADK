package com.telnor.curso.tadk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.camara.CameraActivity;
import com.telnor.curso.tadk.contentProviderReader.UsuarioListProviderActivity;
import com.telnor.curso.tadk.fragment.UsuarioListActivity;
import com.telnor.curso.tadk.gps.GPSActivity;
import com.telnor.curso.tadk.notification.NotificationActivity;
import com.telnor.curso.tadk.sensors.SensorActivity;
import com.telnor.curso.tadk.services.ServiceActivity;

public class MainActivity extends Activity {

	Button btnCamera;
	AQuery aq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		aq = new AQuery(this);
		aq.id(R.id.btn_mainActivity_camera).clicked(this, "abrirCamara");
		aq.id(R.id.btn_mainActivity_contentProvider).clicked(this,
				"abrirContentProvider");
		aq.id(R.id.btn_mainActivity_fragments).clicked(this, "abrirFragmentos");
		aq.id(R.id.btn_mainActivity_notifications).clicked(this,
				"abrirNotificaciones");
		aq.id(R.id.btn_mainActivity_services).clicked(this, "abrirServicios");
		aq.id(R.id.btn_mainActivity_sensors).clicked(this, "abrirSensores");
		aq.id(R.id.btn_mainActivity_gps).clicked(this, "abrirGPS");
	}

	public void abrirContentProvider() {
		Intent intent = new Intent(getApplicationContext(),
				UsuarioListProviderActivity.class);
		startActivity(intent);

	}

	public void abrirFragmentos() {
		Intent intent = new Intent(getApplicationContext(),
				UsuarioListActivity.class);
		startActivity(intent);
	}

	public void abrirCamara() {
		Intent cameraIntent = new Intent(getApplicationContext(),
				CameraActivity.class);
		startActivity(cameraIntent);
	}

	public void abrirNotificaciones() {
		Intent notificationIntent = new Intent(getApplicationContext(),
				NotificationActivity.class);
		startActivity(notificationIntent);
	}

	public void abrirServicios() {
		Intent serviceIntent = new Intent(getApplicationContext(),
				ServiceActivity.class);
		startActivity(serviceIntent);
	}

	public void abrirSensores() {
		Intent sensorIntent = new Intent(getApplicationContext(),
				SensorActivity.class);
		startActivity(sensorIntent);
	}

	public void abrirGPS() {
		Intent gpsIntent = new Intent(getApplicationContext(),
				GPSActivity.class);
		startActivity(gpsIntent);
	}

}

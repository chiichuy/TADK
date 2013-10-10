package com.telnor.curso.tadk.services;

import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class SimpleService extends Service {

	private WakeLock mWakeLock;

	/**
	 * No fue iniciado con Binding, por lo tanto no necesita regresar algo
	 * espec’fico.
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	/**
	 * Inicializaci—n, sucede al llamar el evento startOnCommand()/start()
	 */
	private void handleIntent(Intent intent) {
		// obtain the wake lock
		PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "TAG");
		mWakeLock.acquire();

		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		// cm.getBackgroundDataSetting(); //DEPRECATED
		if (!cm.getActiveNetworkInfo().isConnected()) {
			stopSelf();
			return;
		}

		// Se ejecuta la tarea as’ncrona.
		new ServiceTask().execute();
	}

	private class ServiceTask extends AsyncTask<Void, Integer, Void> {
		/**
		 * Implementar l—gica del servicio. Corre en un hilo separado.
		 */
		@Override
		protected Void doInBackground(Void... params) {

			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Void result) {
			stopSelf();
		}
	}

	@Override
	public void onStart(Intent intent, int startId) {
		handleIntent(intent);
	}

	/**
	 * START_NOT_STICKY le indica al sistema no reiniciar el servicio en caso de
	 * que sea terminado por falta de memoria.
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		handleIntent(intent);
		return START_NOT_STICKY;
	}

	/**
	 * Se liberan los recursos ocupados.
	 */
	public void onDestroy() {
		super.onDestroy();
		mWakeLock.release();
	}
}

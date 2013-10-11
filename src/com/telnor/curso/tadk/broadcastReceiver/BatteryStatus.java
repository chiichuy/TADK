package com.telnor.curso.tadk.broadcastReceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.telnor.curso.tadk.R;

public class BatteryStatus extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battery_status);
		BroadcastReceiver batteryReceiver1 = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
			
				String level = "";
				String mensaje = "";

				level = intent.getStringExtra(BatteryManager.EXTRA_PLUGGED);
				
				mensaje = "Conectado "+level;
				Log.e("BatteryManager_", mensaje);
				Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
			}

		};
		BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
			int scale = -1;
			int level = -1;
			int voltage = -1;
			int temp = -1;
			String mensaje = "";

			@Override
			public void onReceive(Context context, Intent intent) {

				level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
				scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
				temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
				voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
				mensaje = "level is " + level + "/" + scale + ", temp is "
						+ temp + ", voltage is " + voltage;
				Log.e("BatteryManager", mensaje);
				Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
			}
		};
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		IntentFilter filter1 = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
		registerReceiver(batteryReceiver, filter);
		registerReceiver(batteryReceiver1, filter1);
	}
}

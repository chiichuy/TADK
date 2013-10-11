package com.telnor.curso.tadk.hardware;

import java.util.Enumeration;
import java.util.Properties;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.telnor.curso.tadk.R;

public class HardwareActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hardware);
		tv = (TextView) findViewById(R.id.txt_detalles);
		tv.setText(addDebugInfo(null));
	}

	private static String addDebugInfo(Activity a) {

		String data = "";
		/*
		 * try { PackageInfo pInfo = a.getPackageManager().getPackageInfo(
		 * a.getPackageName(), PackageManager.GET_META_DATA); data +=
		 * "\n APP Package Name: " + a.getPackageName(); data +=
		 * "\n APP Version Name: " + pInfo.versionName; data +=
		 * "\n APP Version Code: " + pInfo.versionCode; data += "\n"; } catch
		 * (NameNotFoundException e) { }
		 */
		data += "\n OS Version: " + System.getProperty("os.version") + " ("
				+ android.os.Build.VERSION.INCREMENTAL + ")";
		data += "\n OS API Level: " + android.os.Build.VERSION.SDK;
		data += "\n Device: " + android.os.Build.DEVICE;
		data += "\n Model (and Product): " + android.os.Build.MODEL + " ("
				+ android.os.Build.PRODUCT + ")";
		// TODO add application version!

		data += "\n Manufacturer: " + android.os.Build.MANUFACTURER;
		data += "\n Other TAGS: " + android.os.Build.TAGS;
		/*
		 * data += "\n screenWidth: " +
		 * a.getWindow().getWindowManager().getDefaultDisplay() .getWidth();
		 * data += "\n screenHeigth: " +
		 * a.getWindow().getWindowManager().getDefaultDisplay() .getHeight();
		 * data += "\n Keyboard available: " +
		 * (a.getResources().getConfiguration().keyboard !=
		 * Configuration.KEYBOARD_NOKEYS);
		 * 
		 * data += "\n Trackball available: " +
		 * (a.getResources().getConfiguration().navigation ==
		 * Configuration.NAVIGATION_TRACKBALL); data += "\n SD Card state: " +
		 * Environment.getExternalStorageState();
		 */
		Properties p = System.getProperties();
		Enumeration keys = p.keys();
		String key = "";
		while (keys.hasMoreElements()) {
			key = (String) keys.nextElement();
			data += "\n > " + key + " = " + (String) p.get(key);
		}

		return data;
	}

}

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
		data += "\n OS Version: " + System.getProperty("os.version") + " ("
				+ android.os.Build.VERSION.INCREMENTAL + ")";
		data += "\n OS API Level: " + android.os.Build.VERSION.SDK;
		data += "\n Device: " + android.os.Build.DEVICE;

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

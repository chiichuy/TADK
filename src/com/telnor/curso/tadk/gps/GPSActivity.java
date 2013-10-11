package com.telnor.curso.tadk.gps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.telnor.curso.tadk.R;

public class GPSActivity extends Activity {
	Button btnShowLocation;
	GPSTracker gps;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);

		btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
		btnShowLocation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				gps = new GPSTracker(GPSActivity.this);

				if (gps.canGetLocation()) {

					double latitude = gps.getLatitude();
					double longitude = gps.getLongitude();

					Toast.makeText(
							getApplicationContext(),
							"Your Location is - \nLat: " + latitude
									+ "\nLong: " + longitude, Toast.LENGTH_LONG)
							.show();
				} else {
					gps.showSettingsAlert();
				}

			}
		});
	}
}
package com.telnor.curso.tadk.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.R;

public class NotificationActivity extends Activity {

	private NotificationManager mNotificationManager;
	private int SIMPLE_NOTFICATION_ID;
	AQuery aq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		aq = new AQuery(this);
		
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		aq.id(R.id.notifyButton).clicked(this, "notificar");
		aq.id(R.id.cancelButton).clicked(this, "cancelar");

	}

	public void notificar() {
		final Notification notifyDetails = new Notification(
				R.drawable.ic_launcher, "Aviso de notificaci—n",
				System.currentTimeMillis());
		Context context = getApplicationContext();
		CharSequence contentTitle = "Detalles de notificaci—n...";
		CharSequence contentText = "Texto de mi notificaci—n";
		// Intent a Activity a realizar
		Intent notifyIntent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("http://www.android.com"));
		PendingIntent intent = PendingIntent.getActivity(
				NotificationActivity.this, 0, notifyIntent,
				android.content.Intent.FLAG_ACTIVITY_NEW_TASK);

		notifyDetails.setLatestEventInfo(context, contentTitle, contentText,
				intent);
		mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);
	}

	public void cancelar() {
		mNotificationManager.cancel(SIMPLE_NOTFICATION_ID);
	}
}
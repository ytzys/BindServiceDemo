package com.ytzys.bindservicedemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	private static final String TAG = "MyService";
	private MyBinder binder;
	public String time;

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "onBind");
		return binder;
	}

	@Override
	public void onCreate() {
		binder = new MyBinder();

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = format.format(date);
		Log.i(TAG, "current time:" + time);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i(TAG, "onUnbind");
		return super.onUnbind(intent);
	}

	public String getTimeValue() {
		return time;
	}

	class MyBinder extends Binder {
		public MyService getService() {
			return MyService.this;
		}
	}

}

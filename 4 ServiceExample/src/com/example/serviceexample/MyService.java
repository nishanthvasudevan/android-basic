package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Thread t = new Thread (new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				count();
			}
		});
		t.start();
		
		return super.onStartCommand(intent, flags, startId);
	}

	private void count() {
		for(int i=0;i<30;i++) {
			Log.d("arv","Elapsed " + i + "seconds");
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}

package com.android.lab7exercise_user2;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MyService extends IntentService {

    public MyService() {
        super("worker");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent != null){
            synchronized (this) {

                try {
                    Firebase myFirebaseRef = new Firebase("https://xuouyang-110.firebaseio.com/first");
                    String[] str = {"hey", "there","from", "user", "2"};
                    String temp;
                    for (int i = 0; i < 5; i++){
                        temp = str[i];
                        myFirebaseRef.setValue(temp);
                        wait(4000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stopService(intent);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){


        Toast.makeText(MyService.this, "Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(MyService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
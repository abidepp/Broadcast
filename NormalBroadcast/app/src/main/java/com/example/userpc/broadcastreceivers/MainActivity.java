package com.example.userpc.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //to send broadcast over all the applications----note-->set exported value true in manifest
    BroadcastReceiver broadcastReceiver;

    Button broadcast;

    //to reduce the broadcast only to application level---note-->also works if exported value set to false in manifest
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcast = (Button) findViewById(R.id.button);
        broadcastReceiver = new MyBroadcast();

        localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());

        //to trigger broadcast from a button click
        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test","button clicked");
                Intent intent = new Intent();
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setAction("my.custom.broadcast");
                sendBroadcast(intent); //to send broadcast over all the applications
                //localBroadcastManager.sendBroadcast(intent);//to reduce the broadcast only to application level
            }
        });

    }


    //to just register a broadcast through code and not using manifest file-----
    //however registering only in manifest files also works--------
    //below examples are for creating a custom broadcast
    @Override
    protected void onStart() {
        super.onStart();
//        IntentFilter filter = new IntentFilter("my.custom.broadcast");
//        filter.addAction("android.intent.category.DEFAULT");
//        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
      //  unregisterReceiver(broadcastReceiver);
    }
}

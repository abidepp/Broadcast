package com.example.userpc.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user pc on 2/22/2018.
 */
public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("test","onReceive called");
        Toast.makeText(context, "broadcast triggered--->find the comments in the code", Toast.LENGTH_LONG).show();
    }
}

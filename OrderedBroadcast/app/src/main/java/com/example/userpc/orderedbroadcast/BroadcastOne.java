package com.example.userpc.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by user pc on 2/23/2018.
 */
public class BroadcastOne extends BroadcastReceiver {

    private final String message = "BroadcastOne triggered";
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = getResultExtras(true);
        String tip = bundle.getString(message);
        tip = (tip == null?  "BUNNY!!" : tip+"work on your jokes :P");
        bundle.putString(message, tip);
        Toast.makeText(context,""+message,Toast.LENGTH_LONG).show();
    }
}

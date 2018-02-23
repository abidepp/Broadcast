package com.example.userpc.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by user pc on 2/23/2018.
 */
public class BroadcastTwo extends BroadcastReceiver {

    private final String message = "BroadcastTwo triggered";
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = getResultExtras(true);
        String tip = bundle.getString(message);
        tip = (tip == null?  "BUNNY!!" : tip+"whats your tip?, so ill know you saw this :P");
        bundle.putString(message, tip);
        Toast.makeText(context,""+message,Toast.LENGTH_LONG).show();
    }
}

package com.example.userpc.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    Button sendBroadcast;

   // private final String message = "MainActivity triggered";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBroadcast = (Button) findViewById(R.id.button);

        sendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.broadcast");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
            //    sendOrderedBroadcast(intent, null);   //if you dont want to come back t main activity back
                sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Bundle bundle = getResultExtras(true);
                        String tip = bundle.getString(message);
                        tip = (tip == null?  "BUNNY!!" : tip+"work on your jokes :P");
                        bundle.putString(message, tip);
                        Toast.makeText(context,""+message,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

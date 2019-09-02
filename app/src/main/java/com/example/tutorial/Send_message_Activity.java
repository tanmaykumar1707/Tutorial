package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Send_message_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }

    public void send_sms(View V){
        String message = ((EditText)(findViewById(R.id.txt_sms_message))).getText().toString();
        Uri destinaiton = Uri.parse("smsto:9507373173");
        Intent smsInent = new Intent(Intent.ACTION_SENDTO,destinaiton);
        smsInent.putExtra("sms_body",message);
        startActivity(smsInent);
    }
}

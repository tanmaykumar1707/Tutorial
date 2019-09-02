package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   // Button btn_send_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void go_sendActivity(View v){
        Intent send_intent = new Intent(MainActivity.this,Send_message_Activity.class);
        startActivity(send_intent);
    }
    public void go_listActivity(View v){
        Intent send_intent = new Intent(MainActivity.this,ListView_activity.class);
        startActivity(send_intent);
    }
}

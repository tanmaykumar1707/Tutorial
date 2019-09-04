package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class radio_shared_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_shared_activity);

        // if a preferences file named COLOR_PREF already exists, get it
        // otherwise, create one (when required by the associate editor)
        // data stored in this file are for the use of this app only

        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);

        // create an editor to read and write from/to the preferences file
        final SharedPreferences.Editor editor = preferences.edit(); //Prefereces is object name

        //retrieve a reference to the layout defined int the xml file
        final LinearLayout layout = (LinearLayout)findViewById(R.id.radio_linearLayout);


        // if the preferences file contains a key 'colorId', retrieve the associated value
        // and use it to set the background color

        if(preferences.contains(("colorId")))
            layout.setBackgroundColor(preferences.getInt("colorId",0));

        // retrieve a reference to the group of radio buttons defined in the xml
        RadioGroup radioGroup_colors= (RadioGroup) findViewById((R.id.layout_radiogroup));
        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int colorCode = 0;
                switch (i){
                    case R.id.radioButton_blue:
                        colorCode = Color.BLUE;
                        break;
                    case R.id.radioButton_magenta:
                        colorCode = Color.MAGENTA;
                        break;
                    case R.id.radioButton_yellow:
                        colorCode = Color.YELLOW;
                        break;
                }
                //change backgroud color;
                layout.setBackgroundColor(colorCode);
               String col=  Integer.toString(colorCode);
               // int col = Integer.parseInt(colorCode);
                //save selected color to the preferences file immediately
               Toast.makeText(getApplicationContext(),col,Toast.LENGTH_LONG).show();
                editor.putInt("colorId",colorCode);
                editor.commit();
                editor.apply();
            }
        });

    }
}

package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_activity extends AppCompatActivity {
    ListView list_view;
    ArrayAdapter<CharSequence> list_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_activity);

        list_view = findViewById(R.id.lv_list);
        list_adapter = ArrayAdapter.createFromResource(this,
                                R.array.domain_list_string,
                                android.R.layout.simple_list_item_1);
        list_view.setAdapter(list_adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String) list_adapter.getItem(i);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
            }
        });

    }
}

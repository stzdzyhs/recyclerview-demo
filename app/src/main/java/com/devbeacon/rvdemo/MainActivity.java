package com.devbeacon.rvdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    CustomAdapter adapter;


    Button btn1, btn2;
    RecyclerViewEmpty rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.adapter = new CustomAdapter(null);
        rv1 = findViewById(R.id.rv1);
        rv1.setAdapter(adapter);

        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setEmptyLabel("Empty Data");

        rv1.addItemDecoration(new SimpleDividerItemDecoration(this));

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn1Click();
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn2Click();
            }
        });
    }

    int id = 0;
    protected void btn1Click() {
        id++;
        adapter.add("tttttt: " + id);
        Log.d(TAG, "btn1 click: " + adapter.getItemCount());
    }

    protected void btn2Click() {
        int cnt = adapter.getItemCount();
        if(cnt>0) {
            adapter.remove(cnt-1);
        }
    }
}
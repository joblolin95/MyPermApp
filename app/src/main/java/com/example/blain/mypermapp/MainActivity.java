package com.example.blain.mypermapp;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button reqContactPermBtn, reqCameraPermBtn, checkContactPermBtn, checkCameraPermBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkContactPermBtn = (Button) findViewById(R.id.checkContactsPermBtn);
        reqContactPermBtn = (Button) findViewById(R.id.reqContactsPermBtn);
        checkCameraPermBtn = (Button) findViewById(R.id.checkCameraPermBtn);
        reqCameraPermBtn = (Button) findViewById(R.id.reqCameraPermBtn);

        checkContactPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        reqContactPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        checkCameraPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        reqCameraPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

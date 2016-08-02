package com.example.blain.mypermapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reqContactPermBtn, reqCameraPermBtn, checkContactPermBtn, checkCameraPermBtn;
    public static final int MY_PERM_READ_CONTACTS = 0;
    public static final int MY_PERM_CAMERA = 1;

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
                String message;
                if(isPermissionGranted(Manifest.permission.READ_CONTACTS)){
                    message = "You currently have permission to access Contacts";
                } else {
                    message = "You do not have permission to access Contacts - request for permission";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        reqContactPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Manifest.permission.READ_CONTACTS);
            }
        });

        checkCameraPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                if(isPermissionGranted(Manifest.permission.CAMERA)){
                    message = "You currently have permission to access the Camera";
                } else {
                    message = "You do not have permission to access the Camera - request for permission";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            }
        });

        reqCameraPermBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission(Manifest.permission.CAMERA);
            }
        });
    }// onCreate

    private boolean isPermissionGranted(String permission){
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission(String permission){
        if(isPermissionGranted(permission)){
            // Show message that permission was already granted
            switch(permission){
                case Manifest.permission.READ_CONTACTS:
                    Toast.makeText(getApplicationContext(), "Permissions have already been granted for reading Contacts",
                            Toast.LENGTH_SHORT).show();
                    break;
                case Manifest.permission.CAMERA:
                    Toast.makeText(getApplicationContext(), "Permissions have already been granted for using the Camera",
                            Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        } else {
            // get perm
            switch(permission){
                case Manifest.permission.READ_CONTACTS:
                    ActivityCompat.requestPermissions(this, new String[]{ permission}, MY_PERM_READ_CONTACTS);
                    break;
                case Manifest.permission.CAMERA:
                    ActivityCompat.requestPermissions(this, new String[] {permission}, MY_PERM_CAMERA);
                    break;
                default:
                    break;
            }
        }

    }


}

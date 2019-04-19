package com.example.dokatsu.dokatsu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //電話をかける許可
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, 0);
        }

        //登録ボタンのリスナー設定
        Button btnRegistration = findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),RegistrationActivity.class);
                startActivity(intent);
            }
        });

        //表示ボタンのリスナー設定
        Button btnMoveViewerVisit = findViewById(R.id.btnMoveViewerVisit);
        btnMoveViewerVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),ViewVisiterActivity.class);
                startActivity(intent);
            }
        });

        //電話ボタンのリスナー設定
        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view)
            {
                if (ContextCompat.checkSelfPermission(super, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Uri uri = Uri.parse("tel:1111111111");
                    Intent i = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(i);
            }
        });
    }



}

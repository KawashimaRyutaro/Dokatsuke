package com.example.dokatsu.dokatsu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class syoruiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syorui);
        //電話ボタンのリスナー設定
        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener(){
            AppCompatActivity activity;
            private View.OnClickListener setMember(AppCompatActivity _activity)
            {
                activity = _activity;
                return this;
            }
            @Override
            public  void onClick(View view)
            {
                //電話をかける許可
                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.CALL_PHONE}, 0);
                }
                Uri uri = Uri.parse("tel:1111111111");
                Intent i = new Intent(Intent.ACTION_CALL, uri);
                startActivity(i);
            }
        }.setMember(this));
    }
}

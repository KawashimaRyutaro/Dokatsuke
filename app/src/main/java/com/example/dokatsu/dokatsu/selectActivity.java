package com.example.dokatsu.dokatsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class selectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Button  bt_modoru2= findViewById(R.id.戻る2);
        bt_modoru2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        Button bt_totablet = findViewById(R.id.button_tablet);
        bt_totablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                // intent.setClassName(getPackageName(),getPackageName()+".syoruiActivity");
                Intent intent = new Intent(getApplication(),UktkTablet.class);
                startActivity(intent);
            }
        });

        Button bt_tosyorui = findViewById(R.id.button_syorui);
        bt_tosyorui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
               // intent.setClassName(getPackageName(),getPackageName()+".syoruiActivity");
                Intent intent = new Intent(getApplication(),syoruiActivity.class);
                startActivity(intent);
            }
        });
    }
}

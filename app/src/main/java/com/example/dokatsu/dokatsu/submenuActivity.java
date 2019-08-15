package com.example.dokatsu.dokatsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class submenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);

        Button bt_toselect = findViewById(R.id.button_uti);
        bt_toselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //intent.setClassName(getPackageName(),getPackageName()+".selectActivity");
                Intent intent = new Intent(getApplication(),selectActivity.class);
                startActivity(intent);
            }
        });

        Button bt_tocall = findViewById(R.id.button_hitatu);
//        Callイベントを呼び出す(未実装)
//        bt_tocall.setOnClickListener((v) {
//                Intent intent = new Intent(getApplication(),syoruiActivity.class);
//                startActivity(intent);
//        });
    }
}

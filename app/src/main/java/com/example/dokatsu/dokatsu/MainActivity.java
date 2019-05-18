package com.example.dokatsu.dokatsu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_tosubmenu = findViewById(R.id.受付_button);
        bt_tosubmenu.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //intent.setClassName(getPackageName(),getPackageName()+".submenuActivity");
                Intent intent = new Intent(getApplication(),submenuActivity.class);
                startActivity(intent);
            }
        });
    }
}


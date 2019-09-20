package com.example.dokatsu.dokatsu;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    int systemsKunClickNum = 0;

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
        findViewById(R.id.imageView).setOnClickListener(this);
        EmployeeXML._File = getApplicationContext().getFileStreamPath("Employee.xml");
    }

    /**
     * 各ボタンの押下時処理
     * @param view
     */
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imageView:
                onClick_ImageView();
                break;
        }
    }

    /**
     * システムズくん押下時処理
     */
    private void onClick_ImageView()
    {
        if(systemsKunClickNum < 10)
        {
            systemsKunClickNum++;
        }
        else
        {
            systemsKunClickNum = 0;
            Intent intent = new Intent(getApplication(),MemberMainteActivity.class);
            startActivity(intent);
        }
    }
}


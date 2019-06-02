package com.example.dokatsu.dokatsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UktkTablet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uktktablet);

        // 決定ボタン
        Button sendButton1 = findViewById(R.id.button);
        sendButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //呼び出し中の画面に遷移
            }
        });
    }
}

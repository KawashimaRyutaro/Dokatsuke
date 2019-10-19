package com.example.dokatsu.dokatsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class UktkTablet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uktktablet);

        //戻るボタン押下時
        Button bt_return = findViewById(R.id.戻る2);
        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 決定ボタン
        Button sendButton1 = findViewById(R.id.button);
        sendButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //呼び出し中の画面に遷移
            }
        });

        //社員選択リスト
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        for(EmployeeBean _Emp : EmployeeXML._EmployeeList)
        {
            adapter.add(_Emp.getName());
        }
        spinner.setAdapter(adapter);

    }
}

package com.example.dokatsu.dokatsu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ViewVisiterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewvisiter);

        //テキストの表示
        GetVisiterData();

        //ボタン押下時の画面遷移
        Button btnMoveMain = findViewById(R.id.btnMoveMain);
        btnMoveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void GetVisiterData()
    {
        //ファイルが存在しない場合は処理を行わない
        File file = getBaseContext().getFileStreamPath("Visiter");
        if(!file.exists()) return;

        //内部ストレージからデータを取得
        try {
            FileInputStream fileInputStream = (FileInputStream) openFileInput("Visiter");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            VisiterBean visiterBean = (VisiterBean)objectInputStream.readObject();
            TextView lblName = findViewById(R.id.lblName);
            lblName.setText(visiterBean.getName());
            TextView lblDept = findViewById(R.id.lblDept);
            lblDept.setText(visiterBean.getDept());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

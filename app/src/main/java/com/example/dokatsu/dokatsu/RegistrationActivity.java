package com.example.dokatsu.dokatsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        /*
        Button sendRegistration = findViewById(R.id.btnRegist);
        sendRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    EditText txtName = findViewById(R.id.txtName);
                    EditText txtDept = findViewById(R.id.txtDept);
                    VisiterBean visiterBean = new VisiterBean(txtDept.getText().toString(), txtName.getText().toString());
                    File file = getBaseContext().getFileStreamPath("Visiter");
                    if (!file.exists()) file.createNewFile();
                    //FileInputStream fileInputStream = (FileInputStream) openFileInput("Visiter");
                    //ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    FileOutputStream fileOutputStream = openFileOutput("Visiter",MODE_PRIVATE);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(visiterBean);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    //メイン画面に遷移
                    Intent intent = new Intent(getApplication(), KawashimaMainActivity.class);
                    startActivity(intent);
                }
            }
        });
        */
    }
}

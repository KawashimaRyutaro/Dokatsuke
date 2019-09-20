package com.example.dokatsu.dokatsu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MemberMainteActivity extends AppCompatActivity implements  View.OnClickListener
{
    //編集中のID
    String editID="";
    //テーブルレイアウト
    TableLayout _tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainte);
        findViewById(R.id.ButtonAddUpdate).setOnClickListener(this);
        AddEmpRowToTblLayout( );
    }

    private void AddEmpRowToTblLayout()
    {
        _tableLayout = findViewById(R.id.table1);
        _tableLayout.removeAllViews();

        for(final EmployeeBean _Emp : EmployeeXML._EmployeeList)
        {
            TableRow _Row = new TableRow(this);
            TextView _Id =new TextView(this);
            _Id.setText(_Emp.getId());
            _Row.addView(_Id);
            TextView _Furigana =new TextView(this);
            _Furigana.setText(_Emp.getFurigana());
            _Row.addView(_Furigana);
            TextView _Name =new TextView(this);
            _Name.setText(_Emp.getName());
            _Row.addView(_Name);
            Button _Delete = new Button(this);
            _Delete.setText("削除");
            _Delete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    EmployeeXML._EmployeeList.remove(_Emp);
                    EmployeeXML.saveFile();
                    AddEmpRowToTblLayout();
                }
            });
            _Row.addView(_Delete);
            _tableLayout.addView(_Row);
        }

    }

    /**
     * 各ボタンの押下時処理
     * @param view
     */
    public  void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ButtonAddUpdate:
                String id = ((EditText)findViewById(R.id.editText_ID)).getText().toString();
                String Name = ((EditText)findViewById(R.id.editText_Name)).getText().toString();
                String furigana = ((EditText)findViewById(R.id.editText_Furigana)).getText().toString();
                EmployeeXML._EmployeeList.add(new EmployeeBean(id,furigana,Name));
                EmployeeXML.saveFile();
                AddEmpRowToTblLayout();
                break;
        }
    }
}

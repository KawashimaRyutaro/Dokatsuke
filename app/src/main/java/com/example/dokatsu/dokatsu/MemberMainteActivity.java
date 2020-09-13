package com.example.dokatsu.dokatsu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;

public class MemberMainteActivity extends AppCompatActivity implements  View.OnClickListener
{
    //編集中のID
    String editID="";
    //テーブルレイアウト
    TableLayout _tableLayout;

    //パディングの幅
    final int PADDING_WIDTH = 20;

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

        //タイトル部の作成
        TableRow _HeadRow = new TableRow(this);

        TextView _HeadName = new TextView(this);
        _HeadName.setText(String.format("%-"+PADDING_WIDTH+"s","名前"));
        _HeadRow.addView(_HeadName);

        TextView _HeadFurigana = new TextView(this);
        _HeadFurigana.setText(String.format("%-"+PADDING_WIDTH+"s","ふりがな"));
        _HeadRow.addView(_HeadFurigana);

        TextView _HeadId = new TextView(this);
        _HeadId.setText(String.format("%-"+PADDING_WIDTH+"s","電話番号"));
        _HeadRow.addView(_HeadId);

        _tableLayout.addView(_HeadRow);

        for(final EmployeeBean _Emp : EmployeeXML._EmployeeList)
        {
            TableRow _Row = new TableRow(this);

            TextView _Name =new TextView(this);
            _Name.setText(String.format("%-"+PADDING_WIDTH+"s",_Emp.getName()));
            _Row.addView(_Name);

            TextView _Furigana =new TextView(this);
            _Furigana.setText(String.format("%-"+PADDING_WIDTH+"s",_Emp.getFurigana()));
            _Row.addView(_Furigana);

            TextView _Id =new TextView(this);
            _Id.setText(String.format("%-"+PADDING_WIDTH+"s",_Emp.getId()));
            _Row.addView(_Id);

            Button _Delete = new Button(this);
            _Delete.setText("削除");
            _Delete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(MemberMainteActivity.this)
                            .setTitle("警告")
                            .setMessage("削除しますか")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // OK button pressed
                                    EmployeeXML._EmployeeList.remove(_Emp);
                                    EmployeeXML.saveFile();
                                    AddEmpRowToTblLayout();
                                }
                            })
                            .setNegativeButton("Cancel", null)
                            .show();
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

                // 入力チェック
                List<String> validationList = onClickVaridation();
                // エラーがあれば、警告メッセージを出力
                if (validationList != null && validationList.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    int loopCount = 1;
                    for (String messageList : validationList) {
                        sb.append(messageList);
                        if (loopCount != validationList.size()) {
                            sb.append("\n");
                        }
                    }
                    new AlertDialog.Builder(MemberMainteActivity.this)
                            .setTitle("警告")
                            .setMessage(sb.toString())
                            .setPositiveButton("OK", null)
                            .show();
                    break;

                }

                new AlertDialog.Builder(MemberMainteActivity.this)
                        .setTitle("警告")
                        .setMessage("追加しますか")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // OK button pressed
                                String id = ((EditText)findViewById(R.id.editText_ID)).getText().toString();
                                String Name = ((EditText)findViewById(R.id.editText_Name)).getText().toString();
                                String furigana = ((EditText)findViewById(R.id.editText_Furigana)).getText().toString();
                                EmployeeXML._EmployeeList.add(new EmployeeBean(id,furigana,Name));
                                EmployeeXML.saveFile();
                                AddEmpRowToTblLayout();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                break;
        }
    }

    public List<String> onClickVaridation() {
        // 返却値のリストを作成
        List<String> varidationList = new ArrayList<String>();

        // ------------------
        // 名前の入力チェック
        // ------------------
        // 未入力チェック
        if (TextUtils.isEmpty(((EditText)findViewById(R.id.editText_Name)).getText().toString())) {
            varidationList.add("名前が未入力です");
        }
        // ------------------
        // ふりがなの入力チェック
        // ------------------
        // 未入力チェック
        if (TextUtils.isEmpty(((EditText)findViewById(R.id.editText_Furigana)).getText().toString())) {
            varidationList.add("ふりがなが未入力です");
        }

        // ------------------
        // 電話番号の入力チェック
        // ------------------
        // 未入力チェック
        if (TextUtils.isEmpty(((EditText)findViewById(R.id.editText_ID)).getText().toString())) {
            varidationList.add("電話番号が未入力です");
            // 数値チェック
        } else if (!TextUtils.isDigitsOnly(((EditText)findViewById(R.id.editText_ID)).getText().toString())) {
            varidationList.add("電話番号に数値以外の文字が入力されています");
        }

        return varidationList;
    }
}

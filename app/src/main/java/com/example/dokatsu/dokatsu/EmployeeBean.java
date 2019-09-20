package com.example.dokatsu.dokatsu;

import java.io.Serializable;

public class EmployeeBean implements Serializable{
    private static final long serialVersionUID = 1L;
    // プロパティ(メンバ変数)の宣言
    private String id;
    private String furigana;
    private String name;

    // 引数なしコンストラクタの定義
    public EmployeeBean() {}

    //引数ありコンストラクタの定義
    public  EmployeeBean(String id, String furigana, String name)
    {
        setId(id);
        setFurigana(furigana);
        setName(name);
    }

    // プロパティidのsetter、getter
    public void setId(String id) {this.id = id;}
    public String getId() {return this.id;}

    // プロパティfuriganaのsetter、getter
    public void setFurigana(String furigana) {this.furigana = furigana;}
    public String getFurigana() {return this.furigana;}

    // プロパティnameのsetter、getter
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
}

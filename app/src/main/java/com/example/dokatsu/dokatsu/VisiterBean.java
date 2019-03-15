package com.example.dokatsu.dokatsu;

import java.io.Serializable;

public class VisiterBean implements Serializable{
    private static final long serialVersionUID = 1L;
    // プロパティ(メンバ変数)の宣言
    private String dept;
    private String name;

    // 引数なしコンストラクタの定義
    public VisiterBean() {}

    //引数ありコンストラクタの定義
    public  VisiterBean(String dept,String name)
    {
        setDept(dept);
        setName(name);
    }

    // プロパティdeptのsetter、getter
    public void setDept(String dept) {this.dept = dept;}
    public String getDept() {return this.dept;}

    // プロパティnameのsetter、getter
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
}

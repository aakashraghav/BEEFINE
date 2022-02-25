package com.example.myapplication;

public class MainModel {
    Integer langLogo;
    String langName;

    public MainModel(Integer langLogo,String langName){
        this.langLogo = langLogo;
        this.langName = langName;
    }

    public MainModel(Integer therapist, String langName, String s, String s1) {
    }

    public Integer getlangLogo(){
        return langLogo;
    }

    public String getLangName(){
        return langName;
    }
}

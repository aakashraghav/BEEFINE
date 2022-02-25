package com.example.myapplication;

public class QuestionsAddiction {
    private int ID;
    private String QUESTION ;
    private String OPTA ;
    private String  OPTB ;

    public QuestionsAddiction(){
    ID=0;
    QUESTION="";
    OPTA="";
    OPTB="";

    }
    public QuestionsAddiction(String qUESTION, String oPTA,String oPTB){

        QUESTION=qUESTION;
        OPTB=oPTB;
        OPTA=oPTA;
    }
    //getters
    public int getID(){
        return ID;
    }
    public String getQUESTION(){
        return QUESTION;
    }
    public String getOPTA(){
        return OPTA;
    }
    public String getOPTB(){
        return OPTB;
    }
    //setters
    public void setID(int id){
        ID=id;

    }
    public void setQUESTION(String qUESTION){
        QUESTION=qUESTION;
    }
    public void setOPTA(String oPTA){
        OPTA=oPTA;
    }
    public void setOPTB(String oPTB){
        OPTB=oPTB;
    }


}

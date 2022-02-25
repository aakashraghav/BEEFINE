package com.example.myapplication;

import static com.example.myapplication.QuizContact.MovieEntry.KEY_ID;
import static com.example.myapplication.QuizContact.MovieEntry.KEY_OPTA;
import static com.example.myapplication.QuizContact.MovieEntry.KEY_OPTB;
import static com.example.myapplication.QuizContact.MovieEntry.KEY_QUESTION;
import static com.example.myapplication.QuizContact.MovieEntry.TABLE_QUEST;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    //database name
    private static final String DATABASE_NAME = "relationshipSelfAssessment";
    //tasks table name

    private SQLiteDatabase dbase;

    public DbHelper( Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST +"(" + KEY_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_QUESTION+"TEXT," +
                KEY_OPTA +"TEXT,"+KEY_OPTB+"TEXT)";


        addQuestions();

    }

    private void addQuestions(){
        QuestionsAddiction q1 = new QuestionsAddiction(" My partner accuses me of flirting or cheating","Yes","No");
        this.addQuestion(q1);
        QuestionsAddiction q2 = new QuestionsAddiction("2. My partner breaks things or throws things to intimidate me","Yes","No");
        this.addQuestion(q2);
        QuestionsAddiction q3 = new QuestionsAddiction("3. My partner constantly checks up on me or makes me check in","Yes","No");
        this.addQuestion(q3);
        QuestionsAddiction q4 = new QuestionsAddiction("4.My partner controls what I wear or how I look","Yes","No");
        this.addQuestion(q4);
        QuestionsAddiction q5 = new QuestionsAddiction("5. My partner encourages me to try new things","Yes","No");
        this.addQuestion(q5);
        QuestionsAddiction q6 = new QuestionsAddiction("6. My partner gets extremely jealous or possessive","Yes","No");QuestionsAddiction q = new QuestionsAddiction("1. My partner accuses me of flirting or cheating","Yes","No");
        this.addQuestion(q6);
        QuestionsAddiction q7 = new QuestionsAddiction("7. My partner grabs, pushes, shoves, chokes, punches, slaps, holds me down, throws things or hurts me in some way","Yes","No");
        this.addQuestion(q7);
        QuestionsAddiction q8 = new QuestionsAddiction("8. My partner has big mood swings - gets angry and yells at me one minute, but is sweet and apologetic the next","Yes","No");
        this.addQuestion(q8);
        QuestionsAddiction q9 = new QuestionsAddiction("14. My partner makes me feel nervous or like I'm walking on eggshells","Yes","No");
        this.addQuestion(q9);
        QuestionsAddiction q10 = new QuestionsAddiction("15. My partner pressures or force me into having sex or going farther than I want to","Yes","No");
        this.addQuestion(q10);
        QuestionsAddiction q11 = new QuestionsAddiction("16. My partner puts me down, calls me names or criticizes me","Yes","No");
        this.addQuestion(q11);
        QuestionsAddiction q12 = new QuestionsAddiction("12. My partner makes me feel like I can't do anything right or blames me for problems","Yes","No");
        this.addQuestion(q12);
        QuestionsAddiction q13 = new QuestionsAddiction("17. My partner says I'm too involved in different activities","Yes","No");
        this.addQuestion(q13);
        QuestionsAddiction q14 = new QuestionsAddiction("18. My partner texts me or call me all the time","Yes","No");
        this.addQuestion(q14);
        QuestionsAddiction q15= new QuestionsAddiction("19. My partner thinks I spend too much time trying to look nice","Yes","No");
        this.addQuestion(q15);
        QuestionsAddiction q16 = new QuestionsAddiction("20. My partner threatens to destroy my things","Yes","No");
        this.addQuestion(q16);
        QuestionsAddiction q17 = new QuestionsAddiction("21. My partner threatens to hurt him or herself because of me","Yes","No");
        this.addQuestion(q17);
        QuestionsAddiction q18 = new QuestionsAddiction("22. My partner threatens to hurt me, my friends or family","Yes","No");
        this.addQuestion(q18);
        QuestionsAddiction q19 = new QuestionsAddiction("23. My partner tries to control what I do and who I see","Yes","No");
        this.addQuestion(q19);
        QuestionsAddiction q20 = new QuestionsAddiction("24. My partner tries to keep me from seeing or talking to my family and friends","Yes","No");
        this.addQuestion(q20);
        QuestionsAddiction q21 = new QuestionsAddiction("25. My partner understands that I have my own life too" ,"Yes","No");
        this.addQuestion(q21);
        QuestionsAddiction q22 = new QuestionsAddiction("26. My partner yells screams or humiliates me in front of other people","Yes","No");
        this.addQuestion(q22);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_QUEST);
        onCreate(db);

    }
    public void addQuestion(QuestionsAddiction quest){
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION,quest.getQUESTION());
        values.put(KEY_OPTA,quest.getOPTA());
        values.put(KEY_OPTB,quest.getOPTB());
       dbase.insert(TABLE_QUEST,null,values);

    }
    public List <QuestionsAddiction> getAllQuestions(){
        List<QuestionsAddiction> quesList = new ArrayList<>() ;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery ,null);
        //looping through all rows an adding to list
        if(cursor.moveToFirst()){
            do{
                QuestionsAddiction quest = new QuestionsAddiction();
                quest.setID( cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPTA(cursor.getString(2));
                quest.setOPTB(cursor.getString(3));
            }while (cursor.moveToNext());
        }
        return quesList;
    }
public int rowcount(){
        int row =0;
        String selectQuery ="SELECT  * FROM " + TABLE_QUEST;
    SQLiteDatabase db= this.getWritableDatabase();
    Cursor cursor =db.rawQuery(selectQuery,null);
    row =cursor.getCount();
    return row;

    }

}

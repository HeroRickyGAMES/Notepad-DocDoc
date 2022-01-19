package com.herorickystudios.notepaddocdoc;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NoteDataBase extends SQLiteOpenHelper {

    private final static int DATABASE_version = 2;
    private final static String DATABASE_NAME = "notedb";
    private final static String DATABASE_TABLE = "notestable";

    private static final String KEY_ID= "ID";

    //Conteudo do DB
    private static final String KEY_TITLE= "title";
    private static final String KEY_CONTENT= "content";
    private static final String KEY_DATE= "data";
    private static final String KEY_TIME= "time";

    NoteDataBase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// CREATE TABLE nametame (id INT PRIMARY KEY, title, TEXT, content TEXT, date TEXT, time TEXT)

        String query = "CREATE TABLE " + DATABASE_TABLE + "("+ KEY_ID + " INT PRIMARY KEY , "+
                KEY_TITLE + "TEXT, " +
                KEY_CONTENT + "TEXT, " +
                KEY_DATE + "TEXT, " +
                KEY_TIME + "TEXT" +")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if(oldVersion >= newVersion)
                return;
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
    }
}

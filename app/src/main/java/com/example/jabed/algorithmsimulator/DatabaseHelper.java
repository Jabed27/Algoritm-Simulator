package com.example.jabed.algorithmsimulator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.ScriptGroup;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASENAME = "Input_Output.db";
    public static final String TABLE_NAME = "Simulator_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Input";
    public static final String COL_4 = "Output";

    public DatabaseHelper(Context context) {  //this will creat database
        super(context, DATABASENAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {     //this will creat the table
       db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, INPUT TEXT,OUTPUT TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);  //it will drop if there is any need of upgredation
        onCreate(db);
    }
    public boolean insertdata(String name,String Input,String Output ){
        SQLiteDatabase db = this.getWritableDatabase();     //checking
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3, Input);
        contentValues.put(COL_4, Output);
       long result =  db.insert(TABLE_NAME,null,contentValues);
       if(result == -1){
           return false;
       }
       else {
           return true;
       }
    }
    public Cursor getAlldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select*from "+TABLE_NAME,null);
        return res;
    }
}

package com.example.softproject;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;

import java.io.File;

public  class Login {
 // 회원정보를 관리하는 db
   static SQLiteDatabase logindb=null;

    public SQLiteDatabase init_database() {

        File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"login.db");

        SQLiteDatabase db=null;


        try {

            db = SQLiteDatabase.openOrCreateDatabase(file,null) ;
        } catch (SQLiteException e) {
            e.printStackTrace() ;
        }

        if (db == null) {
            System.out.println("DB creation failed. ") ;
        }
        return db;
    }
    public void init_tables(){
        if(logindb != null)
        {
            String sqlCreateTbl="CREATE TABLE IF NOT EXISTS CONTACT_T ("+
                    "ID "+"TEXT,"+
                    "PASSWORD "+"TEXT"+")";

            logindb.execSQL(sqlCreateTbl);
        }
    }
}

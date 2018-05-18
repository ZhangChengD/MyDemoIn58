package com.zc.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class DBDao {

    private Context mContext;
    private MyDBHelper mDBHelper;

    public  DBDao(Context mContext){
        this.mContext = mContext;
        mDBHelper = new MyDBHelper(mContext);
    }

    public void insert(Person person){
        SQLiteDatabase database = mDBHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        person.setCV(cv);
        database.insert(MyDBHelper.TABLE_NAME,null,cv);
    }

    public void updata(Person person){
        SQLiteDatabase database = mDBHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        person.setCV(cv);
        database.update(MyDBHelper.TABLE_NAME,cv,"_name = ?",new String[]{person.getName()});
    }

    public void updata(List<Person> persons){
        SQLiteDatabase database = mDBHelper.getWritableDatabase();
        database.beginTransaction();
        for (Person person :persons) {
            ContentValues cv = new ContentValues();
            person.setCV(cv);
            database.update(MyDBHelper.TABLE_NAME, cv, "_name = ?", new String[]{person.getName()});
        }

        database.setTransactionSuccessful();
    }


}

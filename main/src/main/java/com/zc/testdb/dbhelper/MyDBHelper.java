package com.zc.testdb.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zc.util.Envi;
import com.zc.util.ToastUtills;

import java.io.File;

/**
 * Created by 张程 on 17/9/11.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "test.db";
    private static final String DB_TABLE = "location";
    private static final int DATABASE_VERSION = 1;
    private static MyDBHelper myDBHelper;

    private MyDBHelper(Context contex) {
        super(contex, DB_NAME, null, DATABASE_VERSION);
    }


    public static synchronized SQLiteDatabase getAssetsDb() {
        String path = Envi.context.getDir("test", Context.MODE_PRIVATE).getAbsolutePath() + File.separator + DB_NAME;
        return SQLiteDatabase.openOrCreateDatabase(path, null);
    }

    public static MyDBHelper getInstance(Context context) {
        if (myDBHelper == null) {
            synchronized (MyDBHelper.class) {
                myDBHelper = new MyDBHelper(context);
            }
        }
        return myDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        String s = "create table location ( _id INTEGER PRIMARY KEY autoincrement, cityId text ,cityCode text)";
        try {
            db.execSQL(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInto(String name, String code) {
        SQLiteDatabase db;
        try {
            db = getWritableDatabase();
            if (db != null) {
                ContentValues cv = new ContentValues();
                cv.put("cityId", name);
                cv.put("cityCode", code);
                db.insert(DB_TABLE, null, cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getInfo() {
        SQLiteDatabase db;
        try {
            db = getReadableDatabase();
            if (db != null) {
                Cursor cursor = db.query(DB_TABLE, null, null, null, null, null
                        , null);
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    System.out.println(cursor.getString(cursor.getColumnIndex("cityCode")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getInfoByAssets() {
        SQLiteDatabase db;
        try {
            db = getAssetsDb();
            if (db != null) {
                Cursor cursor = db.query(DB_TABLE, null, null, null, null, null
                        , null);
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    System.out.println(cursor.getString(cursor.getColumnIndex("city_name")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != DATABASE_VERSION) {
            onCreate(db);
        }
    }
}

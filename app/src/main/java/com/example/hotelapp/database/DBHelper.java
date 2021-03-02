package com.example.hotelapp.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "HotelApp";
    static final int VERSION = 1;
    public static final String USER_TABLE = "user";
    static final String CREATE_TABLE = "create table " + USER_TABLE + "(id INTEGER Primary Key, name VARCHAR, email VARCHAR, paymentInfo DOUBLE, roomId INTEGER, reserveFrom Date, reserveTill Date)";
    static final String DROP_TABLE = "drop table if exists "+ USER_TABLE;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            System.out.println("Exception "+ e);
        }
    }
}
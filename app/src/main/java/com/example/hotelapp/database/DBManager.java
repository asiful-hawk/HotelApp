package com.example.hotelapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    Cursor cursor;

    public DBManager(Context c) {
        this.context = c;
    }

    public DBManager open() throws SQLException {
        this.dbHelper = new DBHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.dbHelper.close();
    }

    public void insertData(String name, String email, double payInfo, int roomId, Date reserveFrom, Date reserveTill) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("roomId", roomId);
        values.put("payInfo", payInfo);
        values.put("reserveFrom", String.valueOf(reserveFrom));
        values.put("reserveTill", String.valueOf(reserveTill));
        this.database.insert(dbHelper.USER_TABLE, null, values);
    }


    public Cursor fetch() {
        String[] cname = cursor.getColumnNames();
        cursor = this.database.query(DBHelper.USER_TABLE, cname, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
//
//    public int update(long _id, String name, String desc) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DBHelper.NAME, name);
//        contentValues.put(DBHelper.AGE, desc);
//        return this.database.update(DBHelper.TABLE_NAME_STUDENT, contentValues, "_id = " + _id, null);
//    }
//
//    public void delete(long _id) {
//        this.database.delete(SQLiteHelper.TABLE_NAME_STUDENT, "_id=" + _id, null);
//    }
}

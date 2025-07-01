package com.example.myfood_ntmtuan;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_ntmtuan.model.Food_NTMTuan;
import com.example.myfood_ntmtuan.model.User_NTMTuan;
import com.example.myfood_ntmtuan.sqlite_NTMTuan.DBHelper_NTMTuan;

import java.util.ArrayList;
import java.util.List;

public class UserEdit_NTMTuan {

    private SQLiteDatabase db;

    public UserEdit_NTMTuan(Context context) {
        DBHelper_NTMTuan dbHelperNtmTuan =new DBHelper_NTMTuan(context);

        db = dbHelperNtmTuan.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<User_NTMTuan> get(String sql, String ...selectArgs){
        List<User_NTMTuan> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()){
            User_NTMTuan user = new User_NTMTuan();
            //user.setUserId(cursor.getString(cursor.getColumnIndex("userId")));
            user.setUserName(cursor.getString(cursor.getColumnIndex("userName")));
            user.setPassword(cursor.getString(cursor.getColumnIndex("password")));

            list.add(user);
        }

        return list;
    }

    public List<User_NTMTuan> getAll(){
        String sql = "SELECT * FROM User";
        return get(sql);
    }

    public User_NTMTuan getById(String id){
        String sql = "SELECT * FROM User WHERE userId = ?";
        List<User_NTMTuan> list = get(sql, id);

        return list.get(0);
    }

    public long insert(User_NTMTuan user){
        ContentValues values = new ContentValues();
        //values.put("userId", user.getUserId());
        values.put("userName", user.getUserName());
        values.put("password", user.getPassword());
        values.put("phone", user.getPhone());

        return db.insert("User", null, values);
    }

    public long update(User_NTMTuan user){
        ContentValues values = new ContentValues();
        //values.put("userId", user.getUserId());
        values.put("userName", user.getUserName());
        values.put("password", user.getPassword());
        values.put("phone", user.getPhone());

        return db.update("User", values,"userId= ?", new String[]{user.getUserName()});
    }
}

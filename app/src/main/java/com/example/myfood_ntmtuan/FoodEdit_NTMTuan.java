package com.example.myfood_ntmtuan;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_ntmtuan.model.Food_NTMTuan;
import com.example.myfood_ntmtuan.sqlite_NTMTuan.DBHelper_NTMTuan;

import java.util.ArrayList;
import java.util.List;

public class FoodEdit_NTMTuan {

    private SQLiteDatabase db;

    public FoodEdit_NTMTuan(Context context) {
        DBHelper_NTMTuan dbHelperNtmTuan =new DBHelper_NTMTuan(context);

        db = dbHelperNtmTuan.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Food_NTMTuan> get(String sql, String ...selectArgs){
        List<Food_NTMTuan> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()){
            Food_NTMTuan food = new Food_NTMTuan();
            food.setId(cursor.getString(cursor.getColumnIndex("foodId")));
            food.setName(cursor.getString(cursor.getColumnIndex("foodName")));
            food.setType(cursor.getString(cursor.getColumnIndex("foodType")));
            food.setDescription(cursor.getString(cursor.getColumnIndex("description")));

            list.add(food);
        }

        return list;
    }

    public List<Food_NTMTuan> getAll(){
        String sql = "SELECT * FROM Food";
        return get(sql);
    }

    public Food_NTMTuan getById(String id){
        String sql = "SELECT * FROM Food WHERE foodId = ?";
        List<Food_NTMTuan> list = get(sql, id);

        return list.get(0);
    }

    public long insert(Food_NTMTuan food){
        ContentValues values = new ContentValues();
        values.put("foddId", food.getId());
        values.put("foodName", food.getName());
        values.put("foodType", food.getType());
        values.put("description", food.getDescription());

        return db.insert("Fodd", null, values);
    }

    public long update(Food_NTMTuan food){
        ContentValues values = new ContentValues();
        values.put("foodName", food.getName());
        values.put("foodType", food.getType());
        values.put("description", food.getDescription());

        return db.update("Fodd", values,"foddId= ?", new String[]{food.getId()});
    }
}

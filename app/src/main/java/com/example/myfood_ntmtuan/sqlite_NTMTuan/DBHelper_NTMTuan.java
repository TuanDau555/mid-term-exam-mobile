package com.example.myfood_ntmtuan.sqlite_NTMTuan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_NTMTuan extends SQLiteOpenHelper {
    public static final String DB_NAME = "Food_NTMTuan";
    public static final int DB_VERSION = 1;

    public DBHelper_NTMTuan(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String userSQL = "CREATE TABLE " +
                "User(" +
                "userId text primary key," +
                "name text not null," +
                "gender text not null," +
                "phone integer not null," +
                "userName text not null," +
                "password text not null)";

        String restaurantSQL = "CREATE TABLE " +
                "Restaurant(" +
                "restId text primary key," +
                "restName text not null," +
                "address text not null," +
                "phone integer not null)";

        String foodSQL = "CREATE TABLE " +
                    "Food(" +
                    "foodId text primary key," +
                    "foodName text not null," +
                    "foodType text not null," +
                    "description text not null," +
                    "restId text not null," +
                    "foreign key (restId) references Restaurant(restId))";

        sqLiteDatabase.execSQL(userSQL);
        sqLiteDatabase.execSQL(foodSQL);
        sqLiteDatabase.execSQL(restaurantSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String userSQL = "DROP TABLE IF EXISTS User";
        String restSQL = "DROP TABLE IF EXISTS Restaurant";
        String foodSQL = "DROP TABLE IF EXISTS Food";

        sqLiteDatabase.execSQL(userSQL);
        sqLiteDatabase.execSQL(restSQL);
        sqLiteDatabase.execSQL(foodSQL);
        onCreate(sqLiteDatabase);
    }

}

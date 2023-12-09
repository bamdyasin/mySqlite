package com.yasination.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MySqldata mySqldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySqldata = new MySqldata( this);
        SQLiteDatabase  sqLiteDatabase = mySqldata.getWritableDatabase();
    }
}
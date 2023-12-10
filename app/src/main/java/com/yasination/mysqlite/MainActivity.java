package com.yasination.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EditTextName,EditTextAge,EditTextGender;
    private Button btnSubmit;
    MySqldata mySqldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySqldata = new MySqldata( this);
        SQLiteDatabase  sqLiteDatabase = mySqldata.getWritableDatabase();

        EditTextName = findViewById(R.id.EditTextName);
        EditTextAge = findViewById(R.id.EditTextAge);
        EditTextGender = findViewById(R.id.EditTextGender);
        btnSubmit = findViewById(R.id.btnSubmit);




        btnSubmit.setOnClickListener(this);
    }//====================onCreate End =========================

    @Override
    public void onClick(View v) {
        String name = EditTextName.getText().toString();
        String age = EditTextAge.getText().toString();
        String gender = EditTextGender.getText().toString();


        if (v.getId() == R.id.btnSubmit){
            long rowID = mySqldata.insertData(name,age,gender);
            if (rowID ==-1){
                Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "Inserted Row "+rowID, Toast.LENGTH_SHORT).show();

            }

        }

    }






























}
package com.yasination.mysqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EditTextName,EditTextAge,EditTextGender;
    private Button btnSubmit, btnLoad;
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
        btnLoad = findViewById(R.id.btnLoad);
        btnSubmit.setOnClickListener(this);
        btnLoad.setOnClickListener(this);


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

        if (v.getId() == R.id.btnLoad){
            Cursor result = mySqldata.loadAllData();
            if (result.getCount()==0){
                showData("Error","No data found");
                return ;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (result.moveToNext()){
                stringBuffer.append("ID "+result.getString(0)+"\n");
                stringBuffer.append("Name "+result.getString(1)+"\n");
                stringBuffer.append("Age "+result.getString(2)+"\n");
                stringBuffer.append("Gender "+result.getString(3)+"\n");
            }
            showData("Rasult : ", stringBuffer.toString());
            Toast.makeText(getApplicationContext(), "Inserted Row ", Toast.LENGTH_SHORT).show();

        }





    }//=====================onClick===============

    private void  showData(String title, String data){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();

    }

}
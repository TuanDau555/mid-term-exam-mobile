package com.example.myfood_ntmtuan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfood_ntmtuan.sqlite_NTMTuan.DBHelper_NTMTuan;
import com.example.myfood_ntmtuan.sqlite_NTMTuan.Register_NTMTuan;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName, password;
    private Button registerButton;
    private String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DBHelper_NTMTuan dbHelperNtmTuan = new DBHelper_NTMTuan(this);
//        SQLiteDatabase database = dbHelperNtmTuan.getReadableDatabase();
//        database.close();
        InitializeView();
        OnEnable();
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.LogInButton_NTMTuan){
            CheckValidData();
        } else if (view.getId() == R.id.RegisterBtnLogIn_NTMTuan) {
            startActivity(new Intent(MainActivity.this, Register_NTMTuan.class));
        }
    }

    private void CheckValidData() {
        user = userName.getText().toString().trim();
        pass = password.getText().toString().trim();
        if(user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Enter UserNam and Password", Toast.LENGTH_SHORT).show();
        }
    }

    private void InitializeView(){
        userName = findViewById(R.id.userNameEt_NTMTuan);
        password = findViewById(R.id.passwordEtLogIn_NTMTuan);
        registerButton = findViewById(R.id.RegisterBtnLogIn_NTMTuan);
    }

    private void OnEnable(){
        registerButton.setOnClickListener(this);
    }
}
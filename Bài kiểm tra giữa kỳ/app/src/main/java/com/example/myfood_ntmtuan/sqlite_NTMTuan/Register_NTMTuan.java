package com.example.myfood_ntmtuan.sqlite_NTMTuan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfood_ntmtuan.MainActivity;
import com.example.myfood_ntmtuan.R;
import com.example.myfood_ntmtuan.UserEdit_NTMTuan;
import com.example.myfood_ntmtuan.model.User_NTMTuan;

public class Register_NTMTuan extends AppCompatActivity implements View.OnClickListener {

    private UserEdit_NTMTuan userEditNtmTuan;

    private EditText userName, password, rePassword;
    private Button registerButton, logInButton;
    String user, pass, rePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userEditNtmTuan = new UserEdit_NTMTuan(this);
        InitializeView();
        OnEnable();
    }

    private void InitializeView() {
        registerButton = findViewById(R.id.Registerbtn_NTMTuan);
        logInButton = findViewById(R.id.LogInBtnRegister_NTMTuan);
        userName = findViewById(R.id.userNameEtRegister_NTMTuan);
        password = findViewById(R.id.passwordEtRegister_NTMTuan);
        rePassword = findViewById(R.id.rePasswordEt_NTMTuan);
    }

    private void OnEnable(){
        registerButton.setOnClickListener(this);
        logInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.Registerbtn_NTMTuan){
            CheckValidData();
        } else if (view.getId() == R.id.LogInBtnRegister_NTMTuan) {
            startActivity(new Intent(Register_NTMTuan.this, MainActivity.class));
        }
    }

    private void CheckValidData() {
        user = userName.getText().toString().trim();
        pass = password.getText().toString().trim();
        rePass = rePassword.getText().toString().trim();
        if(user.isEmpty() || pass.isEmpty() || rePass.isEmpty()){
            Toast.makeText(this, "Enter UserNam and Password", Toast.LENGTH_SHORT).show();
        }
        else{
            RegisterUser();
        }
    }

    private void RegisterUser() {
        user = userName.getText().toString().trim();
        pass = password.getText().toString().trim();
        rePass = rePassword.getText().toString().trim();
        User_NTMTuan userNtmTuan = new User_NTMTuan();
        userNtmTuan.setUserName(user);
        userNtmTuan.setPassword(pass);
        userNtmTuan.setPhone(0);

        long result = userEditNtmTuan.insert(userNtmTuan);

        if(result > 0){
            Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Register_NTMTuan.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

}
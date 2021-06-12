package com.example.sharedpreference_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText email,password;
Button signin,signup;
    public  static final String main_key ="myPref";
    public static final  String email_key="emailKey";
    public  static final  String password_key="passKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email =findViewById(R.id.edt_email_login);
        password=findViewById(R.id.edt_password_login);
        signin=findViewById(R.id.btn_sign_In);
        signup=findViewById(R.id.btn_sign_Up);
        /////////sign in
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username,userpassword;
                username=email.getText().toString();
                userpassword=password.getText().toString();

                SharedPreferences preferences = getSharedPreferences(main_key,MODE_PRIVATE);
                String email = preferences.getString(email_key,"");
                String pws = preferences.getString(password_key,"");
                if (username.equals(email)&& userpassword.equals(pws)){
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Invalid Email & Password ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ////////sing up
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,singup.class);
                
                startActivity(i);
            }
        });
    }
}
package com.example.sharedpreference_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class singup extends AppCompatActivity {
EditText etname,etmobile,etemail,etpassword;
Button signup;

public  static final String main_key ="myPref";
    public static final  String name_key="namekey";
    public static  final String mobile_key="mobileKey";
    public static final  String email_key="emailKey";
    public  static final  String password_key="passKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        etname =findViewById(R.id.edt_name);
        etmobile =findViewById(R.id.edt_mobile);
        etemail =findViewById(R.id.edt_email);
        etpassword =findViewById(R.id.edt_password);
        signup =findViewById(R.id.btn_sign);
        ////method
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(main_key,MODE_PRIVATE);
                String name,mobile,email,password;
                name=etname.getText().toString();
                mobile=etmobile.getText().toString();
                email=etemail.getText().toString();
                password=etpassword.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(name_key,name);
                editor.putString(mobile_key,mobile);
                editor.putString(email_key,email);
                editor.putString(password_key,password);
                editor.commit();

                Intent intent =new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}
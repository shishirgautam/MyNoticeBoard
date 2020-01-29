package com.shishir.onlinenoticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText Email, Password, Confirmpassword;
    private Button Signup, LinkToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //binding
        Email = findViewById(R.id.etusername);
        Password = findViewById(R.id.uppassword);
        Confirmpassword = findViewById(R.id.con_password);
        Signup = findViewById(R.id.btn_signup);
        LinkToLogin = findViewById(R.id.btnLinkToLoginScreen);

        LinkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

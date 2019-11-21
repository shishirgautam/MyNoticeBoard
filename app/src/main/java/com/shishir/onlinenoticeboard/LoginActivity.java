package com.shishir.onlinenoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText Email,Password;
    private Button login;

    String user,pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.etemail);
        Password = findViewById(R.id.etpassword);

        login = findViewById(R.id.btn_login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Email.getText().toString().trim();
                pwd = Password.getText().toString().trim();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Email.getText().toString().trim();
                pwd = Password.getText().toString().trim();
//                if (user.equals("ad")&& pwd.equals("ad")) {
//                        Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
//                        startActivity(intent);
//
//                    }


                if (!user.isEmpty()&& !pwd.isEmpty()){
                    if (user.equals("admin")&& pwd.equals("admin")) {
                        Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(intent);

                    }
                }

                else{
                    if (user.isEmpty()){
                        Email.setError("Enter User Name");
                    }
                    if (pwd.isEmpty()){
                        Email.setError("Enter Password ");
                    }
                }
            }

        });


    }
    }


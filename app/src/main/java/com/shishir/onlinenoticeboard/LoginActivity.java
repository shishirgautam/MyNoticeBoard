package com.shishir.onlinenoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("username", Email.getText().toString());
                        editor.putString("password",Password.getText().toString());
                        editor.commit();
                        //Toast.makeText(LoginActivity.this, "sucessfully save", Toast.LENGTH_SHORT).show();


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


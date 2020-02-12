package com.shishir.onlinenoticeboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shishir.onlinenoticeboard.StrictMode.StrictModeC;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.model.UserModel;
import com.shishir.onlinenoticeboard.response.LoginRegisterResponse;


public class LoginActivity extends AppCompatActivity {
    private EditText Username, Password;
    private Button login, link;
    public static String Token = "";
    Context context;
    boolean isSuccess = false;
    LoginRegisterResponse model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.etusername);
        Password = findViewById(R.id.etpassword);
        login = findViewById(R.id.btn_login);
        link = findViewById(R.id.btnLink);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

    }

    private void check() {
        String user = Username.getText().toString();
        String pass = Password.getText().toString();

        if (TextUtils.isEmpty(Username.getText())) {
            Username.setError("Enter username");
            return;

        } else if (TextUtils.isEmpty(Password.getText())) {
            Password.setError("Enter password");
            return;
        }

        UserModel userModel = new UserModel(user, pass);

        StrictModeC.StrictMode();
        BLL bll = new BLL();
        boolean loggedIn = bll.LoginBLL(userModel);
        Toast.makeText(this, loggedIn + "", Toast.LENGTH_SHORT).show();
        if (loggedIn) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show();
        }

    }

}




package com.shishir.onlinenoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shishir.onlinenoticeboard.api.LoginBLL;
import com.shishir.onlinenoticeboard.model.InputUser;
import com.shishir.onlinenoticeboard.model.userModel;
import com.shishir.onlinenoticeboard.strictMode.StrictModeC;

public class LoginActivity extends AppCompatActivity {
    private EditText Email,Password;
    private Button login,link;
    public static String Token = "";
    String user,pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.etemail);
        Password = findViewById(R.id.etpassword);

        login = findViewById(R.id.btn_login);
        link = findViewById(R.id.btnLink);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Email.getText().toString().trim();
                pwd = Password.getText().toString().trim();

                if (!TextUtils.isEmpty(Email.getText().toString() )) {
                    if (!TextUtils.isEmpty(Password.getText().toString() )) {
                        userModel userModel = new userModel(Email.getText().toString(),
                                Password.getText().toString());
                                login(userModel);
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
    public boolean login(userModel u) {
        LoginBLL loginBLL = new LoginBLL();
        StrictModeC.StrictMode();
        if (loginBLL.checkUser( u.getEmail(), u.getPassword() )) {
            Store( u );
            Intent intent = new Intent( LoginActivity.this, DashboardActivity.class );
            Token = loginBLL.Token;
            startActivity( intent );
            //Toast.makeText( this, "welcome "+loginBLL.Token,Toast.LENGTH_SHORT ).show();
            return true;
        }
        Toast.makeText( this, "Either username or password is incorrect", Toast.LENGTH_SHORT ).show();
        return false;

    }





    void Store(userModel u) {

        SharedPreferences sharedPreferences = getSharedPreferences( "User", MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString( "username", u.getEmail() );
        editor.putString( "password", u.getPassword() );
        //Toast.makeText( this, "saved user", Toast.LENGTH_SHORT ).show();
        editor.commit();

    }
    }


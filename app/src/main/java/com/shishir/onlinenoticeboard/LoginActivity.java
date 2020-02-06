package com.shishir.onlinenoticeboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shishir.onlinenoticeboard.StrictMode.StrictModeC;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.model.UserModel;
import com.shishir.onlinenoticeboard.model.checkUser;
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

//        link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });

        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        if (token.equals(" ")) {

        } else {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }

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

        private void check(){
            String user = Username.getText().toString();
            String pass = Password.getText().toString();

            if (TextUtils.isEmpty(Username.getText())) {
                Username.setError("Enter username");
                return;

            } else if (TextUtils.isEmpty(Password.getText())) {
                Password.setError("Enter password");
                return;
            }


            StrictModeC.StrictMode();
            checkUser checkUser = new checkUser(user, pass);
            model = checkUser.checkUser();
            if (checkUser.checkUser() != null) {

                Intent intent = new Intent(LoginActivity.this, ViewsActivity.class);
                startActivity(intent);

                SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();

//                editor.putString("username", model.getResult().getUsername());
//                editor.putString("id", model.getResult().getId());
//                editor.putString("password", model.getResult().getPassword());
//                editor.putString("token", "Token " + model.getToken());
//                editor.commit();




                SharedPreferences sharedPreferences1 = getSharedPreferences("User", MODE_PRIVATE);
                String tk = sharedPreferences1.getString("token", "");
                Token = tk;
                finish();

            } else {
                Toast.makeText(this, "Invalid username and password", Toast.LENGTH_SHORT).show();


            }

        }

        }




package com.shishir.onlinenoticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shishir.onlinenoticeboard.model.userModel;

public class RegisterActivity extends AppCompatActivity {
    private EditText Email, Password, Confirmpassword;
    private Button Signup, LinkToLogin;
    String user,pwd;

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
                user = Email.getText().toString().trim();
                pwd = Password.getText().toString().trim();

                if (!TextUtils.isEmpty(Email.getText().toString() )) {
                    if (!TextUtils.isEmpty(Password.getText().toString() )) {
                        userModel userModel = new userModel(Email.getText().toString(),
                                Password.getText().toString());
                        register(userModel);
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
    public boolean register(userModel u) {

        Toast.makeText( this, "clicked register button", Toast.LENGTH_SHORT ).show();
        return false;
    }
}

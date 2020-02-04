package com.shishir.onlinenoticeboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.model.UserModel;

public class RegisterActivity extends AppCompatActivity {
    private EditText username, email, password,mobileno;
    private Button Signup, LinkToLogin;
    Context context;
    //String user,pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = this;
        //binding
        username = findViewById(R.id.etusername);
        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
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
                UserModel model = new UserModel(username.getText().toString(),"email.com","password","dummy image","9827349","temporary Address","permanenent Address");
                BLL BLL = new BLL();

                if(BLL.Register(model)){
                    Toast.makeText(context,"Register Successful",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"User Not Registered",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public boolean register(UserModel u) {

        Toast.makeText( this, "clicked Register button", Toast.LENGTH_SHORT ).show();
        return false;
    }
}

package com.shishir.onlinenoticeboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.model.UserModel;

public class RegisterActivity extends AppCompatActivity {
    private EditText username, email, password, mobileno;
    private Button signup, linkToLogin;
    Context context;
    AwesomeValidation awesomeValidation;
    //String user,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        context = this;
        //binding
        username = findViewById(R.id.etsusername);
        email = findViewById(R.id.etsemail);
        password = findViewById(R.id.etspassword);
        mobileno = findViewById(R.id.etsmobile);
        signup = findViewById(R.id.btn_signup);
        linkToLogin = findViewById(R.id.btnLinkToLoginScreen);

        String regexPassword = "^^([a-zA-Z0-9@*#]{2,15})$";
        awesomeValidation.addValidation(RegisterActivity.this, R.id.etsusername, "^.{2,15}$", R.string.usernameerr);
        awesomeValidation.addValidation(RegisterActivity.this, R.id.etsemail, android.util.Patterns.EMAIL_ADDRESS, R.string.emailerr);
        awesomeValidation.addValidation(RegisterActivity.this, R.id.etspassword, regexPassword, R.string.passworderr);
        awesomeValidation.addValidation(RegisterActivity.this, R.id.etsmobile, RegexTemplate.NOT_EMPTY, R.string.mobilenoerr);


        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel model = new UserModel(
                        username.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString()
                        , "dummyimage.jpg",
                        mobileno.getText().toString(),
                        "temporary Addreess",
                        "Kathmandu");

//
                BLL BLL = new BLL();
                if(awesomeValidation.validate()){
                    if (BLL.RegisterBLL(model)) {
                        Toast.makeText(context, "Successfully Register ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(context, "User Not Registered", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context, "Data is not Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}

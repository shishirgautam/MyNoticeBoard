package com.shishir.onlinenoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.model.UserModel;


public class LoginActivity extends AppCompatActivity {
    private EditText Username,Password;
    private Button login,link;
    public static String Token = "";
    Context context;



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
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BLL BLL = new BLL();
                UserModel model = new UserModel(Username.getText().toString(),Password.getText().toString());
                if(BLL.LoginBLL(model)){
                    Toast.makeText(context,"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ViewsActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(context,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
//    public boolean login(UserModel u) {
//        BLL loginBLL = new BLL();
//        StrictModeC.StrictMode();
//        if (loginBLL.checkUser( u.getEmail(), u.getPassword() )) {
//            Store( u );
//            Intent intent = new Intent( LoginActivity.this, DashboardActivity.class );
//            Token = loginBLL.Token;
//            startActivity( intent );
//            //Toast.makeText( this, "welcome "+loginBLL.Token,Toast.LENGTH_SHORT ).show();
//            return true;
//        }
//        Toast.makeText( this, "Either username or password is incorrect", Toast.LENGTH_SHORT ).show();
//        return false;
//
//    }
//




//    void Store(UserModel u) {
//
//        SharedPreferences sharedPreferences = getSharedPreferences( "User", MODE_PRIVATE );
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString( "username", u.getEmail() );
//        editor.putString( "password", u.getPassword() );
//        //Toast.makeText( this, "saved user", Toast.LENGTH_SHORT ).show();
//        editor.commit();
//
//    }
    }


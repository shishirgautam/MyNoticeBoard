package com.shishir.onlinenoticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
                String username = sharedPreferences.getString("username","");
                String password = sharedPreferences.getString("password","");


                if (username.equals("admin") && password.equals("admin")){
//                    Intent intent = new Intent(SplashActivity.this,DashboardActivity.class);
//                    startActivity(intent);
//                    finish();
                 }
                else {
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },2000);
    }
}

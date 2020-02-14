package com.shishir.onlinenoticeboard;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    Context context;
    private RecyclerView recyclerView;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        toolbar = getSupportActionBar();
        context = this;

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.dashboard_container,new HomeFragment())
//                .commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //  Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.dashboard_container,new HomeFragment())
//                            .commit();
                        return true;

                    case R.id.navigation_comment:
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.dashboard_container,new CommentFragment())
//                            .commit();
                        return true;

                    case R.id.navigation_profile:
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.dashboard_container,new ProfileFragment())
//                            .commit();
                        return true;
                }
                return false;
            }

//            private void loadFragment(Fragment fragment) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.dashboard_container, fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
        });
    }
}

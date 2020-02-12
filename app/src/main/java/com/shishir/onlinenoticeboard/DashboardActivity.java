package com.shishir.onlinenoticeboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shishir.onlinenoticeboard.ui.comment.CommentFragment;
import com.shishir.onlinenoticeboard.ui.home.HomeFragment;
import com.shishir.onlinenoticeboard.ui.profile.ProfileFragment;

public class DashboardActivity extends AppCompatActivity {
    Context context;
    private RecyclerView recyclerView;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navView = findViewById(R.id.nav_view);
//        toolbar.setTitle("Home");
        toolbar = getSupportActionBar();
        context = this;


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_comment, R.id.navigation_profile)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.dashboard_container);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);



        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(context,"Home",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.dashboard_container,new HomeFragment())
                            .commit();
                    return true;

                case R.id.navigation_comment:
                    Toast.makeText(context,"comment",Toast.LENGTH_SHORT).show();
//                    toolbar.setTitle("Comment");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.dashboard_container,new CommentFragment())
                            .commit();
                    return true;

                case R.id.navigation_profile:
                    Toast.makeText(context,"profile",Toast.LENGTH_SHORT).show();
    //                toolbar.setTitle("Profile");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.dashboard_container,new ProfileFragment())
                            .commit();
                    return true;


            }
            return false;

            }
            private void loadFragment(Fragment fragment) {
                // load fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.dashboard_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });




//        RetrofitInterface api = RetrofitApi.getInstance().create(RetrofitInterface.class);
//        Call<List<NoticeModel>> listCall = api.Notice(BLL.token);
//        listCall.enqueue(new Callback<List<NoticeModel>>() {
//            @Override
//            public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), "Token has expired, login again", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                List<NoticeModel> modelList = response.body();
//                NoticeAdapter adapter = new NoticeAdapter(DashboardActivity.this, modelList);
//
//                recyclerView.setAdapter(adapter);
//                recyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));
//            }
//
//            @Override
//            public void onFailure(Call<List<NoticeModel>> call, Throwable t) {
//
//            }
//        });





    }
}

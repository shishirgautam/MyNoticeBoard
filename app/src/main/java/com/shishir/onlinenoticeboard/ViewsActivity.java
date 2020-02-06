package com.shishir.onlinenoticeboard;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shishir.onlinenoticeboard.StrictMode.StrictModeC;
import com.shishir.onlinenoticeboard.adapter.NoticeAdapter;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.api.RetrofitApi;
import com.shishir.onlinenoticeboard.api.RetrofitInterface;
import com.shishir.onlinenoticeboard.model.NoticeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
//        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_post, R.id.navigation_profile)
                .build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);


        recyclerView=findViewById(R.id.notices_container);

        RetrofitInterface api = RetrofitApi.getInstance().create(RetrofitInterface.class);
        Call<List<NoticeModel>> listCall = api.Notice(BLL.token);
        listCall.enqueue(new Callback<List<NoticeModel>>() {
            @Override
            public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Token has expired, login again", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<NoticeModel> modelList = response.body();
                NoticeAdapter adapter = new NoticeAdapter(ViewsActivity.this, modelList);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ViewsActivity.this));
            }

            @Override
            public void onFailure(Call<List<NoticeModel>> call, Throwable t) {

            }
        });




    }

}

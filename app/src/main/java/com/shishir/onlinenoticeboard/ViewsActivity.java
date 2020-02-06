package com.shishir.onlinenoticeboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shishir.onlinenoticeboard.StrictMode.StrictModeC;
import com.shishir.onlinenoticeboard.adapter.NoticeAdapter;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.model.NoticeModel;

import java.util.ArrayList;
import java.util.List;

public class ViewsActivity extends AppCompatActivity {


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

        RecyclerView notices = findViewById(R.id.notices_container);
        notices.setLayoutManager(new LinearLayoutManager(this));

        StrictModeC.StrictMode();
        BLL bll = new BLL();
        List<NoticeModel> noticeModelList = new ArrayList<>();
        noticeModelList.addAll(bll.NoticeBLL());

        NoticeAdapter noticeAdapter = new NoticeAdapter(this, noticeModelList);
        notices.setAdapter(noticeAdapter);


    }

}

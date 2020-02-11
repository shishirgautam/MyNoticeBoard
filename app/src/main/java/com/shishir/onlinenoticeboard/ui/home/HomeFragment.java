package com.shishir.onlinenoticeboard.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shishir.onlinenoticeboard.DashboardActivity;
import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.adapter.NoticeAdapter;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.api.RetrofitApi;
import com.shishir.onlinenoticeboard.api.RetrofitInterface;
import com.shishir.onlinenoticeboard.model.NoticeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    Context context;
    RecyclerView recyclerView;
    private  TextView Title,Description,Comment;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.notices_container);

        context = getContext();
        RetrofitInterface api = RetrofitApi.getInstance().create(RetrofitInterface.class);
        Call<List<NoticeModel>> listCall = api.Notice(BLL.token);
        listCall.enqueue(new Callback<List<NoticeModel>>() {
            @Override
            public void onResponse(Call<List<NoticeModel>> call, Response<List<NoticeModel>> response) {
                if (!response.isSuccessful()){

                    Toast.makeText(getContext(), "Token has expired , login again", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<NoticeModel> modelList = response.body();
                NoticeAdapter adapter = new NoticeAdapter(getContext(),modelList);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void onFailure(Call<List<NoticeModel>> call, Throwable t) {

            }
        });



        return root;


    }



}
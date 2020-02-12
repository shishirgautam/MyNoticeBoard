package com.shishir.onlinenoticeboard.ui.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.StrictMode.StrictModeC;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.api.RetrofitApi;
import com.shishir.onlinenoticeboard.api.RetrofitInterface;
import com.shishir.onlinenoticeboard.model.NoticeModel;
import com.shishir.onlinenoticeboard.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    private ImageView imgprofile;
    private EditText pUsername,pEmail,pAddress,pMob;
    Context context;
    RecyclerView recyclerView;


    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        context = getContext();
        recyclerView = root.findViewById(R.id.profile_container);

        //binding
        imgprofile = root.findViewById(R.id.imgpro);
        pUsername = root.findViewById(R.id.epusername);
        pEmail = root.findViewById(R.id.epemail);
        pAddress = root.findViewById(R.id.epaddress);
        pMob = root.findViewById(R.id.epmobile);


    RetrofitInterface api = RetrofitApi.getInstance().create(RetrofitInterface.class);
        StrictModeC.StrictMode();


        final Call<List<UserModel>> getUserProfiles = api.getUserProfiles();
        getUserProfiles.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                UserModel model = new UserModel(pUsername.getText().toString(),pEmail.getText().toString());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });




        return root;

    }

}
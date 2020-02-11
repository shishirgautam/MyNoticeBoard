package com.shishir.onlinenoticeboard.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.model.UserModel;

public class ProfileFragment extends Fragment {
    private ImageView imgprofile;
    private EditText pUsername,pEmail,pAddress,pMob;


    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {


        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        //binding
        imgprofile = root.findViewById(R.id.imgpro);
        pUsername = root.findViewById(R.id.epusername);
        pEmail = root.findViewById(R.id.epemail);
        pAddress = root.findViewById(R.id.epaddress);
        pMob = root.findViewById(R.id.epmobile);

        return root;

     //UserModel uModel = new UserModel();
    }



}
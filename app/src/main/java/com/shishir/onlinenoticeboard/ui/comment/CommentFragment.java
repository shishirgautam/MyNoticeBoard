package com.shishir.onlinenoticeboard.ui.comment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.shishir.onlinenoticeboard.R;

public class CommentFragment extends Fragment {

    private CommentViewModel homeViewModel;
    String postid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(CommentViewModel.class);
        View root = inflater.inflate(R.layout.noticedetail_viewholder, container, false);

        Bundle bundle = getArguments();
        if(bundle!=null){
            postid = bundle.getString("postid");
        }



        return root;
    }
}
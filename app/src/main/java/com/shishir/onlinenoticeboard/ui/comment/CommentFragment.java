package com.shishir.onlinenoticeboard.ui.comment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.shishir.onlinenoticeboard.R;

public class CommentFragment extends Fragment {

    private DashboardViewModel homeViewModel;
    String postid;
    TextView textViewTitle,textViewPost;
    EditText editTextComment;
    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel = ViewModelProviders.of(this).get(CommentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_comment, container, false);

        Bundle bundle = getArguments();
        if(bundle!=null){
            postid = bundle.getString("postid");
        }

        textViewTitle = root.findViewById(R.id.ptitle);
        textViewPost = root.findViewById(R.id.post);
        editTextComment = root.findViewById(R.id.comment);
        button = root.findViewById(R.id.pushcomment);

//        textViewTitle.setText(bundle.getString("title"));
//        textViewPost.setText(bundle.getString("post"));

        return root;
    }
}
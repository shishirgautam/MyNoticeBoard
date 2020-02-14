package com.shishir.onlinenoticeboard.ui.comment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.api.RetrofitApi;
import com.shishir.onlinenoticeboard.api.RetrofitInterface;
import com.shishir.onlinenoticeboard.model.CommentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitInterface ri = RetrofitApi.getInstance().create(RetrofitInterface.class);
                Call<CommentModel> commentModelCall = ri.postComments(BLL.token,editTextComment.getText().toString(),postid);
                commentModelCall.enqueue(new Callback<CommentModel>() {
                    @Override
                    public void onResponse(Call<CommentModel> call, Response<CommentModel> response) {
                        Toast.makeText(getContext(), "Done"+ response.code(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CommentModel> call, Throwable t) {
                        Log.d("Myex:", t.getMessage());
                    }
                });
            }
        });

//        textViewTitle.setText(bundle.getString("title"));
//        textViewPost.setText(bundle.getString("post"));

        return root;
    }
}
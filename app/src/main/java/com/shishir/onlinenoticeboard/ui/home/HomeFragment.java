package com.shishir.onlinenoticeboard.ui.home;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.api.BLL;
import com.shishir.onlinenoticeboard.api.RetrofitApi;
import com.shishir.onlinenoticeboard.api.RetrofitInterface;
import com.shishir.onlinenoticeboard.model.NoticeModel;
import com.shishir.onlinenoticeboard.ui.comment.CommentFragment;


import java.util.List;


import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    Context context;
    RecyclerView recyclerView;
    private  TextView Title,Description,Comment;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.dashboard_container);

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


    public static class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
        Context context;
        List<NoticeModel> NoticeModels;

        public NoticeAdapter(Context context, List<NoticeModel> noticeModels) {
            this.context = context;
            this.NoticeModels = noticeModels;
        }

        @NonNull
        @Override
        public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticedetail_viewholder, viewGroup, false);
            return new NoticeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final NoticeViewHolder noticeViewHolder, int i) {
            final NoticeModel model = NoticeModels.get(i);
            noticeViewHolder.textViewId.setText(model.getId());
            noticeViewHolder.title.setText(model.getTitle());
            noticeViewHolder.description.setText(model.getDescription());
            noticeViewHolder.buttonComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StartComment(noticeViewHolder.textViewId.getText().toString(),
                            noticeViewHolder.title.getText().toString(),
                            noticeViewHolder.description.getText().toString());
                }
            });
        }

        @Override
        public int getItemCount() {
            return NoticeModels.size();
        }

        public void StartComment(String PostID, String title, String post){
            CommentFragment commentFragment= new CommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("postid",PostID);
            bundle.putString("title",title);
            bundle.putString("post",post);
            commentFragment.setArguments(bundle);
            ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dashboard_container,commentFragment)
                    .commit();
        }

        public class NoticeViewHolder extends RecyclerView.ViewHolder {

            CircleImageView imgview;
            TextView title, description, comment ,textViewId;
            Button pushcomment;
            ImageButton buttonComment;

            public NoticeViewHolder(@NonNull View noticeView) {
                super(noticeView);
                // imgview = noticeView.findViewById(R.id.imgview);
                textViewId = noticeView.findViewById(R.id.pid);
                title = noticeView.findViewById(R.id.title);
                description = noticeView.findViewById(R.id.desc);
                pushcomment = noticeView.findViewById(R.id.pushcomment);
                buttonComment = noticeView.findViewById(R.id.commid);
            }
        }
    }
}
package com.shishir.onlinenoticeboard.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shishir.onlinenoticeboard.DashboardActivity;
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

    public void StartComment(String PostID){
        CommentFragment commentFragment = new CommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("postid",PostID);
        commentFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.dashboard_container,commentFragment)
                .commit();
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
        public void onBindViewHolder(@NonNull NoticeViewHolder noticeViewHolder, int i) {
            final NoticeModel model = NoticeModels.get(i);
            noticeViewHolder.title.setText(model.getTitle());
            noticeViewHolder.description.setText(model.getDescription());
            noticeViewHolder.buttonComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return NoticeModels.size();
        }

        public class NoticeViewHolder extends RecyclerView.ViewHolder {

            CircleImageView imgview;
            TextView title, description, comment;
            Button buttonComment;

            public NoticeViewHolder(@NonNull View noticeView) {
                super(noticeView);

    //            imgview = noticeView.findViewById(R.id.imgview);
                title = noticeView.findViewById(R.id.title);
                description = noticeView.findViewById(R.id.desc);
                buttonComment = noticeView.findViewById(R.id.commid);


            }
        }
    }
}
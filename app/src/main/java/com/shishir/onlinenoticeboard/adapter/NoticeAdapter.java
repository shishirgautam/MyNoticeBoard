package com.shishir.onlinenoticeboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.model.NoticeModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    Context context;
    List<NoticeModel> NoticeModels;

    public NoticeAdapter(Context context, List<NoticeModel> noticeModels) {
        this.context = context;
        this.NoticeModels = noticeModels;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_home, viewGroup, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder noticeViewHolder, int i) {
        final NoticeModel model = NoticeModels.get(i);
        noticeViewHolder.title.setText(model.getTitle());
        noticeViewHolder.description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return NoticeModels.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgview;
        TextView title, description, comment;

        public NoticeViewHolder(@NonNull View noticeView) {
            super(noticeView);

            imgview = noticeView.findViewById(R.id.imgview);
            title = noticeView.findViewById(R.id.title);
            description = noticeView.findViewById(R.id.desc);


        }
    }
}

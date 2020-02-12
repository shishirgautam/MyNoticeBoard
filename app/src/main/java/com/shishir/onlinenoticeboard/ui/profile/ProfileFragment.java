package com.shishir.onlinenoticeboard.ui.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.shishir.onlinenoticeboard.R;
import com.shishir.onlinenoticeboard.StrictMode.StrictModeC;
import com.shishir.onlinenoticeboard.api.RetrofitApi;
import com.shishir.onlinenoticeboard.api.RetrofitInterface;
import com.shishir.onlinenoticeboard.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    private ImageView imgprofile;
    private EditText pUsername, pEmail, pAddress, pMob;
    Context context;


    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        context = getContext();


//       // binding
//        imgprofile = root.findViewById(R.id.imgpro);
//        pUsername = root.findViewById(R.id.epusername);
//        pEmail = root.findViewById(R.id.epemail);
//        pAddress = root.findViewById(R.id.epaddress);
//        pMob = root.findViewById(R.id.epmobile);


        final RetrofitInterface api = RetrofitApi.getInstance().create(RetrofitInterface.class);
        StrictModeC.StrictMode();


        final Call<UserModel> getUserProfiles = api.getUserProfiles();
        getUserProfiles.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StrictModeC.StrictMode();
                try {
                    String Id = response.body().getId();
                    String pUsername = response.body().getUsername();
                    String pEmail = response.body().getEmail();
                    String pMob = response.body().getMobileNumber();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });


        return root;

    }

//    public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>{
//        Context context;
//        List<UserModel> userModels;
//
//        public UserProfileAdapter(Context context, List<UserModel> userModels) {
//            this.context = context;
//            this.userModels = userModels;
//        }
//
//        @NonNull
//        @Override
//        public UserProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//          View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_profile,viewGroup,false);
//          return new UserProfileViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull UserProfileViewHolder userProfileViewHolder, int position) {
//            final UserModel model = userModels.get(position);
//            userProfileViewHolder.pUsername.setText(model.getUsername());
//            userProfileViewHolder.pEmail.setText(model.getEmail());
//            userProfileViewHolder.pMob.setText(model.getMobileNumber());
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//
//        public class UserProfileViewHolder extends RecyclerView.ViewHolder {
//            CircleImageView imgprofile;
//            TextView pUsername, pEmail, pAddress,pMob;
//
//
//            public UserProfileViewHolder(@NonNull View profileView) {
//                super(profileView);
//                imgprofile = profileView.findViewById(R.id.imgpro);
//                pUsername = profileView.findViewById(R.id.epusername);
//                pEmail = profileView.findViewById(R.id.epemail);
//                pAddress = profileView.findViewById(R.id.epaddress);
//                pMob = profileView.findViewById(R.id.epmobile);
//            }
//        }
//    }

}
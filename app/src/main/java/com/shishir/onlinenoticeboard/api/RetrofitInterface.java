package com.shishir.onlinenoticeboard.api;

import com.shishir.onlinenoticeboard.model.Inputuser;
import com.shishir.onlinenoticeboard.model.LoginResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("/users/login")
    Call<LoginResult>executeLogin(@Field("email") String username, @Field("password") String password);

    @POST("/users/register")
    Call<LoginResult> register(@Body Inputuser body);
}

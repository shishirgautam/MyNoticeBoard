package com.shishir.onlinenoticeboard.api;

import com.shishir.onlinenoticeboard.model.InputUser;
import com.shishir.onlinenoticeboard.model.LoginResult;
import com.shishir.onlinenoticeboard.model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST("/users/Register")
    Call<ResponseBody>Loginexecute(
            @Field("username") String username,
            @Field("email")String email,
            @Field("password") String password,
            @Field("image")String image,
            @Field("mobile_number")String mobile_number,
            @Field("temporary_address") String temporary_addrrss,
            @Field("permanent_address")String permanent_address
    );
    @FormUrlEncoded
    @POST("/users/login")
    Call<UserModel> Login(
            @Field("email") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("/users/Register")
    Call<UserModel> Register(
            @Field("username") String username,
            @Field("email")String email,
            @Field("password") String password,
            @Field("image")String image,
            @Field("mobile_number")String mobile_number,
            @Field("temporary_address") String temporary_addrrss,
            @Field("permanent_address")String permanent_address
    );
}

package com.shishir.onlinenoticeboard.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static  final RetrofitApi ourInstance = new RetrofitApi();

    public static RetrofitApi getInstance(){
        return ourInstance;
    }

    public RetrofitInterface getRetrofitInterface() {
         Retrofit.Builder builder =  new Retrofit.Builder()
                .baseUrl("http://10.0.02.2:8899/")
                .addConverterFactory(GsonConverterFactory.create());
         Retrofit retrofit = builder.build();
         return retrofit.create(RetrofitInterface.class);
    }
}

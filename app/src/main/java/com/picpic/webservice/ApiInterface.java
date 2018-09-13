package com.picpic.webservice;

import com.picpic.models.Posts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @GET("posts.php")
    Call<List<Posts>> getAllPosts();

    @FormUrlEncoded
    @GET("myPosts.php")
    Call<List<Posts>> getAllMyPosts(@Field("id") String userId , @Field("from") int from , @Field("to") int to);


    @POST("register.php")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("username") String username , @Field("password") String password );

    @POST("login.php")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("username") String username , @Field("password") String password );



}

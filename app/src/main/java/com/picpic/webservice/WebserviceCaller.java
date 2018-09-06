package com.picpic.webservice;

import com.picpic.Utils.PostAdapter;
import com.picpic.models.IMessageListener;
import com.picpic.models.Posts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    ApiInterface apiInterface;

    public WebserviceCaller() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getAllPosts(final IMessageListener iMessageListener) {

        Call<List<Posts>> posts = apiInterface.getAllPosts();

        posts.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                iMessageListener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                iMessageListener.onError(t.getMessage().toString());
            }
        });

    }

    public void register(String user, String password, final IMessageListener iMessageListener) {

        Call<ResponseBody> registerUser = apiInterface.register(user, password);

        registerUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                iMessageListener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                iMessageListener.onError(t.getMessage().toString());
            }
        });


    }


}

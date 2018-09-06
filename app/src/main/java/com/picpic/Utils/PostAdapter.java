package com.picpic.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jackandphantom.circularimageview.CircleImage;
import com.picpic.R;
import com.picpic.models.Images;
import com.picpic.models.Posts;
import com.picpic.webservice.ApiClient;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.SimpleViewHolder> {

    List<Posts> postsList;
    Context context;

    public PostAdapter(Context context, List<Posts> posts) {
        this.context = context;
        postsList = posts;
    }


    @Override
    public PostAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_post, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostAdapter.SimpleViewHolder holder, int position) {
/*
        for (int b=0;b<3;b++){

            holder.txt_like.setText("29600");
            holder.img_Post.setImageResource(R.drawable.profile);
            holder.img_Profile.setImageResource(R.drawable.profile);


        }*/

        Posts posts = postsList.get(position);
        holder.txt_like.setText(posts.getLikeNumber() + "");
        //holder.

        try {
            List<Images> imagesList = JsonParser.getImagesList(posts.getImages());

            //Glide.with(context).load(ApiClient.BASE_URl+"images/"+imagesList.get(0)).into(holder.img_Post);
            Log.e("Glide",ApiClient.BASE_URl+"images/"+imagesList.get(0).getImage().toString());

            Picasso.get().load(ApiClient.BASE_URl+"images/"+imagesList.get(0).getImage().toString())
                    .into(holder.img_Post);

        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.txt_description.setText(posts.getDescription());



     /*   List<Images> imagesList = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(posts.getImages());

            for(int i =0 ; i<jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Images images = new Images();
                images.setImage(jsonObject.getString("img"));
                imagesList.add(images);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }*/


    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {

        private CircleImage img_Profile;
        private ImageView img_Post;
        private TextView txt_like;

        @BindView(R.id.txt_description)
        AppCompatTextView txt_description;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            img_Profile = itemView.findViewById(R.id.circle_img_profile);
            img_Post = itemView.findViewById(R.id.img_post);
            txt_like = itemView.findViewById(R.id.txt_num_likes);
        }
    }

}

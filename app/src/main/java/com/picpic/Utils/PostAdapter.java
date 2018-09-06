package com.picpic.Utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackandphantom.circularimageview.CircleImage;
import com.picpic.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.SimpleViewHolder> {



    @Override
    public PostAdapter.SimpleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_post,parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostAdapter.SimpleViewHolder holder, int position) {

        for (int b=0;b<3;b++){

            holder.txt_like.setText("29600");
            holder.img_Post.setImageResource(R.drawable.profile);
            holder.img_Profile.setImageResource(R.drawable.profile);


        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {

        private CircleImage img_Profile;
        private ImageView img_Post;
        private TextView txt_like;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);

            img_Profile=itemView.findViewById(R.id.circle_img_profile);
            img_Post=itemView.findViewById(R.id.img_post);
            txt_like=itemView.findViewById(R.id.txt_num_likes);
        }
    }

}

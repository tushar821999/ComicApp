package com.androidgits.animation.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidgits.animation.activities.AnimeActivity;
import com.androidgits.animation.model.Anime;
import com.androidgits.animation.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 5/9/2018.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>{
    ArrayList<String> savedcomics = new ArrayList<String>();
    private Context mcontext;
    private List<Anime> mData;

    public RvAdapter(Context mcontext, List<Anime> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mcontext);
        View view = mInflater.inflate(R.layout.row,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mcontext,AnimeActivity.class);
                Bundle args = new Bundle();
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                mcontext.startActivity(i);
            }
        });

        viewHolder.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mcontext, mData.get(viewHolder.getAdapterPosition()).getName()+" Saved", Toast.LENGTH_SHORT).show();
                savedcomics.add(mData.get(viewHolder.getAdapterPosition()).getName());
                for (int i = 0; i < savedcomics.size(); i++) {
                    Toast.makeText(mcontext, savedcomics.get(i), Toast.LENGTH_SHORT).show();
                }

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvname.setText(mData.get(position).getName());
        holder.tv_rate.setText(mData.get(position).getRating());
        holder.tvstudio.setText(mData.get(position).getStudio());
        holder.tvcat.setText(mData.get(position).getCategorie());

//        Glide.with(mcontext).load(mData.get(position).getImage_url())
//                .centerCrop()
//                .placeholder(R.drawable.loading_image)
//                .error(R.drawable.error_image)
//                .into(holder.AnimeThumbnail);
        Picasso.with(mcontext).load(mData.get(position).getImage_url())
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.error_image)
                .into(holder.AnimeThumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvname,tv_rate,tvstudio,tvcat;
        ImageView AnimeThumbnail;
        LinearLayout view_container;
        ImageButton saveButton;
        public MyViewHolder(View itemView) {
            super(itemView);
            saveButton = (ImageButton) itemView.findViewById(R.id.saveButton);
            view_container = (LinearLayout) itemView.findViewById(R.id.container);
            tvname = (TextView) itemView.findViewById(R.id.rowname);
            tv_rate = (TextView) itemView.findViewById(R.id.rating);
            tvstudio = (TextView) itemView.findViewById(R.id.studio);
            tvcat = (TextView) itemView.findViewById(R.id.categorie);
            AnimeThumbnail = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

package com.androidgits.animation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidgits.animation.model.Anime;
import com.androidgits.animation.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Lenovo on 5/9/2018.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>{


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
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
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
        public MyViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.rowname);
            tv_rate = (TextView) itemView.findViewById(R.id.rating);
            tvstudio = (TextView) itemView.findViewById(R.id.studio);
            tvcat = (TextView) itemView.findViewById(R.id.categorie);
            AnimeThumbnail = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

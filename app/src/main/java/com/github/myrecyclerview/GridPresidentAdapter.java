package com.github.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Kei Lazu on 9/5/2018
 * check https://github.com/KeiLazu for more
 */
public class GridPresidentAdapter extends RecyclerView.Adapter<GridPresidentAdapter.GridViewHolder> {
    Context context;
    ArrayList<President> presidentArrayList;

    public ArrayList<President> getPresidentArrayList() {
        return presidentArrayList;
    }

    public void setPresidentArrayList(ArrayList<President> presidentArrayList) {
        this.presidentArrayList = presidentArrayList;
    }

    public GridPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridPresidentAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_grid_president, parent, false);

        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GridPresidentAdapter.GridViewHolder holder, int position) {
        President president = getPresidentArrayList().get(position);

        Glide.with(context)
                .load(president.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getPresidentArrayList().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;

        public GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

package com.github.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.myrecyclerview.utils.CustomOnClickListener;

import java.util.ArrayList;

/**
 * Created by Kei Lazu on 9/5/2018
 * check https://github.com/KeiLazu for more
 */
public class CardViewPresidentAdapter extends RecyclerView.Adapter<CardViewPresidentAdapter.CardViewViewHolder> {
    Context context;
    ArrayList<President> listPresident;

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    public CardViewPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewPresidentAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_cardview_president, parent, false);
        return new CardViewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewPresidentAdapter.CardViewViewHolder holder, int position) {
        final President president = getListPresident().get(position);

        Glide.with(context)
                .load(president.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.lblName.setText(president.getName());
        holder.lblRemarks.setText(president.getRemarks());

        holder.btnFav.setOnClickListener(new CustomOnClickListener(position, new CustomOnClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorited: " + president.getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnClickListener(position, new CustomOnClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Shared: " + president.getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView lblName, lblRemarks;
        Button btnFav, btnShare;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            lblName = itemView.findViewById(R.id.tv_item_name);
            lblRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFav = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}

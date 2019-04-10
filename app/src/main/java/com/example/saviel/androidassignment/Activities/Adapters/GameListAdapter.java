package com.example.saviel.androidassignment.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saviel.androidassignment.Activities.Activities.GameDetailActivity;
import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.R;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.MyViewHolder>{
    private List<Game> gameList;
    private Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_gamelist, viewGroup, false);
        MyViewHolder vw = new MyViewHolder(view);
        return vw;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final int adapterPosition = myViewHolder.getAdapterPosition();
        myViewHolder.gameTitle.setText(gameList.get(i).getName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoDetail = new Intent(context, GameDetailActivity.class);
                gotoDetail.putExtra("Title", gameList.get(adapterPosition).getName());
                gotoDetail.putExtra("Description", gameList.get(adapterPosition).getSummary());
                context.startActivity(gotoDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView gameTitle;
        public ImageView gameCover;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gameTitle = itemView.findViewById(R.id.gameTitle);
            gameCover = itemView.findViewById(R.id.gameCover);
        }
    }

    public GameListAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }
}

package com.example.saviel.androidassignment.Activities.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.R;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.MyViewHolder>{
    private List<Game> gameList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_gamelist, viewGroup, false);
        MyViewHolder vw = new MyViewHolder(view);
        return vw;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.gameTitle.setText(gameList.get(i).getName());
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

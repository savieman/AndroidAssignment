package com.example.saviel.androidassignment.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saviel.androidassignment.Activities.Activities.GameDetailActivity;
import com.example.saviel.androidassignment.Activities.Activities.GamelistActivity;
import com.example.saviel.androidassignment.Activities.Models.Cover;
import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.MyViewHolder>{
    private List<Game> gameList;
    private Context context;

    private final static String https = "https:";

    private final static String putStringTitle = "Title";
    private final static String putStringDescription = "Description";
    private final static String putStringImageUrl = "ImageUrl";

    public GameListAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_gamelist, viewGroup, false);
        MyViewHolder vw = new MyViewHolder(view);
        return vw;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        final int adapterPosition = myViewHolder.getAdapterPosition();
//        final Cover cover = gameList.get(i).getCover();
//        myViewHolder.gameTitle.setText(gameList.get(i).getName());
//        if(cover != null) {
//            Picasso.get().load(https + cover.getThumbUrl()).into(myViewHolder.gameCover);
//        }
//        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gotoDetail = new Intent(context, GameDetailActivity.class);
//                gotoDetail.putExtra(putStringTitle, gameList.get(adapterPosition).getName());
//                gotoDetail.putExtra(putStringDescription, gameList.get(adapterPosition).getSummary());
//                if(cover != null){
//                    gotoDetail.putExtra(putStringImageUrl, cover.getCoverUrl());
//                }
//                context.startActivity(gotoDetail);
//            }
//        });


        if(gameList != null) {
            Game current = gameList.get(i);
            myViewHolder.gameTitle.setText(current.getName());
        }

        else {
            myViewHolder.gameTitle.setText(R.string.no_game_title);
        }
    }

    public void setGames(List<Game> games){
        gameList = games;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(gameList != null) {
            return gameList.size();
        }
        else return 0;
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
//
//    public GameListAdapter(List<Game> gameList) {
//        this.gameList = gameList;
//    }
}

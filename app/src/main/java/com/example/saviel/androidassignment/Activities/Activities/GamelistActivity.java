package com.example.saviel.androidassignment.Activities.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.saviel.androidassignment.Activities.Adapters.DaggerGameListComponent;
import com.example.saviel.androidassignment.Activities.Adapters.GameListAdapter;
import com.example.saviel.androidassignment.Activities.Adapters.GameListAdapterModule;
import com.example.saviel.androidassignment.Activities.Adapters.GameListComponent;
import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.Activities.Root.App;
import com.example.saviel.androidassignment.Activities.Services.GameService;
import com.example.saviel.androidassignment.Activities.ViewModel.GameViewModel;
import com.example.saviel.androidassignment.R;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GamelistActivity extends AppCompatActivity {
    private RecyclerView gameRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GameViewModel gameViewModel;

    @Inject
    GameListAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelist);

        loadRecyclerview();

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.getAllGames().observe(this, new android.arch.lifecycle.Observer<List<Game>>() {
            @Override
            public void onChanged(@Nullable List<Game> games) {
                adapter.setGames(games);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gameViewModel.deleteAll();
                adapter.notifyDataSetChanged();
                refresh();
            }
        });
    }

    private void loadRecyclerview(){
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        gameRecyclerView = findViewById(R.id.gameList);
        gameRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        gameRecyclerView.setLayoutManager(layoutManager);

        GameListComponent gameListComponent = DaggerGameListComponent.builder()
                .gameListAdapterModule(new GameListAdapterModule(this))
                .appComponent(((App) getApplication()).getAppComponent())
                .build();

        gameListComponent.inject(this);

        gameRecyclerView.setAdapter(adapter);

    }

    private void refresh(){
        App app = (App) getApplication();

        GameService gameService = app.getGameService();
        gameService.getGames().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Game>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Game> games) {
                        for (Game game: games) {
                            if(game.getCover() != null) {
                                game.setThumbUrl(game.getCover().getThumbUrl());
                            }
                            gameViewModel.insert(game);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onComplete() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }
}

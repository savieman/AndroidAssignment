package com.example.saviel.androidassignment.Activities.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.saviel.androidassignment.Activities.Adapters.DaggerGameListComponent;
import com.example.saviel.androidassignment.Activities.Adapters.GameListAdapter;
import com.example.saviel.androidassignment.Activities.Adapters.GameListAdapterModule;
import com.example.saviel.androidassignment.Activities.Adapters.GameListComponent;
import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.Activities.Root.App;
import com.example.saviel.androidassignment.Activities.Services.GameService;
import com.example.saviel.androidassignment.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GamelistActivity extends AppCompatActivity {
    private RecyclerView gameRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    GameListAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    private List<Game> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelist);

        loadRecyclerview();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadRecyclerview();
                refresh();
            }
        });
    }

    private void loadRecyclerview(){
        gameList = new ArrayList<>();
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        gameRecyclerView = findViewById(R.id.gameList);
        gameRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        gameRecyclerView.setLayoutManager(layoutManager);


        GameListComponent gameListComponent = DaggerGameListComponent.builder()
                .gameListAdapterModule(new GameListAdapterModule(gameList))
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
                            gameList.add(game);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

    private void createList(){
//        gameList.add(new Game("Bloodborne"));
//        gameList.add(new Game("Dark souls"));
//        gameList.add(new Game("Sekiro"));
    }
}

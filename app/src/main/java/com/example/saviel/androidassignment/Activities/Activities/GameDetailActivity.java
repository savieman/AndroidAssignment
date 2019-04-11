package com.example.saviel.androidassignment.Activities.Activities;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saviel.androidassignment.R;
import com.squareup.picasso.Picasso;

public class GameDetailActivity extends AppCompatActivity {
    private ImageView image;
    private TextView title, description;
    private Bundle bundle;
    private final static String https = "https:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        bundle = this.getIntent().getExtras();

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        title.setText(bundle.getString("Title"));


        description.setText("Description Not Available");
        if(bundle.getString("Description") != null) {
            description.setText(bundle.getString("Description"));
        }

        if(bundle.getString("ImageUrl") != null) {
            Picasso.get().load(https + bundle.getString("ImageUrl")).into(image);
        }

    }
}

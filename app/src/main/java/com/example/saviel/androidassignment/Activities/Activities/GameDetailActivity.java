package com.example.saviel.androidassignment.Activities.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saviel.androidassignment.R;
import com.squareup.picasso.Picasso;

public class GameDetailActivity extends AppCompatActivity {
    private ImageView image;
    private TextView title, description;
    private TextView noImageAvailable;
    private Bundle bundle;
    private final static String https = "https:";

    private final static String descriptionBundleString = "Description";
    private final static String titleBundleString = "Title";
    private final static String imageUrlBundleString = "ImageUrl";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        bundle = this.getIntent().getExtras();

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        noImageAvailable = findViewById(R.id.noImageAvailable);

        title.setText(bundle.getString(titleBundleString));

        description.setText(R.string.no_description);
        if(bundle.getString(descriptionBundleString) != null) {
            description.setText(bundle.getString(descriptionBundleString));
        }

        if(bundle.getString(imageUrlBundleString) != null) {
            Picasso.get().load(https + bundle.getString(imageUrlBundleString)).into(image);
            image.setVisibility(View.VISIBLE);
        } else {
            noImageAvailable.setVisibility(View.VISIBLE);
            noImageAvailable.setText(R.string.no_available_image_text);
        }

    }
}

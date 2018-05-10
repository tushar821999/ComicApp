package com.androidgits.animation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.androidgits.animation.R;

public class AnimeActivity extends AppCompatActivity {
    TextView animeDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        animeDescription = (TextView) findViewById(R.id.animeDescription);

        String Description = getIntent().getExtras().getString("anime_description");
        animeDescription.setText(Description);
    }
}

package com.elabda3.eldaya7een.VideoDetailsPackage;


import android.os.Bundle;
import android.widget.TextView;


import com.hashtag.eldya7een.R;
import com.pierfrancescosoffritti.youtubeplayer.AbstractYouTubeListener;
import com.pierfrancescosoffritti.youtubeplayer.YouTubePlayerView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoDetailsActivity extends AppCompatActivity {

    TextView titleTextView, content;
    YouTubePlayerView youTubePlayerView;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        titleTextView = findViewById(R.id.toolbarTitle);
        content = findViewById(R.id.description);
        youTubePlayerView = findViewById(R.id.youtubePlayer);

        if (getIntent().getExtras() != null) {
            titleTextView.setText(getIntent().getExtras().getString("title", ""));
            content.setText(getIntent().getExtras().getString("content", ""));
            url = getIntent().getExtras().getString("url", "");


            youTubePlayerView.initialize(new AbstractYouTubeListener() {
                @Override
                public void onReady() {

                    String vedioId = url.split("v=")[1];

                    youTubePlayerView.loadVideo(vedioId, 0);

                }
            }, true);


        }



    }
    @Override
    protected void onPause () {
        super.onPause();

        if (youTubePlayerView != null)
            youTubePlayerView.release();

    }
}
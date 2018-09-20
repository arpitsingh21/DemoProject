package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jean.retrofitexample.R;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class VideoDetailActivity extends AppCompatActivity {

    JzvdStd jzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        jzvdStd = (JzvdStd) findViewById(R.id.videoplayer);
        jzvdStd.setUp(getIntent().getStringExtra("url"), "", Jzvd.SCREEN_WINDOW_FULLSCREEN);

        jzvdStd.mRetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jzvdStd.setUp(getIntent().getStringExtra("url"), "", Jzvd.SCREEN_WINDOW_FULLSCREEN);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}

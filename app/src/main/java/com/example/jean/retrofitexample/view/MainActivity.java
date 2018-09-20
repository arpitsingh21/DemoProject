package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jean.retrofitexample.Navigator;
import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.adapters.VideoFeedsAdapter;
import com.example.jean.retrofitexample.model.Data;
import com.example.jean.retrofitexample.presenter.VideoFeedPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements VideoFeedsView ,VideoFeedsAdapter.VideoFeedsRvInterface{

    VideoFeedPresenter videoFeedPresenter;

    VideoFeedsAdapter videoFeedsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoFeedPresenter = new VideoFeedPresenter(this);
        videoFeedPresenter.getvideoFeeds();
        videoFeedsAdapter = new VideoFeedsAdapter(this);
    }

    @Override
    public void onVideoListFetched(List<Data> videoList) {
        videoFeedsAdapter.setVideoList(videoList);
    }

    @Override
    public void onFeedClicked(Data data) {
        Navigator.navigateToVideoDetailsActivity(this,data.getThumbnailUrl());
    }
}

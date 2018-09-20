package com.example.jean.retrofitexample.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.jean.retrofitexample.Navigator;
import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.adapters.VideoFeedsAdapter;
import com.example.jean.retrofitexample.model.Data;
import com.example.jean.retrofitexample.presenter.VideoFeedPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements VideoFeedsView, VideoFeedsAdapter.VideoFeedsRvInterface {

    VideoFeedPresenter videoFeedPresenter;

    VideoFeedsAdapter videoFeedsAdapter;

    @Bind(R.id.videoFeedsRV)
    RecyclerView mVideoFeedsRV;
    LinearLayoutManager linearLayoutManager;
    private boolean isScrolling = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        videoFeedPresenter = new VideoFeedPresenter(this);
        videoFeedPresenter.getvideoFeeds();
        videoFeedsAdapter = new VideoFeedsAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        mVideoFeedsRV.setLayoutManager(linearLayoutManager);
        mVideoFeedsRV.setAdapter(videoFeedsAdapter);

        setupRecyclerViewListner();
    }

    @Override
    public void onVideoListFetched(List<Data> videoList) {
        videoFeedsAdapter.setVideoList(videoList);
    }

    @Override
    public void onFeedClicked(Data data) {
        Navigator.navigateToVideoDetailsActivity(this, data.getVideoUrl());
    }

    @Override
    public void onWhtsappShareClick(Data data) {

        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, data.getVideoUrl());
        try {
            startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Not Installed", Toast.LENGTH_SHORT).show();
        }
    }

    public void setupRecyclerViewListner() {

        mVideoFeedsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int total = linearLayoutManager.getItemCount();
                int currentItems = linearLayoutManager.getChildCount();
                int scrolloutItems = linearLayoutManager.findFirstVisibleItemPosition();

                if (total > 0) {
                    if ( currentItems + scrolloutItems == total) {
                        videoFeedPresenter.getvideoFeeds();

                    }
                }
            }
        });

    }
}

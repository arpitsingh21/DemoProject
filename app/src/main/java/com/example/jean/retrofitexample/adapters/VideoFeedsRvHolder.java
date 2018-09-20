package com.example.jean.retrofitexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.like.LikeButton;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Arpit on 20/09/2018.
 */
public class VideoFeedsRvHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.layout_card)
    LinearLayout mLayoutCard;
    @Bind(R.id.video_thumbnail)
    ImageView mVideoThumbnail;
    @Bind(R.id.video_title)
    TextView mVideoTitle;
    @Bind(R.id.like_button)
    LikeButton mLikeButton;
    @Bind(R.id.whtsapp)
    ImageView mWhtsapp;

    public VideoFeedsRvHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_feeds_items, parent, false));
        ButterKnife.bind(this, itemView);
    }
}

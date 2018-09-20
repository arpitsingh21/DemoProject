package com.example.jean.retrofitexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.jean.retrofitexample.model.Data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arpit on 20/09/2018.
 */
public class VideoFeedsAdapter extends RecyclerView.Adapter<VideoFeedsRvHolder> {

    private static final String TAG = VideoFeedsAdapter.class.getSimpleName();
    private final VideoFeedsRvInterface videoFeedsRvInterface;
    List<Data> videoList;


    public VideoFeedsAdapter(VideoFeedsRvInterface videoFeedsRvInterface) {
        this.videoFeedsRvInterface = videoFeedsRvInterface;
        videoList = new ArrayList<>();
    }


    @Override
    public VideoFeedsRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final VideoFeedsRvHolder videoFeedsRvHolder = new VideoFeedsRvHolder(parent);

        videoFeedsRvHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoFeedsRvInterface.onFeedClicked(videoList.get(videoFeedsRvHolder.getAdapterPosition()));
            }
        });

        return videoFeedsRvHolder;
    }

    @Override
    public void onBindViewHolder(VideoFeedsRvHolder holder, int position) {

        holder.mVideoTitle.setText(videoList.get(position).getTitle());
        Picasso.get().load(videoList.get(position).getThumbnailUrl()).fit().centerInside().into(holder.mVideoThumbnail);
    }


    @Override
    public int getItemCount() {
        return videoList != null ? videoList.size() : 0;
    }


    public void updateItemCount(int newCount) {
        notifyDataSetChanged();
    }

    public void setVideoList(List<Data> videoList) {
        this.videoList = videoList;
        notifyDataSetChanged();
    }

    public interface VideoFeedsRvInterface {
        void onFeedClicked(Data data);
    }
}

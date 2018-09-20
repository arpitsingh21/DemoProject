package com.example.jean.retrofitexample.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;

import butterknife.ButterKnife;

/**
 * Created by Harikesh on 20/09/2018.
 */
public class VideoFeedsRvHolder extends RecyclerView.ViewHolder {


//    @BindView(R.id.text_appointment_uId)
//    TextView textAppointmentUId;
//    @BindView(R.id.detailsLayout)
//    LinearLayout detailsLayout;


    public VideoFeedsRvHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_feeds_items, parent, false));
        ButterKnife.bind(this, itemView);
    }
}

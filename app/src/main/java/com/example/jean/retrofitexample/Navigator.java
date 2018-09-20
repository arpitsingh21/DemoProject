package com.example.jean.retrofitexample;

import android.app.Activity;
import android.content.Intent;

import com.example.jean.retrofitexample.view.VideoDetailActivity;

/**
 * Created by Arpit on 20/09/2018.
 */
public class Navigator {

    public static void navigateToVideoDetailsActivity(Activity activity, String url){
        if (activity != null) {
            Intent intentToLaunch = new Intent(activity, VideoDetailActivity.class);
            intentToLaunch.putExtra("url",url);
            activity.startActivity(intentToLaunch);
        }
    }
}

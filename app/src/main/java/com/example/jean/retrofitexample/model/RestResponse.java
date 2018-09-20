package com.example.jean.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 29/07/16.
 * Jesus loves you.
 */
public class RestResponse {

    @SerializedName("videos")
    @Expose
    private List<Data> videos = null;

    public List<Data> getVideos() {
        return videos;
    }

    public void setVideos(List<Data> videos) {
        this.videos = videos;
    }

}
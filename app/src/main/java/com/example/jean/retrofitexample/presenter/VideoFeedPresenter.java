package com.example.jean.retrofitexample.presenter;

import com.example.jean.retrofitexample.model.Data;
import com.example.jean.retrofitexample.model.RestResponse;
import com.example.jean.retrofitexample.service.AppService;
import com.example.jean.retrofitexample.view.VideoFeedsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 29/07/16.
 * Jesus loves you.
 */
public class VideoFeedPresenter {

    private VideoFeedsView videoFeedsView;
    private AppService appService;

    public VideoFeedPresenter(VideoFeedsView view) {
        this.videoFeedsView = view;

        if (this.appService == null) {
            this.appService = new AppService();
        }
    }

    public void getvideoFeeds() {
        appService
                .getAPI()
                .getResults()
                .enqueue(new Callback<RestResponse>() {
                    @Override
                    public void onResponse(Call<RestResponse> call, Response<RestResponse> response) {

                        RestResponse data = response.body();

                        if (data != null && data.getVideos() != null) {
                            List<Data> result = data.getVideos();
                            videoFeedsView.countriesReady(result);
                        }

                    }

                    @Override
                    public void onFailure(Call<RestResponse> call, Throwable t) {

                    }
                });
    }
}

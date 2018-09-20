package com.example.jean.retrofitexample.presenter;

import com.example.jean.retrofitexample.model.Country;
import com.example.jean.retrofitexample.model.Data;
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
public class CountryPresenter {

    private VideoFeedsView videoFeedsView;
    private AppService appService;

    public CountryPresenter(VideoFeedsView view) {
        this.videoFeedsView = view;

        if (this.appService == null) {
            this.appService = new AppService();
        }
    }

    public void getCountries() {
        appService
                .getAPI()
                .getResults()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getRestResponse() != null) {
                            List<Country> result = data.getRestResponse().getResult();
                            videoFeedsView.countriesReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}

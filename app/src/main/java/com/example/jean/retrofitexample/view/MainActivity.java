package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.Country;
import com.example.jean.retrofitexample.presenter.CountryPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements VideoFeedsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CountryPresenter countryPresenter = new CountryPresenter(this);

        // Maybe it's best to call it on onResume()
        countryPresenter.getCountries();
    }

    @Override
    public void countriesReady(List<Country> countries) {

        // See your Logcat :)

    }
}

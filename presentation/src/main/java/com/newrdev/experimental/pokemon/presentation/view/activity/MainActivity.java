package com.newrdev.experimental.pokemon.presentation.view.activity;

import android.app.Activity;
import android.os.Bundle;


import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.data.net.ApiService;
import com.newrdev.experimental.pokemon.presentation.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by newrdev on 12/30/15.
 */

public class MainActivity extends Activity {
    ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(logging);

        service = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(ApiService.class);
    }

    @OnClick(R.id.button)
    public void test(){
//        service.getSprite("/api/v1/sprite/1/");
    }
}

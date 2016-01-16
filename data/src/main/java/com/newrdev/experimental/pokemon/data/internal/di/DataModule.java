package com.newrdev.experimental.pokemon.data.internal.di;

import com.newrdev.experimental.pokemon.data.net.ApiService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by newrdev on 1/16/16.
 */
@Module
public class DataModule {
    @Provides
    @Singleton
    ApiService provideApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(logging);

        return new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(ApiService.class);
    }
}

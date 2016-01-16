package com.newrdev.experimental.pokemon.data.internal.di;

import com.newrdev.experimental.pokemon.data.net.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by newrdev on 1/16/16.
 */
@Singleton
@Component(modules = DataModule.class)
public interface DataComponent {
    ApiService apiService();
}

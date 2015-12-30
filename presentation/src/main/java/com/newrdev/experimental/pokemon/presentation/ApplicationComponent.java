package com.newrdev.experimental.pokemon.presentation;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by newrdev on 12/30/15.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // Exposed to sub-graphs
    Context context();
}

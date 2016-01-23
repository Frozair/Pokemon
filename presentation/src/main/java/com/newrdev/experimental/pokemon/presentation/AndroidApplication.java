package com.newrdev.experimental.pokemon.presentation;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by newrdev on 12/30/15.
 */
public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();

        Timber.plant(new Timber.DebugTree());
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}

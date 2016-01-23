package com.newrdev.experimental.pokemon.presentation.executor;

import com.newrdev.experimental.pokemon.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by newrdev on 1/23/16.
 */
@Singleton
public class UIThread implements PostExecutionThread {
    @Inject
    public UIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}

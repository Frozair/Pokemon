package com.newrdev.experimental.pokemon.domain.executor;

import rx.Scheduler;

/**
 * Created by newrdev on 1/23/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}

package com.newrdev.experimental.pokemon.domain.interactor;

import com.newrdev.experimental.pokemon.domain.executor.ExecutionThread;
import com.newrdev.experimental.pokemon.domain.executor.PostExecutionThread;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by newrdev on 1/23/16.
 */
public abstract class UseCase {
    private final ExecutionThread executionThread;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    public UseCase(ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an Observable which will be used when executing the current UseCase.
     */
    public abstract Observable buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(this.executionThread.getScheduler())
                .observeOn(this.postExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if(!this.subscription.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
    }
}

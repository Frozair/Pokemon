package com.newrdev.experimental.pokemon.presentation;

import android.content.Context;

import com.newrdev.experimental.pokemon.data.internal.di.DataModule;
import com.newrdev.experimental.pokemon.data.repository.PokemonDataRepository;
import com.newrdev.experimental.pokemon.domain.executor.ExecutionThread;
import com.newrdev.experimental.pokemon.domain.executor.PostExecutionThread;
import com.newrdev.experimental.pokemon.domain.interactor.GetPokemonDetails;
import com.newrdev.experimental.pokemon.domain.interactor.UseCase;
import com.newrdev.experimental.pokemon.domain.repository.PokemonRepository;
import com.newrdev.experimental.pokemon.presentation.executor.JobThread;
import com.newrdev.experimental.pokemon.presentation.executor.UIThread;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.schedulers.Schedulers;

/**
 * Created by newrdev on 12/30/15.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ExecutionThread provideExecutionThread(JobThread jobThread) {
        return jobThread;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    PokemonRepository providePokemonRepository(PokemonDataRepository pokemonDataRepository) {
        return pokemonDataRepository;
    }

    @Provides
    GetPokemonDetails provideGetPokemonDetailsUseCase(PokemonRepository pokemonRepository, ExecutionThread executionThread,
                                            PostExecutionThread postExecutionThread) {

        return new GetPokemonDetails(pokemonRepository, executionThread, postExecutionThread);
    }
}

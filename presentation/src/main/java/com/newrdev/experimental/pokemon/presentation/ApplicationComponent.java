package com.newrdev.experimental.pokemon.presentation;

import android.content.Context;

import com.newrdev.experimental.pokemon.data.internal.di.DataModule;
import com.newrdev.experimental.pokemon.domain.executor.ExecutionThread;
import com.newrdev.experimental.pokemon.domain.executor.PostExecutionThread;
import com.newrdev.experimental.pokemon.domain.interactor.GetPokemonDetails;
import com.newrdev.experimental.pokemon.domain.repository.PokemonRepository;
import com.newrdev.experimental.pokemon.presentation.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by newrdev on 12/30/15.
 */
@Singleton
@Component(modules = { ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {

    // Exposed to sub-graphs
    Context context();
    ExecutionThread executionThread();
    PostExecutionThread postExecutionThread();
    PokemonRepository pokemonRepository();
    void inject(MainActivity activity);
}

package com.newrdev.experimental.pokemon.domain.interactor;

import com.newrdev.experimental.pokemon.domain.executor.ExecutionThread;
import com.newrdev.experimental.pokemon.domain.executor.PostExecutionThread;
import com.newrdev.experimental.pokemon.domain.repository.PokemonRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by newrdev on 2/7/16.
 */
public class GetPokemonDetailsByName extends UseCase {
    private String pokemonName;
    private final PokemonRepository pokemonRepository;

    @Inject
    public GetPokemonDetailsByName(PokemonRepository pokemonRepository,
                                 ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
        super(executionThread, postExecutionThread);

        this.pokemonRepository = pokemonRepository;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return this.pokemonRepository.getPokemonByName(pokemonName);
    }
}

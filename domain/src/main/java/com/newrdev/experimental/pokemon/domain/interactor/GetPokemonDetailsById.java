package com.newrdev.experimental.pokemon.domain.interactor;

import com.newrdev.experimental.pokemon.domain.executor.ExecutionThread;
import com.newrdev.experimental.pokemon.domain.executor.PostExecutionThread;
import com.newrdev.experimental.pokemon.domain.repository.PokemonRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by newrdev on 1/23/16.
 */
public class GetPokemonDetailsById extends UseCase{
    private int pokemonId;
    private final PokemonRepository pokemonRepository;

    @Inject
    public GetPokemonDetailsById(PokemonRepository pokemonRepository,
                                 ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
        super(executionThread, postExecutionThread);

        this.pokemonRepository = pokemonRepository;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return this.pokemonRepository.getPokemonById(this.pokemonId);
    }
}

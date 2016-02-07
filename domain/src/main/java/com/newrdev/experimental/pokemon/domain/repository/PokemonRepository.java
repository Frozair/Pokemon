package com.newrdev.experimental.pokemon.domain.repository;

import com.newrdev.experimental.pokemon.domain.entity.Pokemon;

import rx.Observable;

/**
 * Created by newrdev on 1/16/16.
 */
public interface PokemonRepository {
    Observable<Pokemon> getPokemonById(int id);
    Observable<Pokemon> getPokemonByName(String name);
}

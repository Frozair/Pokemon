package com.newrdev.experimental.pokemon.data.repository;

import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.data.entity.SpriteEntity;
import com.newrdev.experimental.pokemon.data.entity.mapper.PokemonEntityDataMapper;
import com.newrdev.experimental.pokemon.data.net.ApiService;
import com.newrdev.experimental.pokemon.domain.entity.Pokemon;
import com.newrdev.experimental.pokemon.domain.repository.PokemonRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by newrdev on 1/17/16.
 */
public class PokemonDataRepository implements PokemonRepository{
    private final ApiService apiService;
    private final PokemonEntityDataMapper pokemonEntityDataMapper;
    private Pokemon pokemon;

    @Inject
    public PokemonDataRepository(ApiService apiService, PokemonEntityDataMapper pokemonEntityDataMapper) {
        this.apiService = apiService;
        this.pokemonEntityDataMapper = pokemonEntityDataMapper;
    }

    @Override
    public Observable<Pokemon> getPokemon(int id) {

        return this.apiService.getPokemon(id).map(new Func1<PokemonEntity, Pokemon>() {
            @Override
            public Pokemon call(PokemonEntity pokemonEntity) {
                return pokemonEntityDataMapper.transform(pokemonEntity);
            }
        });
    }
}

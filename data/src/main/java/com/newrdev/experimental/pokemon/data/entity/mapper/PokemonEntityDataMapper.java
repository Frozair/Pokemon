package com.newrdev.experimental.pokemon.data.entity.mapper;

import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.domain.entity.Pokemon;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by newrdev on 1/17/16.
 */
@Singleton
public class PokemonEntityDataMapper {
    @Inject
    public PokemonEntityDataMapper() {
    }

    /**
     * Transform a {@link PokemonEntity} to {@link Pokemon}
     *
     * @param pokemonEntity
     * @return {@link Pokemon}
     */
    public Pokemon transform(PokemonEntity pokemonEntity) {
        Pokemon pokemon = null;

        if(pokemonEntity != null) {
            pokemon = new Pokemon();

            pokemon.setAttack(pokemonEntity.getAttack());
            pokemon.setDefense(pokemonEntity.getDefense());
            pokemon.setHeight(pokemonEntity.getHeight());
            pokemon.setWeight(pokemonEntity.getWeight());
            pokemon.setHp(pokemonEntity.getHp());
            pokemon.setName(pokemonEntity.getName());
            pokemon.setSpecialAttack(pokemonEntity.getSp_atk());
            pokemon.setSpecialDefense(pokemonEntity.getSp_def());
            pokemon.setSpeed(pokemonEntity.getSpeed());
            pokemon.setSpriteUris(new ArrayList<String>());
        }

        return pokemon;
    }
}

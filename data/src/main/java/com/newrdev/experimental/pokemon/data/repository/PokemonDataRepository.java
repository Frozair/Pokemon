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
import rx.functions.Func2;

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
    public Observable<Pokemon> getPokemonById(int id) {
        return this.apiService.getPokemonById(id).flatMap(new Func1<PokemonEntity, Observable<Pokemon>>() {
            @Override
            public Observable<Pokemon> call(PokemonEntity pokemonEntity) {
                Observable<Pokemon> pokemon = Observable.just(pokemonEntityDataMapper.transform(pokemonEntity));
                Observable<List<String>> sprites = getSprites(pokemonEntity.getSprites());

                return Observable.zip(pokemon, sprites, new Func2<Pokemon, List<String>, Pokemon>() {
                    @Override
                    public Pokemon call(Pokemon pokemon, List<String> sprites) {
                        pokemon.setSpriteUris(sprites);
                        return pokemon;
                    }
                });
            }
        });
    }

    @Override
    public Observable<Pokemon> getPokemonByName(String name) {
        return this.apiService.getPokemonByName(name).flatMap(new Func1<PokemonEntity, Observable<Pokemon>>() {
            @Override
            public Observable<Pokemon> call(PokemonEntity pokemonEntity) {
                Observable<Pokemon> pokemon = Observable.just(pokemonEntityDataMapper.transform(pokemonEntity));
                Observable<List<String>> sprites = getSprites(pokemonEntity.getSprites());

                return Observable.zip(pokemon, sprites, new Func2<Pokemon, List<String>, Pokemon>() {
                    @Override
                    public Pokemon call(Pokemon pokemon, List<String> sprites) {
                        pokemon.setSpriteUris(sprites);
                        return pokemon;
                    }
                });
            }
        });
    }

    private Observable<List<String>> getSprites(List<PokemonEntity.Sprite> sprites) {
        return Observable.from(sprites).flatMap(new Func1<PokemonEntity.Sprite, Observable<SpriteEntity>>() {
            @Override
            public Observable<SpriteEntity> call(PokemonEntity.Sprite sprite) {
                return apiService.getSprite(sprite.getResource_uri());
            }
        }).flatMap(new Func1<SpriteEntity, Observable<String>>() {
            @Override
            public Observable<String> call(SpriteEntity spriteEntity) {
                return Observable.just(spriteEntity.getImage());
            }
        }).toList();
    }
}

package com.newrdev.experimental.pokemon.data.net;

import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.data.entity.SpriteEntity;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Url;
import rx.Observable;

/**
 * Created by newrdev on 12/30/15.
 */
public interface ApiService {
    @GET("/api/v1/pokemon/{id}")
    Observable<PokemonEntity> getPokemon(@Path("id") int id);

    @GET
    Observable<SpriteEntity> getSprite(@Url String url);
}

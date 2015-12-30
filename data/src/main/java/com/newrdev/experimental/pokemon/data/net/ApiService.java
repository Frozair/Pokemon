package com.newrdev.experimental.pokemon.data.net;

import com.newrdev.experimental.pokemon.data.entity.PokedexEntity;
import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by newrdev on 12/30/15.
 */
public interface ApiService {
    @GET("pokedex/1")
    Call<PokedexEntity> getPokedex();
}

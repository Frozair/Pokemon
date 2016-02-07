package com.newrdev.experimental.pokemon.data.net;


import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.data.entity.SpriteEntity;
import com.newrdev.experimental.pokemon.data.internal.di.DaggerDataComponent;

import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by newrdev on 1/16/16.
 */
public class ApiServiceTest {
    private ApiService apiService;

    @Before
    public void setUp() {
        apiService = DaggerDataComponent.create().apiService();
    }

    @Test
    public void testGetPokemon() {
        int pokemonId = 1;
        TestSubscriber<PokemonEntity> subscriber = new TestSubscriber<>();

        apiService.getPokemonById(pokemonId).subscribe(subscriber);
        subscriber.awaitTerminalEvent();

        assertThat(subscriber.getOnErrorEvents().size(), is(0));
        assertThat(subscriber.getOnNextEvents().size(), is(1));
        PokemonEntity pokemon = subscriber.getOnNextEvents().get(0);

        assertThat(pokemon.getName(), is("Bulbasaur"));
    }

    @Test
    public void testGetPokemonSprite() {
        String pokemonSpriteUri = "/api/v1/sprite/1/";
        TestSubscriber<SpriteEntity> subscriber = new TestSubscriber<>();

        apiService.getSprite(pokemonSpriteUri).subscribe(subscriber);
        subscriber.awaitTerminalEvent();

        assertThat(subscriber.getOnErrorEvents().size(), is(0));
        assertThat(subscriber.getOnNextEvents().size(), is(1));
    }
}

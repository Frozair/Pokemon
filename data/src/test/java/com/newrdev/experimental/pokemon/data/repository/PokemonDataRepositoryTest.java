package com.newrdev.experimental.pokemon.data.repository;

import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.data.entity.mapper.PokemonEntityDataMapper;
import com.newrdev.experimental.pokemon.data.net.ApiService;
import com.newrdev.experimental.pokemon.domain.entity.Pokemon;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by newrdev on 1/17/16.
 */
public class PokemonDataRepositoryTest {
    @Mock
    ApiService mockApiService;
    @Mock
    PokemonEntityDataMapper mockPokemonEntityDataMapper;

    private PokemonDataRepository pokemonDataRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.pokemonDataRepository = new PokemonDataRepository(this.mockApiService, this.mockPokemonEntityDataMapper);
    }

    @Test
    public void getPokemonById() {
        int pokemonId = 1;
        String pokemonName = "Bulbasaur";

        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(pokemonName);
        pokemonEntity.setSprites(new ArrayList<PokemonEntity.Sprite>());

        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonName);
        pokemon.setSpriteUris(new ArrayList<String>());

        when(mockApiService.getPokemonById(pokemonId)).thenReturn(Observable.just(pokemonEntity));
        when(mockPokemonEntityDataMapper.transform(pokemonEntity)).thenReturn(pokemon);

        TestSubscriber<Pokemon> subscriber = new TestSubscriber<>();
        pokemonDataRepository.getPokemonById(pokemonId).subscribe(subscriber);

        subscriber.awaitTerminalEvent();

        verify(mockApiService).getPokemonById(pokemonId);

        assertThat(subscriber.getOnErrorEvents().size(), is(0));
        assertThat(subscriber.getOnNextEvents().size(), is(1));
    }

    @Test
    public void getPokemonByName() {
        String pokemonName = "Bulbasaur";

        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(pokemonName);
        pokemonEntity.setSprites(new ArrayList<PokemonEntity.Sprite>());

        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonName);
        pokemon.setSpriteUris(new ArrayList<String>());

        when(mockApiService.getPokemonByName(pokemonName)).thenReturn(Observable.just(pokemonEntity));
        when(mockPokemonEntityDataMapper.transform(pokemonEntity)).thenReturn(pokemon);

        TestSubscriber<Pokemon> subscriber = new TestSubscriber<>();
        pokemonDataRepository.getPokemonByName(pokemonName).subscribe(subscriber);

        subscriber.awaitTerminalEvent();

        verify(mockApiService).getPokemonByName(pokemonName);

        assertThat(subscriber.getOnErrorEvents().size(), is(0));
        assertThat(subscriber.getOnNextEvents().size(), is(1));
    }
}

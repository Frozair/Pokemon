package com.newrdev.experimental.pokemon.presentation.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.newrdev.experimental.pokemon.data.entity.PokemonEntity;
import com.newrdev.experimental.pokemon.data.net.ApiService;
import com.newrdev.experimental.pokemon.domain.entity.Pokemon;
import com.newrdev.experimental.pokemon.domain.interactor.GetPokemonDetails;
import com.newrdev.experimental.pokemon.domain.interactor.UseCase;
import com.newrdev.experimental.pokemon.presentation.AndroidApplication;
import com.newrdev.experimental.pokemon.presentation.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Subscriber;
import timber.log.Timber;

/**
 * Created by newrdev on 12/30/15.
 */

public class MainActivity extends Activity {

    @Inject
    GetPokemonDetails getPokemonDetailsUseCase;

    @Bind(R.id.imageView)
    ImageView pokemonImage;
    @Bind(R.id.pokedexEntry)
    TextView pokedexEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Timber.tag("MainActivity");
        ((AndroidApplication) getApplication()).getApplicationComponent().inject(this);
    }

    @OnClick(R.id.button)
    public void getPokemon(){
        // TODO - Make sure entry is not empty
        int id = Integer.parseInt(this.pokedexEntry.getText().toString());

        this.getPokemonDetailsUseCase.setPokemonId(id);
        this.getPokemonDetailsUseCase.execute(new Subscriber<Pokemon>() {
            @Override
            public void onCompleted() {
                Timber.d("Completed");
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("Error Occurred");
                Timber.d(e, "Error message");
            }

            @Override
            public void onNext(Pokemon pokemon) {
                Timber.d("I have a pokemon");
                Timber.d(pokemon.getName());
                Timber.d(pokemon.getSpriteUris().get(0));

                Picasso.with(MainActivity.this)
                        .load("http://pokeapi.co" + pokemon.getSpriteUris().get(0))
                        .into(MainActivity.this.pokemonImage);
            }
        });
    }
}

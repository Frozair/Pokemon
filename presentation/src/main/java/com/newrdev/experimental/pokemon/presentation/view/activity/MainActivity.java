package com.newrdev.experimental.pokemon.presentation.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.newrdev.experimental.pokemon.presentation.R;

import butterknife.ButterKnife;

/**
 * Created by newrdev on 12/30/15.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}

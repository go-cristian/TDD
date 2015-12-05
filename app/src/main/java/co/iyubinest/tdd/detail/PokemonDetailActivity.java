package co.iyubinest.tdd.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import co.iyubinest.tdd.Pokemon;
import co.iyubinest.tdd.R;

public class PokemonDetailActivity extends AppCompatActivity
{

    public static final String POKEMON_KEY = "POKEMON_KEY";

    public static void start(Context context, Pokemon pokemon)
    {

        Intent intent = new Intent(context, PokemonDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(POKEMON_KEY, pokemon);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
    }
}

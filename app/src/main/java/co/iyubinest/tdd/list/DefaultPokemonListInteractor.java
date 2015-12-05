package co.iyubinest.tdd.list;

import android.os.Handler;
import co.iyubinest.tdd.Pokemon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiangomez on 3/12/15.
 */
public class DefaultPokemonListInteractor implements PokemonListInteractor
{

    private Handler mHandler;

    private PokemonListInteractorListener mPokemonListInteractorListener;

    public DefaultPokemonListInteractor()
    {

        mHandler = new Handler();
    }

    @Override
    public void getPokemons(PokemonListInteractorListener pokemonListInteractorListener)
    {

        mPokemonListInteractorListener = pokemonListInteractorListener;
        mHandler.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {

                List<Pokemon> mPokemons = new ArrayList<>();
                mPokemons.add(new Pokemon("Balbasaur", ""));
                mPokemons.add(new Pokemon("Pidgeot", ""));
                mPokemonListInteractorListener.onSuccess(mPokemons);
            }
        }, 200);
    }
}

package co.iyubinest.tdd;

import co.iyubinest.tdd.list.PokemonListInteractor;
import co.iyubinest.tdd.list.PokemonListInteractorListener;
import co.iyubinest.tdd.list.PokemonListPresenter;

/**
 * Created by cristiangomez on 3/12/15.
 */
public class FailPokemonListInteractor implements PokemonListInteractor
{

    @Override
    public void getPokemons(PokemonListInteractorListener pokemonListInteractorListener)
    {

        pokemonListInteractorListener.onError(new PokemonListPresenter.PokemonListException());
    }
}

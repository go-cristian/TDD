package co.iyubinest.tdd.list;

import co.iyubinest.tdd.Pokemon;
import java.util.List;

/**
 * Created by cristiangomez on 3/12/15.
 */
public class PokemonListPresenter
{

    private final PokemonListView mView;

    private final PokemonListInteractor mInteractor;

    private PokemonListInteractorListener mInteractorCallback = new PokemonListInteractorListener()
    {

        @Override
        public void onSuccess(List<Pokemon> pokemons)
        {

            mView.load(pokemons);
        }

        @Override
        public void onError(PokemonListException e)
        {

            mView.showRetry();
        }
    };

    public PokemonListPresenter(PokemonListView view, PokemonListInteractor interactor)
    {

        mView = view;
        mInteractor = interactor;
    }

    public void getPokemons()
    {

        mInteractor.getPokemons(mInteractorCallback);
    }

    public static class PokemonListException extends Throwable
    {

    }
}

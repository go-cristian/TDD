package co.iyubinest.tdd;

import co.iyubinest.tdd.list.BasePokemonListInteractor;
import co.iyubinest.tdd.list.PokemonListPresenter;
import co.iyubinest.tdd.list.PokemonListView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PokemonListPresenterTests
{

    @Mock private PokemonListView pokemonListView;

    @Before
    public void setUp()
    {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadData() throws Exception
    {

        PokemonListPresenter pokemonListPresenter =
            new PokemonListPresenter(pokemonListView, new BasePokemonListInteractor());
        pokemonListPresenter.getPokemons();
        verify(pokemonListView, times(1)).load(Mockito.anyList());
    }

    @Test
    public void testFail() throws Exception
    {

        PokemonListPresenter pokemonListPresenter =
            new PokemonListPresenter(pokemonListView, new FailPokemonListInteractor());
        pokemonListPresenter.getPokemons();
        verify(pokemonListView, times(1)).showRetry();
    }
}
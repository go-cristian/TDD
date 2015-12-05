package co.iyubinest.tdd.list;

import co.iyubinest.tdd.Pokemon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiangomez on 3/12/15.
 */
public class BasePokemonListInteractor implements PokemonListInteractor
{

    @Override
    public void getPokemons(PokemonListInteractorListener pokemonListInteractorListener)
    {

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Balbasaur", ""));
        pokemons.add(new Pokemon("Ratata", ""));
        pokemonListInteractorListener.onSuccess(pokemons);
    }
}

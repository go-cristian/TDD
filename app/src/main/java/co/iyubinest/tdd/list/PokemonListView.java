package co.iyubinest.tdd.list;

import co.iyubinest.tdd.Pokemon;
import java.util.List;

/**
 * Created by cristiangomez on 3/12/15.
 */
public interface PokemonListView
{

    void load(List<Pokemon> mPokemons);

    void showRetry();
}

package co.iyubinest.tdd;

import android.app.Instrumentation;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import co.iyubinest.tdd.detail.PokemonDetailActivity;
import co.iyubinest.tdd.list.PokemonListActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiangomez on 1/12/15.
 */
public class PokemonListActivityBaseTest
    extends ActivityInstrumentationTestCase2<PokemonListActivity>
{

    protected PokemonListActivity mActivity;

    protected RecyclerView mPokemonListView;

    protected View mLoadingView;

    protected TextView mRetryView;

    protected List<Pokemon> mPokemons;

    protected View mFirstItem;

    public PokemonListActivityBaseTest()
    {

        super(PokemonListActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {

        super.setUp();
        mActivity = getActivity();
        fillPokemonList();
        getViewElements();
    }

    protected void fillPokemonList()
    {

        mPokemons = new ArrayList<>();
        mPokemons.add(new Pokemon("Balbasaur", ""));
        mPokemons.add(new Pokemon("Pidgeot", ""));
    }

    protected void getViewElements()
    {

        mPokemonListView = (RecyclerView) mActivity.findViewById(R.id.pokemon_list);
        mLoadingView = mActivity.findViewById(R.id.loading_view);
        mRetryView = (TextView) mActivity.findViewById(R.id.error_view);
    }

    public void testTitle()
    {

        assertEquals(mActivity.getString(R.string.pokemon_list_title), mActivity.getTitle());
    }

    protected void assertShowingLoadingView()
    {

        assertEquals(View.GONE, mPokemonListView.getVisibility());
        assertEquals(View.GONE, mRetryView.getVisibility());
        assertEquals(View.VISIBLE, mLoadingView.getVisibility());
    }

    protected void assertShowingRetryView()
    {

        assertEquals(View.GONE, mPokemonListView.getVisibility());
        assertEquals(View.VISIBLE, mRetryView.getVisibility());
        assertEquals(View.GONE, mLoadingView.getVisibility());
    }

    protected void assertListView()
    {

        assertNotNull(mPokemonListView);
        assertEquals(LinearLayout.LayoutParams.MATCH_PARENT,
            mPokemonListView.getLayoutParams().height);
        assertEquals(LinearLayout.LayoutParams.MATCH_PARENT,
            mPokemonListView.getLayoutParams().width);
    }

    protected void assertElements()
    {

        int index = 0;
        assertEquals(mPokemons.size(), mPokemonListView.getAdapter().getItemCount());
        for (Pokemon pokemon : mPokemons)
        {
            assertListItem(index, pokemon);
            index++;
        }
    }

    protected void assertListItem(int position, Pokemon pokemon)
    {

        View item = mPokemonListView.getChildAt(position);
        ImageView pokemonPicture = (ImageView) item.findViewById(R.id.pokemon_picture);
        TextView pokemonName = (TextView) item.findViewById(R.id.pokemon_name);
        assertNotNull(pokemonPicture);
        assertNotNull(pokemonName);
        assertEquals(60, pokemonPicture.getLayoutParams().width);
        assertEquals(60, pokemonPicture.getLayoutParams().height);
        assertEquals(LinearLayout.LayoutParams.MATCH_PARENT, pokemonName.getLayoutParams().width);
        assertEquals(LinearLayout.LayoutParams.WRAP_CONTENT, pokemonName.getLayoutParams().height);
        assertEquals(pokemon.getName(), pokemonName.getText());
    }

    protected void getRowElement()
    {

        mFirstItem = mPokemonListView.getChildAt(0);
    }

    protected void assertChangeScreenOnTap()
    {

        Instrumentation.ActivityMonitor activityMonitor =
            new Instrumentation.ActivityMonitor(PokemonDetailActivity.class.getName(), null, true);
        getInstrumentation().addMonitor(activityMonitor);
        PokemonDetailActivity pokemonDetailActivity =
            (PokemonDetailActivity) getInstrumentation().waitForMonitor(activityMonitor);
        assertNotNull(pokemonDetailActivity);
        pokemonDetailActivity.finish();
    }
}

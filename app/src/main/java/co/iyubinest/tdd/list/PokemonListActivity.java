package co.iyubinest.tdd.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import co.iyubinest.tdd.Pokemon;
import co.iyubinest.tdd.R;
import co.iyubinest.tdd.detail.PokemonDetailActivity;
import java.util.List;

public class PokemonListActivity extends AppCompatActivity implements PokemonListView
{

    private PokemonAdapter mAdapter;

    private RecyclerView mPokemonListView;

    private View mRetryView;

    private View mLoadingView;

    private PokemonListPresenter mPresenter;

    private PokemonListInteractor mInteractor;

    private PokemonAdapter.PokemonClickListener mPokemonClickListener =
        new PokemonAdapter.PokemonClickListener()
        {

            @Override
            public void onPokemonCLick(Pokemon pokemon)
            {

                PokemonDetailActivity.start(getContext(), pokemon);
            }
        };

    private Context getContext()
    {

        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mInteractor = new DefaultPokemonListInteractor();
        mPresenter = new PokemonListPresenter(this, mInteractor);
        getPokemons();
    }

    private void initView()
    {

        mAdapter = new PokemonAdapter(mPokemonClickListener);
        mRetryView = findViewById(R.id.error_view);
        mLoadingView = findViewById(R.id.loading_view);
        mPokemonListView = (RecyclerView) findViewById(R.id.pokemon_list);
        mPokemonListView.setLayoutManager(new LinearLayoutManager(this));
        mPokemonListView.setAdapter(mAdapter);
    }

    private void getPokemons()
    {

        showView(mLoadingView);
        mPresenter.getPokemons();
    }

    private void showView(View view)
    {

        mPokemonListView.setVisibility(View.GONE);
        mRetryView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void load(List<Pokemon> mPokemons)
    {

        mAdapter.add(mPokemons);
        showView(mPokemonListView);
    }

    @Override
    public void showRetry()
    {

        showView(mRetryView);
    }

    public void retry(View view)
    {

        getPokemons();
    }
}

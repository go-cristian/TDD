package co.iyubinest.tdd.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import co.iyubinest.tdd.Pokemon;
import co.iyubinest.tdd.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiangomez on 2/12/15.
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>
{

    private final PokemonClickListener mPokemonClickListener;

    public interface PokemonClickListener
    {

        void onPokemonCLick(Pokemon pokemon);
    }

    private List<Pokemon> mPokemons;

    private PokemonViewHolder.PokemonHolderClickListener holderListener =
        new PokemonViewHolder.PokemonHolderClickListener()
        {

            @Override
            public void onClickHolder(int position)
            {

                mPokemonClickListener.onPokemonCLick(mPokemons.get(position));
            }
        };

    public PokemonAdapter(PokemonClickListener pokemonClickListener)
    {

        mPokemons = new ArrayList<>();
        mPokemonClickListener = pokemonClickListener;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view, holderListener);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position)
    {

        Pokemon pokemon = mPokemons.get(position);
        holder.nameView.setText(pokemon.getName());
    }

    @Override
    public int getItemCount()
    {

        return mPokemons.size();
    }

    public void add(List<Pokemon> pokemons)
    {

        mPokemons.addAll(pokemons);
        notifyDataSetChanged();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder
    {

        private final PokemonHolderClickListener mPokemonHolderClickListener;

        private final View.OnClickListener itemClickListener = new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                mPokemonHolderClickListener.onClickHolder(getAdapterPosition());
            }
        };

        public interface PokemonHolderClickListener
        {

            void onClickHolder(int position);
        }

        public TextView nameView;

        public PokemonViewHolder(View itemView,
            PokemonHolderClickListener pokemonHolderClickListener)
        {

            super(itemView);
            itemView.setOnClickListener(itemClickListener);
            mPokemonHolderClickListener = pokemonHolderClickListener;
            nameView = (TextView) itemView.findViewById(R.id.pokemon_name);
        }
    }
}

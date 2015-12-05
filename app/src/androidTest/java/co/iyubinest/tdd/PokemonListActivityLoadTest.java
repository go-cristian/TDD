package co.iyubinest.tdd;

import android.test.suitebuilder.annotation.MediumTest;

/**
 * Created by cristiangomez on 1/12/15.
 */
public class PokemonListActivityLoadTest extends PokemonListActivityBaseTest
{

    @MediumTest
    public void testListPokemons()
    {

        assertShowingLoadingView();
        mActivity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {

                mActivity.load(mPokemons);
            }
        });
        getInstrumentation().waitForIdleSync();
        getRowElement();
        assertListView();
        assertElements();
        mActivity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {

                mFirstItem.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();
        assertChangeScreenOnTap();
    }
}

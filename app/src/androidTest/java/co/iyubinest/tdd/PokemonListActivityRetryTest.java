package co.iyubinest.tdd;

import android.test.UiThreadTest;

/**
 * Created by cristiangomez on 1/12/15.
 */
public class PokemonListActivityRetryTest extends PokemonListActivityBaseTest
{

    @UiThreadTest
    public void testRetryView() throws InterruptedException
    {

        assertShowingLoadingView();
        mActivity.showRetry();
        assertEquals(getActivity().getString(R.string.retry), mRetryView.getText().toString());
        assertShowingRetryView();
        mRetryView.performClick();
        assertShowingLoadingView();
    }
}

package us.antenado.sthetosample.Activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import us.antenado.sthetosample.R;

/**
 * Created by isilva on 19/07/16.
 */
public class SharedPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Trying to avoid a dependency on the support library and go all the way back to Gingerbread,
        // so we can't rely on the fragment-based preferences and must use the old deprecated methods.
        addPreferencesFromResource(R.xml.settings);
    }
}

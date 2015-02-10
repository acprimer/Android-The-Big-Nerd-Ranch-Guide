package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}

package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;
import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

}

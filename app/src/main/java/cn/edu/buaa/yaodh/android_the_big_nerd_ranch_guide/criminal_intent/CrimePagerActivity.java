package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.UUID;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

/**
 * Created by yaodh on 2014/12/18.
 */
public class CrimePagerActivity extends ActionBarActivity {
    private ViewPager mViewPager;
    private ArrayList<Crime> mCrimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.view_pager);
        setContentView(mViewPager);

        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                Crime c = mCrimes.get(i);
                return CrimeFragment.newInstance(c.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for(int i=0;i<mCrimes.size();i++) {
            if(mCrimes.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                setTitle(mCrimes.get(i).getTitle());
                break;
            }
        }
    }
}

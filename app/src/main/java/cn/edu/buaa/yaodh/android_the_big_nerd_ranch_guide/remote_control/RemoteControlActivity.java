package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.remote_control;

import android.support.v4.app.Fragment;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.SingleFragmentActivity;

/**
 * Created by yaodh on 2015/2/11.
 */
public class RemoteControlActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RemoteControlFragment();
    }
}

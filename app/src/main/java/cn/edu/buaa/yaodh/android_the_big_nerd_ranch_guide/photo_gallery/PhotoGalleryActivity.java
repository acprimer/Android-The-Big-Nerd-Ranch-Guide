package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.photo_gallery;

import android.support.v4.app.Fragment;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.SingleFragmentActivity;

/**
 * Created by yaodh on 2015/2/11.
 */
public class PhotoGalleryActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PhotoGalleryFragment();
    }
}

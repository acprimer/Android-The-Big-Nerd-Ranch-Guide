package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.drag_and_draw;

import android.graphics.PointF;

/**
 * Created by yaodh on 2015/2/11.
 */
public class Box {
    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin) {
        mOrigin = mCurrent = origin;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
    }
}

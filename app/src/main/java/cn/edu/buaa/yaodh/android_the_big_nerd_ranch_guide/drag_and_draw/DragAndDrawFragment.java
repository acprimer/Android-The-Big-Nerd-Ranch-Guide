package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.drag_and_draw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

/**
 * Created by yaodh on 2015/2/11.
 */
public class DragAndDrawFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_and_draw, container, false);
        return view;
    }
}

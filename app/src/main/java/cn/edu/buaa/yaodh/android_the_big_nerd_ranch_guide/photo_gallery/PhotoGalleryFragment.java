package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.photo_gallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

/**
 * Created by yaodh on 2015/2/11.
 */
public class PhotoGalleryFragment extends Fragment {
    private static final String TAg = "PhotoGallery";
    private GridView mGridView;

    private class FetchItemsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try{
                String result = new FlickrFetchr().getUrl("http://www.baidu.com");
                Log.i(TAg, "Fetched contents of URL: " + result);
            } catch (IOException e) {
                Log.e(TAg, "Failed to fetch URL: ", e);
            }
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        mGridView = (GridView) view.findViewById(R.id.gridView);
        return view;
    }
}

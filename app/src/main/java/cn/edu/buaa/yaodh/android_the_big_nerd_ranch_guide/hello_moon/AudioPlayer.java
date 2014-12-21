package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.hello_moon;

import android.content.Context;
import android.media.MediaPlayer;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

/**
 * Created by yaodh on 2014/12/21.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context context) {
        stop();

        mPlayer = MediaPlayer.create(context, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }
}

package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.geo_quiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

public class CheatActivity extends ActionBarActivity {
    public static final String EXTRA_ANSWER_IS_TRUE = "answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "answer_shown";
    public static final String KEY_CHEATER = "cheater";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswerButton;
    private TextView mAPILevelTextView;

    private boolean mIsAnswerShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null) {
            mIsAnswerShown = savedInstanceState.getBoolean(KEY_CHEATER, false);
        }

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        setAnswerShownForResult();

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        showAnswer();

        mAPILevelTextView = (TextView) findViewById(R.id.api_level_text_view);
        mAPILevelTextView.setText("API Level " + Build.VERSION.SDK_INT);

        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsAnswerShown = true;
                showAnswer();
                setAnswerShownForResult();
            }
        });
    }

    private void showAnswer() {
        if(!mIsAnswerShown) {
            return;
        }
        if (mAnswerIsTrue) {
            mAnswerTextView.setText(R.string.true_button);
        } else {
            mAnswerTextView.setText(R.string.false_button);
        }
    }

    public void setAnswerShownForResult() {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, mIsAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_CHEATER, mIsAnswerShown);
    }
}

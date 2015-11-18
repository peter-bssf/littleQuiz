package com.pengl.littlequiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER = "extra_answer";
    private static final String EXTRA_CHEAT  = "extra_cheat";
    Button mShowAnswer;
    TextView mAnswerTextView;

    public static boolean wasAnswerShow(Intent result) {
        return result.getBooleanExtra(EXTRA_CHEAT, false);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(CheatActivity.EXTRA_ANSWER, answerIsTrue);

        return i;
    }

    private void setCheat(boolean cheat) {
        Intent data = new Intent();
        data.putExtra(EXTRA_CHEAT, cheat);
        setResult(Activity.RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAnswerTextView = (TextView)findViewById(R.id.answer_text);
        mShowAnswer = (Button)findViewById(R.id.show_answer);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean resId = getIntent().getBooleanExtra(EXTRA_ANSWER, false);
                int messageId;

                if(resId) {
                    messageId = R.string.true_button;
                } else {
                    messageId = R.string.false_button;
                }
                mAnswerTextView.setText(messageId);
                setCheat(true);
            }
        });
    }

}

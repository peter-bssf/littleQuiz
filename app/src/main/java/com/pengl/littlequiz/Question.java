package com.pengl.littlequiz;

/**
 * Created by pengl on 2015/11/17.
 */
public class Question {
    private int mTextResId;
    private boolean mQuestionIsTrue;

    public Question(int textResId, boolean questionIsTrue){
        mTextResId = textResId;
        mQuestionIsTrue = questionIsTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isQuestionIsTrue() {
        return mQuestionIsTrue;
    }

    public void setQuestionIsTrue(boolean questionIsTrue) {
        mQuestionIsTrue = questionIsTrue;
    }
}

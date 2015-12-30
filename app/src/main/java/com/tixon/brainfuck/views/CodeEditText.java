package com.tixon.brainfuck.views;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by tikhon on 30/12/15.
 */
public class CodeEditText extends EditText {

    private int indexStart, indexEnd;
    private int color;

    public CodeEditText(Context context) {
        super(context);
        init();
    }

    public CodeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.indexStart = 0;
        this.indexEnd = 0;
        this.color = Color.GREEN;
    }

    public void hideSpan() {
        this.selectSpannable(0, 0);
    }

    public void restoreSpan() {
        this.selectSpannable(this.indexStart, this.indexEnd);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void selectSpannable(int from, int to) {
        Spannable spannableString = new SpannableString(this.getText());
        Object spansToRemove[] = spannableString.getSpans(this.indexStart, this.indexEnd, Object.class);
        for(Object span: spansToRemove) {
            if (span instanceof CharacterStyle) {
                spannableString.removeSpan(span);
            }
        }

        this.indexStart = from;
        this.indexEnd = to;
        spannableString.setSpan(new BackgroundColorSpan(this.color), from, to, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.setText(spannableString, TextView.BufferType.SPANNABLE);
    }
}

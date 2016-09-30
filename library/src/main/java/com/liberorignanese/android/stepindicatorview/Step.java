package com.liberorignanese.android.stepindicatorview;

import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Libero Rignanese.
 * read license file for more informations.
 */


public class Step {

    private String text;
    private boolean completed = false;
    private boolean current = false;

    private View.OnClickListener onClickListener;

    public Step(String text, boolean completed, boolean current) {
        this.text = text;
        this.completed = completed;
        this.current = current;
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    private int alpha = 150;

    public void setUpView(View stepView, Step previous, Step next, @LinearLayoutCompat.OrientationMode int orientation) {
        ImageView iconView = (ImageView) stepView.findViewById(R.id.icon_step_layout);
        ImageView lineStartView = (ImageView) stepView.findViewById(R.id.linestart_step_layout);
        ImageView lineEndView = (ImageView) stepView.findViewById(R.id.lineend_step_layout);
        TextView textView = (TextView) stepView.findViewById(R.id.text_step_layout);

        int line_completed = orientation == LinearLayoutCompat.HORIZONTAL ? R.drawable.line_completed_horizontal : R.drawable.line_completed_vertical;
        int line_uncompleted = orientation == LinearLayoutCompat.HORIZONTAL ? R.drawable.line_uncompleted_horizontal: R.drawable.line_uncompleted_vertical;
        int icon_completed = R.drawable.icon_check;
        int icon_uncompleted = R.drawable.icon_uncompleted;

        if(previous == null){
            lineStartView.setVisibility(View.INVISIBLE);
        }else{
            lineStartView.setVisibility(View.VISIBLE);
            if(previous.isCompleted()){
                lineStartView.setImageResource(line_completed);
                lineStartView.setImageAlpha(255);
            }else{
                lineStartView.setImageResource(line_uncompleted);
                lineStartView.setImageAlpha(alpha);
            }
        }
        if(next == null){
            lineEndView.setVisibility(View.INVISIBLE);
        }else{
            lineEndView.setVisibility(View.VISIBLE);
            if(isCompleted()){
                lineEndView.setImageResource(line_completed);
                lineEndView.setImageAlpha(255);
            }else{
                lineEndView.setImageResource(line_uncompleted);
                lineEndView.setImageAlpha(alpha);
            }
        }
        textView.setText(getText());
        if(isCurrent()){
            textView.setTypeface(null, Typeface.BOLD);
        }else{
            textView.setTypeface(null, Typeface.NORMAL);
        }
        if(isCompleted()){
            iconView.setImageResource(icon_completed);
            iconView.setImageAlpha(255);
        }else{
            iconView.setImageResource(icon_uncompleted);
            if(isCurrent()){
                iconView.setImageAlpha(255);
            }else{
                iconView.setImageAlpha(alpha);
            }
        }
        stepView.setOnClickListener(onClickListener);

    }
}

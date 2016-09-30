package com.liberorignanese.android.stepindicatorview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Libero Rignanese.
 * read license file for more informations.
 */


public class StepIndicatorView extends LinearLayout {

    private List<Step> steps;

    private void initSteps(){
        if(steps == null){
            steps = new ArrayList<>();
        }
    }

    public void addStep(Step step){
        initSteps();
        steps.add(step);
    }

    public StepIndicatorView(Context context) {
        super(context);
    }

    public StepIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StepIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void draw(){
        removeAllViews();
        if(steps != null){
            Step previous = null;
            Step next = null;
            int stepsSize = steps.size();
            for (int i = 0; i < stepsSize; i++) {

                View stepView;
                if(getOrientation() == HORIZONTAL){
                    stepView = LayoutInflater.from(getContext()).inflate(R.layout.step_layout_horizontal, null);
                }else{
                    stepView = LayoutInflater.from(getContext()).inflate(R.layout.step_layout_vertical, null);
                }

                Step step = steps.get(i);
                int nextIndex = (i + 1);
                next = (nextIndex < stepsSize) ? steps.get(nextIndex) : null;
                step.setUpView(stepView, previous, next, getOrientation());
                previous = step;
                addView(stepView);
            }
        }
    }

}

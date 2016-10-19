package com.liberorignanese.android.stepindicatorview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.liberorignanese.android.stepindicatorview.Step;
import com.liberorignanese.android.stepindicatorview.StepIndicatorView;

public class MainActivity extends AppCompatActivity {

    private StepIndicatorView mStepView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStepView = (StepIndicatorView) findViewById(R.id.step_view);
//        mStepView.setUseSecondaryStepColor(true);
        final Step step1 = new Step("Eccolo 1", true, false);
        final Step step2 = new Step("Eccolo 2", true, true);
        final Step step3 = new Step("Eccolo 3", false, false);
        final Step step4 = new Step("Eccolo 4", false, false);

        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                step1.setCompleted(true);
                step2.setCompleted(false);
                step3.setCompleted(false);
                step4.setCompleted(false);
                step1.setCurrent(false);
                step2.setCurrent(true);
                step3.setCurrent(false);
                step4.setCurrent(false);

                mStepView.draw();
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step1.setCompleted(true);
                step2.setCompleted(true);
                step3.setCompleted(false);
                step4.setCompleted(false);
                step1.setCurrent(false);
                step2.setCurrent(false);
                step3.setCurrent(true);
                step4.setCurrent(false);
                mStepView.draw();
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step1.setCompleted(true);
                step2.setCompleted(true);
                step3.setCompleted(true);
                step4.setCompleted(false);
                step1.setCurrent(false);
                step2.setCurrent(false);
                step3.setCurrent(false);
                step4.setCurrent(true);
                mStepView.draw();
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step1.setCompleted(true);
                step2.setCompleted(true);
                step3.setCompleted(true);
                step4.setCompleted(true);
                step1.setCurrent(false);
                step2.setCurrent(false);
                step3.setCurrent(false);
                step4.setCurrent(false);
                mStepView.draw();
            }
        });

        mStepView.addStep(step1);
        mStepView.addStep(step2);
        mStepView.addStep(step3);
        mStepView.addStep(step4);
        mStepView.draw();

    }

}

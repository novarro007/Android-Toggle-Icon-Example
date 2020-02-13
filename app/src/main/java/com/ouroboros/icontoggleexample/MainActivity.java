package com.ouroboros.icontoggleexample;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        final ToggleButton toggleButton = findViewById(R.id.toggle1);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder xHolder = PropertyValuesHolder.ofFloat("scaleX", 0.7f, 1f);
                PropertyValuesHolder yHolder = PropertyValuesHolder.ofFloat("scaleY", 0.7f, 1f);
                Animator animator = ObjectAnimator.ofPropertyValuesHolder(toggleButton, xHolder, yHolder);
                animator.setDuration(400);
                animator.setInterpolator(new OvershootInterpolator());
                animator.start();
            }
        });

        findViewById(R.id.toggle2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake));
            }
        });

        findViewById(R.id.toggle3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder yHolder = PropertyValuesHolder.ofFloat("scaleX", 0.6f, 1f);
                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, yHolder);
                animator.setDuration(500);
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.start();
            }
        });
    }
}

package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.scoreText);
        imageView = findViewById(R.id.dice);
        button = findViewById(R.id.tossbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int score = random.nextInt(6)+1;
                startanimation();
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(score));
                        switch (score){
                            case 1:
                                imageView.setImageResource(R.drawable.one);
                                break;

                            case 2:
                                imageView.setImageResource(R.drawable.two);
                                break;

                            case 3:
                                imageView.setImageResource(R.drawable.three);
                                break;

                            case 4:
                                imageView.setImageResource(R.drawable.four);
                                break;

                            case 5:
                                imageView.setImageResource(R.drawable.five);
                                break;

                            case 6:
                                imageView.setImageResource(R.drawable.six);
                                break;
                        }
                    }
                },1000);




            }
        });
    }

    public void startanimation(){
        ObjectAnimator animator= ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
}
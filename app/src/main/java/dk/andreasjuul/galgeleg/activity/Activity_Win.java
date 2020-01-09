package dk.andreasjuul.galgeleg.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.airbnb.lottie.LottieAnimationView;

import dk.andreasjuul.galgeleg.MainActivity;
import dk.andreasjuul.galgeleg.R;


public class Activity_Win extends AppCompatActivity implements View.OnClickListener {

    Button buttonHome, buttonPlay;
    TextView textFejl;
    private LottieAnimationView firework;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        buttonHome = findViewById(R.id.buttonBack);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonHome.setOnClickListener(this);
        firework = findViewById(R.id.firework);


        firework.setSpeed(1);
        firework.playAnimation();
        firework.setRepeatCount(10);
    }

    @Override
    public void onClick(final View view) {
        if (view == buttonHome) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view == buttonPlay) {
            startActivity(new Intent(this, Activity_Game.class));
        }
    }
}

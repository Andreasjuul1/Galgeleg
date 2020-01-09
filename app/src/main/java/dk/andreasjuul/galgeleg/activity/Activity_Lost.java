package dk.andreasjuul.galgeleg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import dk.andreasjuul.galgeleg.Galgelogik;
import dk.andreasjuul.galgeleg.MainActivity;
import dk.andreasjuul.galgeleg.R;

public class Activity_Lost extends AppCompatActivity implements View.OnClickListener {

    Button buttonHome, buttonPlay;
    Galgelogik galgeLogik;
    private LottieAnimationView crying;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        buttonHome = findViewById(R.id.buttonBack);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonHome.setOnClickListener(this);

        crying = findViewById(R.id.crying);


        crying.setSpeed(1);
        crying.playAnimation();
        crying.setRepeatCount(10);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonHome) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (v == buttonPlay) {
            startActivity(new Intent(this, Activity_Game.class));
        }
    }
}
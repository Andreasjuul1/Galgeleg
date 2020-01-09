package dk.andreasjuul.galgeleg.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dk.andreasjuul.galgeleg.MainActivity;
import dk.andreasjuul.galgeleg.R;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class Activity_win extends AppCompatActivity implements View.OnClickListener {

    Button buttonHome, buttonPlay, buttonKonfetti;
    KonfettiView konfettiView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        buttonHome = findViewById(R.id.buttonBack);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonKonfetti = findViewById(R.id.buttonKonfetti);
        final KonfettiView konfettiView = findViewById(R.id.viewKonfetti);
        buttonPlay.setOnClickListener(this);
        buttonHome.setOnClickListener(this);
    }

        @Override
        public void onClick ( final View view){
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);
            if (view == buttonHome) {
                startActivity(new Intent(this, MainActivity.class));
            }
            if (view == buttonPlay) {
                startActivity(new Intent(this, Activity_game.class));
            }
    }
}

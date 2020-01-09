package dk.andreasjuul.galgeleg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dk.andreasjuul.galgeleg.MainActivity;
import dk.andreasjuul.galgeleg.R;


public class Activity_Help extends AppCompatActivity implements View.OnClickListener {

    TextView textHelp;
    Button buttonHome, buttonPlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        buttonHome = findViewById(R.id.buttonBack);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonHome.setOnClickListener(this);

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
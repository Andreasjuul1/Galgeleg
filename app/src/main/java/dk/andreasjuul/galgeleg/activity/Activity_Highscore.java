package dk.andreasjuul.galgeleg.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import dk.andreasjuul.galgeleg.MainActivity;
import dk.andreasjuul.galgeleg.R;
import dk.andreasjuul.galgeleg.adapter.*;

public class Activity_Highscore extends AppCompatActivity implements View.OnClickListener {
    private Highscore[] updatedHighscores;
    private SharedPreferences preferences;
    Button buttonBack,buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        //Struktur taget fra Android studios
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        updatedHighscores = getHighscores();

        buttonBack = findViewById(R.id.buttonBack);
        buttonPlay = findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(this);
        buttonBack.setOnClickListener(this);

        ListView highscoreList = (ListView) findViewById(R.id.hs_list);
        Adapter_highscore highscoreAdapter = new Adapter_highscore(this, updatedHighscores);
        highscoreList.setAdapter(highscoreAdapter);
    }

    private Highscore[] getHighscores () {
        Highscore[] highscores;

        highscores = new Highscore[preferences.getAll().size()];
        int counter = 0;
        for (Map.Entry<String, ?> pair : preferences.getAll().entrySet()) {
            Highscore highscore = new Highscore((String) pair.getKey(), (Integer) pair.getValue());
            highscores[counter] = highscore;
            counter++;
        }
        //sorterer highscoren
        Arrays.sort(highscores, Collections.reverseOrder());
        return highscores;
    }

    @Override
    public void onClick(View v) {
        if (v == buttonBack) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (v == buttonPlay) {
            startActivity(new Intent(this, Activity_Game.class));
        }
    }

}
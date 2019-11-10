package dk.andreasjuul.galgeleg;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPlay, buttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.play);
        buttonHelp = findViewById(R.id.help);

        buttonPlay.setOnClickListener(this);
        buttonHelp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == buttonPlay) {
            startActivity(new Intent(this, Activity_game.class));
        }
        if (v == buttonHelp) {
            startActivity(new Intent(this, Activity_help.class));
        }
    }
}
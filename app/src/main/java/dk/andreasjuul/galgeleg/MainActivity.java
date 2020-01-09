package dk.andreasjuul.galgeleg;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;

import dk.andreasjuul.galgeleg.activity.Activity_Highscore;
import dk.andreasjuul.galgeleg.activity.Activity_Game;
import dk.andreasjuul.galgeleg.activity.Activity_Help;
import dk.andreasjuul.galgeleg.activity.Activity_WordList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPlay, buttonHelp, buttonData, buttonHS, buttonWordList;
    private LottieAnimationView progress;
    RelativeLayout rellay1;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.play);
        buttonHelp = findViewById(R.id.help);
        buttonData = findViewById(R.id.buttonData);
        buttonHS = findViewById(R.id.buttonHS);
        buttonWordList = findViewById(R.id.buttonWordList);

        buttonPlay.setOnClickListener(this);
        buttonHelp.setOnClickListener(this);
        buttonData.setOnClickListener(this);
        buttonHS.setOnClickListener(this);
        buttonWordList.setOnClickListener(this);
        HentDataFraDR(getApplicationContext());
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        progress = findViewById(R.id.progressBar);
        handler.postDelayed(runnable, 2200);
    }


    @Override
    public void onClick(View v) {
        if (v == buttonData) {
            progress.setMaxFrame(386);
            progress.setSpeed(3);
            progress.playAnimation();

        }
        if (v == buttonPlay) {
            startActivity(new Intent(this, Activity_Game.class));

        }
        if (v == buttonHelp) {
            startActivity(new Intent(this, Activity_Help.class));
        }
        if (v == buttonHS){
            startActivity(new Intent(this, Activity_Highscore.class));
        }
        if (v == buttonWordList){
            startActivity(new Intent(this, Activity_WordList.class));
        }
    }

    private static void HentDataFraDR(Context context) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    Galgelogik galgelogik = new Galgelogik();
                    galgelogik.hentOrdFraDr();
                    Galgelogik.OrdListeFraDR = galgelogik.muligeOrd;
                    return "Ord fra DR hentet til APP";
                } catch (Exception e) {
                    return "Spillet spiller på forudbestemte ord" + e;
                }
            }
        }.execute();
    }
}
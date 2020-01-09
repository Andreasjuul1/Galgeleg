package dk.andreasjuul.galgeleg;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPlay, buttonHelp, buttonData;
    private LottieAnimationView progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.play);
        buttonHelp = findViewById(R.id.help);

        buttonPlay.setOnClickListener(this);
        buttonHelp.setOnClickListener(this);

        progress = findViewById(R.id.progressBar);

    }


    @Override
    public void onClick(View v) {
        if (v == buttonData) {
            HentDataFraDR(getApplicationContext());
            progress.setMaxFrame(386);
            progress.setSpeed(3);
            progress.playAnimation();
        }
        if (v == buttonPlay) {
            startActivity(new Intent(this, Activity_game.class));

        }
        if (v == buttonHelp) {
            HentDataFraDR(getApplicationContext());
            startActivity(new Intent(this, Activity_help.class));
            progress.setMaxFrame(386);
            progress.setSpeed(3);
            progress.playAnimation();
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
                }
                catch (Exception e) {
                    return "Spillet spiller på forudbestemte ord"+e;
                }
            }
        }.execute();
    }
}
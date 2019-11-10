package dk.andreasjuul.galgeleg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



public class Activity_game extends AppCompatActivity implements View.OnClickListener{

    TextView textViewWord, textViewErrors, textViewLettersUsed;
    EditText editTextGuess;
    Button buttonGuess, buttonBack;
    ArrayList<String> wrongLetters = new ArrayList<>();
    ImageView imageViewHangingMan;

    Galgelogik galgeLogik;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewWord = (TextView) findViewById(R.id.textViewWord);
        textViewErrors = (TextView) findViewById(R.id.wrongLetters);
        textViewLettersUsed = (TextView) findViewById(R.id.wrongLetters);
        buttonGuess = (Button) findViewById(R.id.buttonGuess);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        imageViewHangingMan = (ImageView) findViewById(R.id.Hangman);

        galgeLogik = new Galgelogik();
        galgeLogik.nulstil();

        textViewWord.setText(galgeLogik.getSynligtOrd());

        textViewErrors.setText("" + galgeLogik.getAntalForkerteBogstaver() + " / 7 fejl.");

        buttonGuess.setOnClickListener(this);
        buttonBack.setOnClickListener(this);

    }
    public void onClick(View v) {
        String guessedLetters = "";
        if (v == buttonGuess) {
            guessedLetters = editTextGuess.getText().toString();
            guessedLetters = guessedLetters.toLowerCase();
            editTextGuess.getText().clear();
            galgeLogik.gætBogstav(guessedLetters);
            isGameFinished();
            guess(guessedLetters);
        }
    }
    private void guess(String letterGuessed) {
        if (galgeLogik.erSidsteBogstavKorrekt()) {
            textViewWord.setText(galgeLogik.getSynligtOrd());
        } else {
            if (!letterGuessed.isEmpty() && !wrongLetters.contains(letterGuessed.toString())) {
                wrongLetters.add(letterGuessed);
            }
            textViewErrors.setText("" + galgeLogik.getAntalForkerteBogstaver() + " / 7 fejl.");
            textViewLettersUsed.setText(wrongLetters.toString());
            changeImage(galgeLogik.getAntalForkerteBogstaver());
        }
    }
    private void isGameFinished() {
        if (galgeLogik.erSpilletSlut()) {
            if (galgeLogik.erSpilletVundet()) {
                buttonGuess.setText("Jaaa du har vundet!!!!");
                buttonGuess.setOnClickListener(null);
            } else

            if (galgeLogik.erSpilletTabt()) {
                buttonGuess.setText("Øv!! du tabte prøv igen!");
                buttonGuess.setOnClickListener(null);
            }
        }

         private void changeImage(int antalForkerteBogstaver){
            switch (antalForkerteBogstaver) {
                case 1:
                    imageViewHangingMan.setImageResource(R.drawable.forkert1);
                    break;
                case 2:
                    imageViewHangingMan.setImageResource(R.drawable.forkert2);
                    break;
                case 3:
                    imageViewHangingMan.setImageResource(R.drawable.forkert3);
                    break;
                case 4:
                    imageViewHangingMan.setImageResource(R.drawable.forkert4);
                    break;
                case 5:
                    imageViewHangingMan.setImageResource(R.drawable.forkert5);
                    break;
                case 6:
                    imageViewHangingMan.setImageResource(R.drawable.forkert6);
                    break;
            }
        }

    }


}
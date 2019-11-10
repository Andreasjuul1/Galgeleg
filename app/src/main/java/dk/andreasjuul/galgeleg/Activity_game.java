package dk.andreasjuul.galgeleg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Activity_game extends AppCompatActivity implements View.OnClickListener {

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

        textViewWord =findViewById(R.id.textViewWord);
        textViewErrors = findViewById(R.id.wrongLetters);
        textViewLettersUsed = findViewById(R.id.wrongLetters);
        editTextGuess = findViewById(R.id.editTextGuess);
        buttonGuess = findViewById(R.id.buttonGuess);
        buttonBack = findViewById(R.id.buttonBack);
        imageViewHangingMan = findViewById(R.id.Hangman);

        galgeLogik = new Galgelogik();
        galgeLogik.nulstil();

        textViewWord.setText(galgeLogik.getSynligtOrd());


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
        if (v == buttonBack) {
            finish();
        }
        }

    private void guess(String letterGuessed) {
        if (galgeLogik.erSidsteBogstavKorrekt()) {
            textViewWord.setText(galgeLogik.getSynligtOrd());
        } else {
            if (!letterGuessed.isEmpty() && !wrongLetters.contains(letterGuessed)) {
                wrongLetters.add(letterGuessed);
            }
            textViewLettersUsed.setText(wrongLetters.toString());
            changeImage(galgeLogik.getAntalForkerteBogstaver());
        }
    }

    private void changeImage(int antalForkerteBogstaver) {
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

    private void isGameFinished() {
        if (galgeLogik.erSpilletSlut()) {
            if (galgeLogik.erSpilletVundet()) {
                buttonGuess.setText("Jaaa du har vundet!!!!");
                buttonGuess.setOnClickListener(null);hideKeyboard(this);
                startActivity(new Intent(this, Activity_win.class));
            } else if (galgeLogik.erSpilletTabt()) {
                buttonGuess.setText("Øv!! du tabte prøv igen!");
                buttonGuess.setOnClickListener(null);hideKeyboard(this);
                startActivity(new Intent(this, Activity_lost.class));
            }
        }
    }
    //https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
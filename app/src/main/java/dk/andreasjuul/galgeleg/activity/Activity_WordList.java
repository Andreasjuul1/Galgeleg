package dk.andreasjuul.galgeleg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import dk.andreasjuul.galgeleg.Galgelogik;
import dk.andreasjuul.galgeleg.MainActivity;
import dk.andreasjuul.galgeleg.R;

public class Activity_WordList extends AppCompatActivity implements View.OnClickListener {
    private Galgelogik galgelogikGetAllAvailable = new Galgelogik();
    Button buttonHome, buttonPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist);

        buttonHome = findViewById(R.id.buttonBack);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonHome.setOnClickListener(this);

        ArrayList<String> words = galgelogikGetAllAvailable.muligeOrd;
        //Opbygning af adapter, taget fra Android developer
        ListView listView = (ListView) findViewById(R.id.wordListView);
        ArrayAdapter<String> wordAdapter = new ArrayAdapter<String>(this,R.layout.word_listview,R.id.words,words);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), Activity_Game.class);
                startActivity(intent);
            }
        });
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

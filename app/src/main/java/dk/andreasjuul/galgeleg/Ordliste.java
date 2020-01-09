package dk.andreasjuul.galgeleg;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import dk.andreasjuul.galgeleg.Activity.*;
import java.util.ArrayList;



public class Ordliste extends AppCompatActivity {
    private Galgelogik drOrdHentet = new Galgelogik();
    @Override
    //https://developer.android.com/reference/android/widget/ArrayAdapter
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
        //<-- TODO Mangler XML FIL til layout og listview -->
        ArrayList<String> words = drOrdHentet.muligeOrd;

        ListView listView = (ListView) findViewById(R.id.);
        ArrayAdapter<String> wordAdapter = new ArrayAdapter<String>(this,R.layout.,R.id.,words);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedWord = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), Activity_game.class);
                intent.putExtra("Valgt Ord", clickedWord);
                startActivity(intent);
            }
        });
    }
}

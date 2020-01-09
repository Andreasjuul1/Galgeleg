package dk.andreasjuul.galgeleg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dk.andreasjuul.galgeleg.R;
import dk.andreasjuul.galgeleg.activity.Highscore;

public class Adapter_highscore extends ArrayAdapter<Highscore> {
        private Context context;
        private Highscore[] highscores;

        public Adapter_highscore(@NonNull Context context, Highscore[] list) {
            super(context,0, list);
            this.context = context;
            this.highscores = list;
        }

        @NonNull
        @Override
        public View getView (int position, @Nullable View convertView, ViewGroup parent) {
            View highscoreElement = convertView;
            if (highscoreElement == null)
                highscoreElement = LayoutInflater.from(this.context).inflate(R.layout.highscore_listview,parent,false);
            Highscore highscore = highscores[position];
            //tilføjer ordet til highscorelisten
            TextView ord = (TextView) highscoreElement.findViewById(R.id.Word);
            ord.setText(highscore.getOrd());
            //tilføjer scoren til highscorelisten
            TextView score = (TextView) highscoreElement.findViewById(R.id.score);
            score.setText(String.valueOf(highscore.getScore()));

            return highscoreElement;
        }

    }
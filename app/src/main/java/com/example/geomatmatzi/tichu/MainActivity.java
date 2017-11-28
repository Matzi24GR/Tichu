package com.example.geomatmatzi.tichu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.geomatmatzi.tichu.TrueGame.Card;
import com.example.geomatmatzi.tichu.TrueGame.DeckAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        final ArrayList<Card> deck = new ArrayList<Card>();
        final Random random = new Random();
        final GridView gridView = findViewById(R.id.grid_view);
        final DeckAdapter adapter = new DeckAdapter(this, deck);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.comedy);
        gridView.setAdapter(adapter);

        final ArrayList<Card> AllCards = new ArrayList<Card>();

        AllCards.add(new Card(1,1, getApplicationContext()));
        AllCards.add(new Card(1,2, getApplicationContext()));
        AllCards.add(new Card(1,3, getApplicationContext()));
        AllCards.add(new Card(1,4, getApplicationContext()));
        AllCards.add(new Card(1,5, getApplicationContext()));
        AllCards.add(new Card(1,6, getApplicationContext()));
        AllCards.add(new Card(1,7, getApplicationContext()));
        AllCards.add(new Card(1,8, getApplicationContext()));
        AllCards.add(new Card(1,9, getApplicationContext()));
        AllCards.add(new Card(1,10, getApplicationContext()));
        AllCards.add(new Card(1,11, getApplicationContext()));
        AllCards.add(new Card(1,12, getApplicationContext()));
        AllCards.add(new Card(1,13, getApplicationContext()));
        AllCards.add(new Card(2,1, getApplicationContext()));
        AllCards.add(new Card(2,2, getApplicationContext()));
        AllCards.add(new Card(2,3, getApplicationContext()));
        AllCards.add(new Card(2,4, getApplicationContext()));
        AllCards.add(new Card(2,5, getApplicationContext()));
        AllCards.add(new Card(2,6, getApplicationContext()));
        AllCards.add(new Card(2,7, getApplicationContext()));
        AllCards.add(new Card(2,8, getApplicationContext()));
        AllCards.add(new Card(2,9, getApplicationContext()));
        AllCards.add(new Card(2,10, getApplicationContext()));
        AllCards.add(new Card(2,11, getApplicationContext()));
        AllCards.add(new Card(2,12, getApplicationContext()));
        AllCards.add(new Card(2,13, getApplicationContext()));
        AllCards.add(new Card(3,1, getApplicationContext()));
        AllCards.add(new Card(3,2, getApplicationContext()));
        AllCards.add(new Card(3,3, getApplicationContext()));
        AllCards.add(new Card(3,4, getApplicationContext()));
        AllCards.add(new Card(3,5, getApplicationContext()));
        AllCards.add(new Card(3,6, getApplicationContext()));
        AllCards.add(new Card(3,7, getApplicationContext()));
        AllCards.add(new Card(3,8, getApplicationContext()));
        AllCards.add(new Card(3,9, getApplicationContext()));
        AllCards.add(new Card(3,10,getApplicationContext()));
        AllCards.add(new Card(3,11,getApplicationContext()));
        AllCards.add(new Card(3,12,getApplicationContext()));
        AllCards.add(new Card(3,13,getApplicationContext()));
        AllCards.add(new Card(4,1, getApplicationContext()));
        AllCards.add(new Card(4,2, getApplicationContext()));
        AllCards.add(new Card(4,3, getApplicationContext()));
        AllCards.add(new Card(4,4, getApplicationContext()));
        AllCards.add(new Card(4,5, getApplicationContext()));
        AllCards.add(new Card(4,6, getApplicationContext()));
        AllCards.add(new Card(4,7, getApplicationContext()));
        AllCards.add(new Card(4,8, getApplicationContext()));
        AllCards.add(new Card(4,9, getApplicationContext()));
        AllCards.add(new Card(4,10,getApplicationContext()));
        AllCards.add(new Card(4,11,getApplicationContext()));
        AllCards.add(new Card(4,12,getApplicationContext()));
        AllCards.add(new Card(4,13, getApplicationContext()));

        Collections.shuffle(AllCards);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AllCards.size() != 0 ) {
                    deck.add(AllCards.get(0));
                    AllCards.remove(0);
                    adapter.notifyDataSetChanged();
                }

                String cardName = deck.get(deck.size()-1).getCardName();
                Log.v("Cards" , cardName);
                adapter.notifyDataSetChanged();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = deck.get(i);
                Toast toast = Toast.makeText(getApplicationContext(), card.getCardName(), Toast.LENGTH_SHORT);
                toast.show();
                mediaPlayer.start();

            }
        });



    }



}


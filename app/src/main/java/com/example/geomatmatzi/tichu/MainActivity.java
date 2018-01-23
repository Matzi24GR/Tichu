package com.example.geomatmatzi.tichu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.geomatmatzi.tichu.TrueGame.Card;
import com.example.geomatmatzi.tichu.TrueGame.DeckAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button addCardsButton =  findViewById(R.id.add_cards_button);
        final Button sortButton = findViewById(R.id.sort_button);
        final ArrayList<Card> Player1Deck = new ArrayList<Card>();
        final ArrayList<Card> Player2Deck = new ArrayList<Card>();
        final ArrayList<Card> Player3Deck = new ArrayList<Card>();
        final ArrayList<Card> Player4Deck = new ArrayList<Card>();
        final ArrayList<Card> SelectedCards = new ArrayList<>();

        final GridView PlayergridView = findViewById(R.id.player_grid_view);
        final GridView SelectedGridView = findViewById(R.id.select_deck);
        final ImageView ImageButton = findViewById(R.id.ImageButton);
        final DeckAdapter PlayerAdapter = new DeckAdapter(this, Player1Deck);
        PlayergridView.setAdapter(PlayerAdapter);
        final DeckAdapter SelectedAdapter = new DeckAdapter(this, SelectedCards);
        SelectedGridView.setAdapter(SelectedAdapter);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.comedy);

        final ArrayList<Card> AllCards = new ArrayList<Card>();

        AllCards.add(new Card(5,0,20, getApplicationContext())); //mah-jong
        AllCards.add(new Card(6,0,20, getApplicationContext())); //foinikas
        AllCards.add(new Card(7,0,20, getApplicationContext())); //drakos
        AllCards.add(new Card(8,0,20, getApplicationContext())); //skilia

        AllCards.add(new Card(1,1,1, getApplicationContext())); //Ta mavra xartia
        AllCards.add(new Card(1,2,2, getApplicationContext()));
        AllCards.add(new Card(1,3,3, getApplicationContext()));
        AllCards.add(new Card(1,4,4, getApplicationContext()));
        AllCards.add(new Card(1,5,5, getApplicationContext()));
        AllCards.add(new Card(1,6,6, getApplicationContext()));
        AllCards.add(new Card(1,7,7, getApplicationContext()));
        AllCards.add(new Card(1,8,8, getApplicationContext()));
        AllCards.add(new Card(1,9,9, getApplicationContext()));
        AllCards.add(new Card(1,10,10,getApplicationContext()));
        AllCards.add(new Card(1,11,11,getApplicationContext()));
        AllCards.add(new Card(1,12,12,getApplicationContext()));
        AllCards.add(new Card(1,13,13,getApplicationContext()));

        AllCards.add(new Card(2,1,1, getApplicationContext())); //Ta mple xartia
        AllCards.add(new Card(2,2,2, getApplicationContext()));
        AllCards.add(new Card(2,3,3, getApplicationContext()));
        AllCards.add(new Card(2,4,4, getApplicationContext()));
        AllCards.add(new Card(2,5,5, getApplicationContext()));
        AllCards.add(new Card(2,6,6, getApplicationContext()));
        AllCards.add(new Card(2,7,7, getApplicationContext()));
        AllCards.add(new Card(2,8,8, getApplicationContext()));
        AllCards.add(new Card(2,9,9, getApplicationContext()));
        AllCards.add(new Card(2,10,10,getApplicationContext()));
        AllCards.add(new Card(2,11,11,getApplicationContext()));
        AllCards.add(new Card(2,12,12,getApplicationContext()));
        AllCards.add(new Card(2,13,13,getApplicationContext()));

        AllCards.add(new Card(3,1,1, getApplicationContext())); //Ta prasina xartia
        AllCards.add(new Card(3,2,2, getApplicationContext()));
        AllCards.add(new Card(3,3,3, getApplicationContext()));
        AllCards.add(new Card(3,4,4, getApplicationContext()));
        AllCards.add(new Card(3,5,5, getApplicationContext()));
        AllCards.add(new Card(3,6,6, getApplicationContext()));
        AllCards.add(new Card(3,7,7, getApplicationContext()));
        AllCards.add(new Card(3,8,8, getApplicationContext()));
        AllCards.add(new Card(3,9,9, getApplicationContext()));
        AllCards.add(new Card(3,10,10,getApplicationContext()));
        AllCards.add(new Card(3,11,11,getApplicationContext()));
        AllCards.add(new Card(3,12,12,getApplicationContext()));
        AllCards.add(new Card(3,13,13,getApplicationContext()));

        AllCards.add(new Card(4,1,1, getApplicationContext())); // ta kokkina
        AllCards.add(new Card(4,2,2, getApplicationContext()));
        AllCards.add(new Card(4,3,3, getApplicationContext()));
        AllCards.add(new Card(4,4,4, getApplicationContext()));
        AllCards.add(new Card(4,5,5, getApplicationContext()));
        AllCards.add(new Card(4,6,6, getApplicationContext()));
        AllCards.add(new Card(4,7,7, getApplicationContext()));
        AllCards.add(new Card(4,8,8, getApplicationContext()));
        AllCards.add(new Card(4,9,9, getApplicationContext()));
        AllCards.add(new Card(4,10,10,getApplicationContext()));
        AllCards.add(new Card(4,11,11,getApplicationContext()));
        AllCards.add(new Card(4,12,12,getApplicationContext()));
        AllCards.add(new Card(4,13,13,getApplicationContext()));

        Collections.shuffle(AllCards);

        addCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addCards(Player1Deck,AllCards,2);
                PlayerAdapter.notifyDataSetChanged();

                String cardName = Player1Deck.get(Player1Deck.size()-1).getCardName();
                Log.v("Cards" , cardName);
                PlayerAdapter.notifyDataSetChanged();
            }
        });

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(Player1Deck);
                PlayerAdapter.notifyDataSetChanged();
            }
        });

        PlayergridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = Player1Deck.get(i);
                Toast toast = Toast.makeText(getApplicationContext(), card.getCardName(), Toast.LENGTH_SHORT);
                toast.show();
                mediaPlayer.start();
                SelectedCards.add(Player1Deck.get(i));
                Player1Deck.remove(i);
                PlayerAdapter.notifyDataSetChanged();
                SelectedAdapter.notifyDataSetChanged();

            }
        });

        SelectedGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = SelectedCards.get(i);
                Toast toast = Toast.makeText(getApplicationContext(), card.getCardName(), Toast.LENGTH_SHORT);
                toast.show();
                mediaPlayer.start();
                Player1Deck.add(SelectedCards.get(i));
                SelectedCards.remove(i);
                PlayerAdapter.notifyDataSetChanged();
                SelectedAdapter.notifyDataSetChanged();

            }
        });

        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (SelectedCards.size() != 0) {
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ImageButton.setImageResource(SelectedCards.get(0).getImageId());
                            SelectedCards.remove(0);
                        }
                    },1000);
                }

            }
        });

    }

    public ArrayList addCards(ArrayList toList, ArrayList fromList, int numberOfCards) {
        for(int i = 1; i <= numberOfCards; i++) {
            if(fromList.size() != 0 ) {
                toList.add(fromList.get(0));
                fromList.remove(0);
            }
        }
        return toList;
    }

}


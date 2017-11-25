package com.example.geomatmatzi.tichu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.geomatmatzi.tichu.TrueGame.Card;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Card> deck = new ArrayList<Card>();
        final Random random = new Random();
        final GridView gridView = findViewById(R.id.grid_view);
        DeckAdapter adapter = new DeckAdapter(this, deck);
        gridView.setAdapter(adapter);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deck.add(new Card(random.nextInt(19)+1, random.nextInt(5)+0));
            }
        });




    }



}


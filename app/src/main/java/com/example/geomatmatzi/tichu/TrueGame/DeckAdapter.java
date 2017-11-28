package com.example.geomatmatzi.tichu.TrueGame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.geomatmatzi.tichu.R;

import java.util.ArrayList;

/**
 * Created by Geomat Matzi on 25/11/2017.
 */

public class DeckAdapter extends ArrayAdapter<Card> {

    public DeckAdapter(Context context, ArrayList<Card> deck) {
        super(context, 0, deck);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View DeckItemView = convertView;
        if (DeckItemView == null) {
            DeckItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.deck_item, parent, false);
        }

        Card currentCard = getItem(position);

        ImageView imageView = (ImageView) DeckItemView.findViewById(R.id.ImageView);
        imageView.setImageResource(currentCard.getImageId());

        return DeckItemView;

    }
}

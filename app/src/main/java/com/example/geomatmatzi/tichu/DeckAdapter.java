package com.example.geomatmatzi.tichu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.geomatmatzi.tichu.TrueGame.Card;

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
            if(DeckItemView == null) {
                DeckItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.deck_item, parent, false);
            }

            // Get the {@link AndroidFlavor} object located at this position in the list
            Card currentWord = getItem(position);

            ImageView imageView = (ImageView) DeckItemView.findViewById(R.id.ImageView);
            imageView.setImageResource(currentWord.getImageId());


            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return DeckItemView;
        }

    }

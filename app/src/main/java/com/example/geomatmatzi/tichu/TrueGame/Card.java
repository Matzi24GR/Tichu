package com.example.geomatmatzi.tichu.TrueGame;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import com.example.geomatmatzi.tichu.MainActivity;
import com.example.geomatmatzi.tichu.R;

/**
 * Created by Geomat Matzi on 24/11/2017.
 */

public class Card {
    // gia ton upologismo kai sykrisi
    private int mArithmosKartasInt;
    private int mXromaKartasInt;

    //gia na emfanizoume ta onomata isos xreiastei
    private String mArithmosKartas;
    private String mXromaKartas;

    //gia tis eikones
    int mImageId;
    private int ImageId;

    String cardName = "";


    public Card(int XromaKartas, int ArithmosKartas, Context context) {
        mArithmosKartasInt = ArithmosKartas;
        switch (XromaKartas) {
            case 1:
                cardName = "a";
                break;
            case 2:
                cardName = "b";
                break;
            case 3:
                cardName = "c";
                break;
            default:
                cardName = "d";
                break;
        }

        cardName = cardName + ArithmosKartas;
        Context c = context;
        Resources resources = c.getResources();
        mImageId = resources.getIdentifier(cardName, "drawable", c.getPackageName());
    }

    public int getArithmosKartasInt() {
        return mArithmosKartasInt;
    }

    int getXromaKartasInt() {
        return mXromaKartasInt;
    }

    public int getImageId(){
        return mImageId;
    }

    public String getCardName() {
        return cardName;
    }
}

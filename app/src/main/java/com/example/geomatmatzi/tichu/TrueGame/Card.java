package com.example.geomatmatzi.tichu.TrueGame;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import com.example.geomatmatzi.tichu.MainActivity;
import com.example.geomatmatzi.tichu.R;

/**
 * Created by Geomat Matzi on 24/11/2017.
 */

public class Card implements Comparable<Card>{
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
            case 0:
                switch (mArithmosKartasInt) {
                    case 14:
                        cardName = "mahjong";
                        break;
                    case 15:
                        cardName = "phoenix";
                        break;
                    case 16:
                        cardName = "drache";
                        break;
                    case 17:
                        cardName = "hund";
                        break;
                }
                break;
            case 1:
                cardName = "a";
                cardName = cardName + mArithmosKartasInt;
                break;
            case 2:
                cardName = "b";
                cardName = cardName + mArithmosKartasInt;
                break;
            case 3:
                cardName = "c";
                cardName = cardName + mArithmosKartasInt;
                break;
            case 4:
                cardName = "d";
                cardName = cardName + mArithmosKartasInt;
                break;
        }

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

    @Override
    public int compareTo(@NonNull Card card) {
        int card1int = getArithmosKartasInt();
        int card2int = card.getArithmosKartasInt();
        if (card1int > card2int) {
            return -1;
        } else if (card1int < card2int) {
            return 1;
        }else {
            return 0;
        }
    }
}
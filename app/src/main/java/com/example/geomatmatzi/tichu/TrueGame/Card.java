package com.example.geomatmatzi.tichu.TrueGame;

import android.support.v4.content.res.ResourcesCompat;

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
    private int mImageId;

    public Card(int ArithmosKartas, int XromaKartas) {
        mArithmosKartasInt = ArithmosKartas;
        mXromaKartasInt = XromaKartas;
        mImageId = ResourcesCompat.getmimmap
    }

    public int getArithmosKartasInt() {
        return mArithmosKartasInt;
    }

    public int getXromaKartasInt() {
        return mXromaKartasInt;
    }
}

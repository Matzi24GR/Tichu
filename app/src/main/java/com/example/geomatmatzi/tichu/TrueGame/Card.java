package com.example.geomatmatzi.tichu.TrueGame;

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
    String mImageId;
    private int ImageId;

    public Card(int ArithmosKartas, int XromaKartas) {
        mArithmosKartasInt = ArithmosKartas;
        mImageId = "R.drawable"+"d2";
        int ImageId = Integer.valueOf(mImageId);
    }

    public int getArithmosKartasInt() {
        return mArithmosKartasInt;
    }

    int getXromaKartasInt() {
        return mXromaKartasInt;
    }

    public int getImageId(){
        return ImageId;
    }
}

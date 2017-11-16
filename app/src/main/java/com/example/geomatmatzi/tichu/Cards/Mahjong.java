package com.example.geomatmatzi.tichu..com.example.geomatmatzi.tichu..Cards;

public class Mahjong extends com.example.geomatmatzi.tichu..Cards.SpecialCard {
    int WishNumber;
    /**
     * constructor
     */
    public Mahjong()
    {
        super();
        this.setCredits(0);
        this.setValue(1);
    }

    /**
     * accessors
     * Epistrefei to wish tou paikth
     * @return int
     */
    public int getWishNumber() {
        return WishNumber;
    }

    /**
     * transformers
     * 8etei to sto wishnumber to wish
     * @param WishNumber 
     */
    public void setWishNumber(int WishNumber) {
        this.WishNumber = WishNumber;
    }
    
    
    @Override
    public String toString(){
        return "mahjong.png";
    }
    @Override
    public boolean equals (Object obj){
        if(obj instanceof Mahjong){
            return true;
        }
        return false;
        
    }
}

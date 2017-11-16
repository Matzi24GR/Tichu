package com.example.geomatmatzi.tichu.Cards;


public class Phoenix extends com.example.geomatmatzi.tichu.Cards.SpecialCard {

    
    /**
     * constructor
     * h monh karta sto paixnidi tupou Phoinika
     * Mporei na exei 2 xrhseis h se monofullia h san mpalanter se zeugari
     */
    public Phoenix(){
        super();
        this.setCredits(-25);
        this.setValue(-1);
    }
    
    
    @Override
    public String toString(){
        return "phoenix.png";
    }
    
}

package com.example.geomatmatzi.tichu.Game;

import java.util.ArrayList;
import com.example.geomatmatzi.tichu.Cards.Card;
import java.util.List;
import com.example.geomatmatzi.tichu.Cards.Mahjong;


public class Player {
  
    private String Name; //onoma player
    private int points;
    private boolean isActive;//an einai energos o paikths ston guro
    private ArrayList<Card> PlayersHand;//Lista apo cards pou exei sta xeria tou 
    private ArrayList<Card> PlayersTable;//Lista apo cards pou exei sthn mpaza tou
    private boolean saidTichu;//An exei pei tichu ston trexon guro
    private boolean saidGrandTichu;//An exei pei grandTichu ston trexon guro
    private boolean saidPaso;//An exei pei paso
    private Team PlayerofTeam; //omada toy paixth
    
    /**
     * constructor
     * pre:Na dw8ei onoma paikth
     * post:Dhmiourgia paikth me to onoma pou dw8hke
     * @param name 
     */
    public Player(String name){
        this.Name=name;
        this.PlayersHand = new ArrayList<Card>();
        this.PlayersTable =new ArrayList<Card>();
        this.saidGrandTichu=false;
        this.saidPaso=false;
        this.points=0;
        this.saidTichu=false;
    }

    
    
    /**
     * transformers
     * * Afairei apo to PlayersHand tis kartes pou epaikse o paikths
     * pre:h playersHand na mhn einai kenh wste na afaire8oun ta fulla
     * post:na afaire8oun ta fulla pou epaikse o paikths apo thn lista     
     * @return void
     */
    public void removeCardsFromHands(ArrayList<Card> todel){
        for(Card tmp: todel){
            this.PlayersHand.remove(tmp);
        }
    
    }
    
    /**
     * transformers
     * Eisagei sthn PlayersTable thn mpaza apo cards pou mazepse o paikths
     * pre:na dw8ei h lista me ta fulla pou prepei na eisax8oun
     * post:na mpoun ta fulla sth lista
     * @return void
     */
    public void CollectCardsFromTable(ArrayList<Card> toget){
        for(Card tmp: toget){
            this.PlayersTable.add(tmp);
        }
    
    }
    
    /**
     * transformers
     * Eisagei sthn Lista PlayersHand tis 8 prwtes card tou paikth
     * pre:na dw8oun 8 kartes ston paikth
     * post:oi kartes aytes na mpoun sth lista pou krataei o paikths
     * @param c Card[]
     * @return void
     */
    public void giveFirstEightCards(ArrayList<Card> toget){
        for(Card tmp : toget){
            this.PlayersHand.add(tmp);
        }
    }
    
    /**
     * transformers
     * Eisagei sthn Lista PlayersHand tis 6 epomenes card tou paikth
     * pre:na dw8oun 6 kartes ston paikth
     * post:oi kartes aytes na mpoun sth lista pou krataei o paikths
     * @param c Card[] 
     * @return void
     */
    public void giveSixMoreCards(ArrayList<Card> toget){
        for(Card tmp : toget){
            this.PlayersHand.add(tmp);
        }
    }
    
    /**
     * accessors
     * Elegxei an o player exei sthn list PlayersHand to wish tou paikth me to Majong,
     * an to exei epistrefei true alliws false
     * @return bollean
     */
    public boolean playerHasTheWishCardWithValue(int value){
        for(Card tmp : this.PlayersHand){
            if(tmp.getValue() == value){
                return true;
            }
        }
        return false;
        
    }
    
   /**
     * accessors
     * Epistrefei to onoma tou paikth
     * @return String
     */   
    public String getName() {
        return Name;
    }

    /**
     * transformers
     * 8etei to onoma ston paikth
     * @param Name 
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    /**
     * accessors
     * epistrefei toys pontous tou player
     * @return integer
     */
    public int getPoints() {
        return points;
    }

    /**
     * transformers
     * 8etei toys pontous tou paikth, 0 an einei o xamenos ths partidas
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * accessors
     * Epistrefei true an o paikths einai energos,alliws false;
     * @return boolean
     */
    public boolean isIsActive() {
        if(this.PlayersHand.size() > 0){
            this.isActive=true;
        }
        else{
            this.isActive=false;
        }
        return isActive;
    }
    
    /**
     * 8etei an einai true h false an einai energos h oxi o paikths
     * @param isActive 
     * @return void
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    /**
     * accessors
     * Epistrefei ta xartia pou exei o paikths sta xeria tou
     * @return List<Card>
     */
    public ArrayList<Card> getPlayersHand() {
        return PlayersHand;
    }

    /**
     * transformers
     * Eisagei mia Lista apo kartes sto playersHand
     * @param PlayersHand 
     */
    public void setPlayersHand(ArrayList<Card> PlayersHand) {
        this.PlayersHand = PlayersHand;
    }

    /**
     * accessors
     * Epistrefei ta xartia pou exei o paikths sto trapezi tou
     * @return List<Card>
     */
    public ArrayList<Card> getPlayersTable() {
        return PlayersTable;
    }

    /**
     * transformers
     * Eisagei mia Lista apo kartes sto playersTable
     * @param PlayersHand 
     */
    public void setPlayersTable(ArrayList<Card> PlayersTable) {
        this.PlayersTable = PlayersTable;
    }
    
    public void add2Mpaza(ArrayList<Card> c){
        for(Card tmp : c){
            this.PlayersTable.add(tmp);
        }
    }

    /**
     * accessors
     * Epistrefei true an o paikths exei pei GrandTichu,alliws false
     * @return boolean
     */
    public boolean SaidGrandTichu() {
        return saidGrandTichu;
    }

    /**
     * transformers
     * 8etei sthn metavlhth saidGrandTichu=true an exei pei GrandTichu,
     * alliws false
     * @param saidGrandTichu
     * @return void
     */
    public void setSaidGrandTichu(boolean saidGrandTichu) {
        this.saidGrandTichu = saidGrandTichu;
    }

    /**
     * accessors
     * Epistrefei true an o paikths exei pei paso, false alliws
     * @return boolean
     */
    public boolean SaidPaso() {
        
        return saidPaso;
    }

    /**
     * transformers
     * 8etei sthn metavlhth saidPase=true an exei pei Paso,
     * alliws false
     * @param saidPaso
     * @return void
     */
    public void setSaidPaso(boolean saidPaso) {
        this.saidPaso = saidPaso;
    }

    /**
     * accessors
     * Epistrefei true an exei pei Tichu, alliws false
     * @return boolean
     */
    public boolean SaidTichu() {
        return saidTichu;
    }

    /**
     * transformers
     * 8etei sthn metavlhth saidTichu=true an exei pei Tichu,
     * alliws false
     * @param saidTichu
     * @return void
     */
    public void setSaidTichu(boolean saidTichu) {
        this.saidTichu = saidTichu;
    }
    
    public void CalculateMpazaPoints(){
        this.points=0;
        for(Card tmp : this.PlayersTable){
            this.points+= tmp.getCredits();
        }
    }
    
    public boolean hasMahjong(){
        for(Card tmp : this.getPlayersHand()){
            if(tmp instanceof Mahjong)
                return true;
        }
        return false;
    }
    public boolean HasCardWithValue(int val){
        for(Card tmp : this.getPlayersHand()){
            if(tmp.getValue() == val)
                return true;
            
        }
        return false;
    }
    public void setTeam(Team t){
        this.PlayerofTeam = t;
    }
    public Team getTeam(){
        return this.PlayerofTeam;
    }
    
    public void RemoveLooserCards(){
        this.PlayersHand =new ArrayList<Card>();
        this.PlayersTable = new ArrayList<Card>();
    }
    
    public void RemoveMahjong(){
        for(Card tmp : this.PlayersHand){
            if(tmp instanceof Mahjong){
                this.PlayersHand.remove(tmp);
            }
        }
        
    }
     
}
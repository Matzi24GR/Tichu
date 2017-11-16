    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geomatmatzi.tichu.Game;

import com.example.geomatmatzi.tichu.Cards.Card;

import java.util.ArrayList;

/**
 *
 * @author Win7User
 */
public class Team {
    private Player p1; 
    private Player p2;
    private int score;
    private boolean saidtichu;
    private boolean saidgrant;
    
    
    
    public Team(Player p, Player pp){
        this.p1 =p;
        this.p2 =pp;
        this.score=0;
    }
    
    public boolean isPlayerOfTeam(Player p){
        if(p == getP1() || p ==getP2()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void addPointsToScore(int p){
        this.score+= p;
    }
    
    
    public int CalculateTeamScore(boolean TeamCameFirst){
       // this.score=0;
        if(TeamCameFirst){
            if(getP1().SaidGrandTichu() || getP2().SaidGrandTichu()){
                this.addPointsToScore(200);
                getP1().CalculateMpazaPoints();
                getP2().CalculateMpazaPoints();
                this.addPointsToScore( getP1().getPoints());
                this.addPointsToScore( getP2().getPoints());
            }
            else if(getP1().SaidTichu() || getP2().SaidTichu()){
                this.addPointsToScore( 100);
                getP1().CalculateMpazaPoints();
                getP2().CalculateMpazaPoints();
                this.addPointsToScore( getP1().getPoints());
                this.addPointsToScore(getP2().getPoints());
            }
            else{
                getP1().CalculateMpazaPoints();
                getP2().CalculateMpazaPoints();
                this.addPointsToScore(getP1().getPoints());
                this.addPointsToScore( getP2().getPoints());
                
            }
        }
        else{
            if(getP1().SaidGrandTichu() || getP2().SaidGrandTichu()){
                this.addPointsToScore( -200);
                getP1().CalculateMpazaPoints();
                getP2().CalculateMpazaPoints();
                this.addPointsToScore(getP1().getPoints());
                this.addPointsToScore( getP2().getPoints());
            }
            else if(getP1().SaidTichu() || getP2().SaidTichu()){
                this.addPointsToScore(- 100);
                getP1().CalculateMpazaPoints();
                getP2().CalculateMpazaPoints();
                this.addPointsToScore( getP1().getPoints());
                this.addPointsToScore( getP2().getPoints());
            }
            else{
                getP1().CalculateMpazaPoints();
                getP2().CalculateMpazaPoints();
                this.addPointsToScore(getP1().getPoints());
                this.addPointsToScore(getP2().getPoints());
                
            }
            
        }
        return this.getScore();
        
        
    }

    /**
     * @return the p1
     */
    public Player getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Player p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Player getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Player p2) {
        this.p2 = p2;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the saidtichu
     */
    public boolean isSaidtichu() {
        if(p1.SaidTichu() || p2.SaidTichu()){
            return true;
        }
        return false;
    }

    /**
     * @param saidtichu the saidtichu to set
     */
    public void setSaidtichu(boolean saidtichu) {
        this.saidtichu = saidtichu;
    }

    /**
     * @return the saidgrant
     */
    public boolean isSaidgrant() {
        if(p1.SaidGrandTichu() || p2.SaidGrandTichu()){
            
            return true;
        }
        else
            return false;
    }

    /**
     * @param saidgrant the saidgrant to set
     */
    public void setSaidgrant(boolean saidgrant) {
        this.saidgrant = saidgrant;
    }
    public void CleanTeamForNextround(){
        p1.setPlayersHand(new ArrayList<Card>());
        p1.setPlayersTable(new ArrayList<Card>());
        p1.setPoints(0);
        p1.setSaidGrandTichu(false);
        p1.setSaidPaso(false);
        p1.setSaidTichu(false);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        p2.setPlayersHand(new ArrayList<Card>());
        p2.setPlayersTable(new ArrayList<Card>());
        p2.setPoints(0);
        p2.setSaidGrandTichu(false);
        p2.setSaidPaso(false);
        p2.setSaidTichu(false);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        this.saidgrant= false;
        this.saidtichu =false;
        
    }
    
    
    
    
    
}

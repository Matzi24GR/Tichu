package com.example.geomatmatzi.tichu..tichu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import com.example.geomatmatzi.tichu..com.example.geomatmatzi.tichu..Cards.*;
import com.example.geomatmatzi.tichu..com.example.geomatmatzi.tichu..Combinations.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class TICHU {


        private ArrayList<com.example.geomatmatzi.tichu..Cards.Card> table; //lista apo kartes pou uparxoun sto trapezi
        private int Round;//o ari8mos ths partidas pou paizetai
        private com.example.geomatmatzi.tichu..Combinations.CardCombination currentRound;//o tupos tou gurou ston opoio paizoun oi paiktes
        private Player currPlayer;
        private ArrayList<Player> players;//oi lista apo tous paiktes tou paixnidiou
        private ArrayList<Player> playerWhosaidTichu;//pinakas apo tous paiktes pou exoun pei Tichu sthn sugkekrimenh partida
        private ArrayList<Player> playerWhosaiGrandTichu;//pinakas apo tous paiktes pou exoun pei GrandTichu sthn sugkekrimenh partida
        private Player firstWinner;//o nikhths ths partidas,ton 8eloume gia na doume an exei pei kapoia dhlwsh
        private Player secondWinner;//o deuteros pou 8a vgei apo thn partida,ton 8eloume gia an exei ginei 1-2,tichu1-2,grand1-2
        private Player thirdWinner;
        private Player lastPlayerOfRound;//o teleutaios paikths pou vghke sthn partida,ton 8eloume giati prepei na parei tis kartes tou o nikhths
        private Team Team1;//Xwrizoume tous 4 paiktes se omades twn 2
        private Team Team2;//Mesa ston constructor ginetai h arxikopoihsh tous
        private int wishNumber;//to noumero pou 8a kanei wish o paikths me to Majhong
        private boolean whishDone;
        private GameState state;
        private int PasoCount;
        private IGameClient client;

        /**
         * Constructor
         * edw arxikopoiountai oi paiktes pou 8a paiksoun, ka8ws kai oi cards tis trapoulas
         * pou 8a dw8oun stous paiktes
         */
        public TICHU(String one, String two, String three, String four){
            Player p1 = new Player(one);
            Player p2 = new Player(two);
            this.Team1 = new Team(p1, p2);
            p1.setTeam(Team1);
            p2.setTeam(Team1);
            this.players = new ArrayList<>();
            Player p3 = new Player(three);
            Player p4 = new Player(four);
            this.Team2 = new Team(p3, p4);
            p3.setTeam(Team2);
            p4.setTeam(Team2);
            this.players = new ArrayList<Player>();
            this.playerWhosaidTichu = new ArrayList<Player>();
            this.playerWhosaiGrandTichu = new ArrayList<Player>();
            this.players.add(p1);
            this.players.add(p3);
            this.players.add(p2);
            this.players.add(p4);
            this.Team2 = new Team(p3,p4);
            this.whishDone = false;
            this.Round = 1;
            this.state = GameState.UNDEFINED;
            this.table =new  ArrayList<com.example.geomatmatzi.tichu..Cards.Card>();
            this.PasoCount = 0;
            //Cards shuffle etc..

            for(int i = 0 ; i < 4; i++){
                for(int j =2; j<15; j++){

                    com.example.geomatmatzi.tichu..Cards.SimpleCard tmp = new com.example.geomatmatzi.tichu..Cards.SimpleCard(i,j);
                    this.table.add(tmp);
                }
            }
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Drache());
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Mahjong());
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Hund());
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Phoenix());
            this.currPlayer = null;
        }


        public boolean PlayerCanSayPass(Player p){
            if(this.state == GameState.WAIT4WISH){
                return false;
            }
            else if(this.currentRound == null){
                return false;
            }
            else if(this.whishDone == false && p.HasCardWithValue(this.wishNumber)){
                return false;
            }
            else{
                return true;
            }


        }

        public void SayPass(){

            this.PasoCount++;
            //metrame ta paso gia na metaferoume thn mpaza

            if(this.PasoCount ==(this.GetActivePlayers() -1)){
                this.PasoCount=0;
                this.getNextPlayer().CollectCardsFromTable(this.table);
                this.table.clear();
                this.currentRound = null;


            }
            this.currPlayer = this.getNextPlayer();
            this.client.changePlayer(this.currentRound);
        }
        public boolean sayTichu(Player p){
            if(p.getPlayersHand().size() == 14){
                p.setSaidTichu(true);
                this.playerWhosaidcom.example.geomatmatzi.tichu..add(p);
                return true;
            }
            else{
                return false;
            }
        }



        public Player getNextPlayer(){
            if(this.getState() == GameState.WAIT4WISH){
                if(this.Team1.getP1().hasMahjong()){
                    // this.currPlayer = this.Team1.getP1();
                    //  System.out.println("Returned Majong:"+" Player "+ this.Team1.getP1().getName());
                    return this.Team1.getP1();
                }
                else if(this.Team1.getP2().hasMahjong()){
                    // this.currPlayer = this.Team1.getP2();
                    //  System.out.println("Returned Majong:"+" Player "+ this.Team1.getP2().getName());
                    return this.Team1.getP2();
                }
                else if(this.Team2.getP1().hasMahjong()){
                    //  System.out.println("Returned Majong:"+" Player "+ this.Team2.getP1().getName());
                    // this.currPlayer = this.Team2.getP1();
                    return this.Team2.getP1();
                }
                else{
                    //  this.currPlayer = this.Team2.getP2();
                    // System.out.println("Returned Majong:"+" Player "+ this.Team2.getP2().getName());
                    return this.Team2.getP2();
                }

            }
            //kuklikh lista
            else{


                //alliws paizei o epomenos
                int index = this.players.indexOf(this.currPlayer);
                //     System.out.println("INdex is:"+ index);
                int count =index;
                while(true){
                    if(count==(this.players.size()-1)){
                        count =0;
                    }
                    else{
                        count++;
                    }

                    if(this.players.get(count).isIsActive()){
                        //        System.out.println("Returned is:"+ count+ " Player "+ this.players.get(count).getName());
                        // this.currPlayer= this.players.get(count);
                        return this.players.get(count);
                    }
                    else{
                        //  count++;
                        continue;
                    }

                }
            }
        }

        public com.example.geomatmatzi.tichu..Cards.Card drawFromDeck(){
            Random generator = new Random();
            int index= generator.nextInt( this.table.size() );
            return this.table.remove(index);
        }

        /**
         * Se auth th sunarthsh 8a paizetai to paixnidi, edw 8a kalountai oles oi
         * arxikopoihseis  me thn swsth seira, etsi wste na uparxei domh
         * Edw prepei na ginontai oi elegxoi an exoume 1-2,GrandTichu1-2,tichu1-2 gia
         * na teleiwsei oi partida,ka8ws edw paizetai to paixnidi kai na upologistoun oi pontoi
         * Edw mporoun na paiktous polles partides, ara polloi tupoi round.
         * @return boolean
         */
        public boolean play(){return false;};

        /**
         * Arxikopoiei to paixnidi dinontas tis prwtes 8 kartes stous paiktes,apo auth
         * th sunarthsh 8a kalestei h antistoixh sunarthsh giveFirstEightCards(Card[] c)
         * thn klasshs Player pou 8a valei sth lista tou player tis kartes toy
         * @return void
         */
        public void initialiazePlayersWithEightCards(){
            for(int i= 0 ; i < 8; i ++){
                this.Team1.getP1().getPlayersHand().add(this.drawFromDeck());
                this.Team1.getP2().getPlayersHand().add(this.drawFromDeck());
                this.Team2.getP1().getPlayersHand().add(this.drawFromDeck());
                this.Team2.getP2().getPlayersHand().add(this.drawFromDeck());
            }
            this.setState(GameState.WAIT4GRANT);


        }


        /**
         * Dinei tis epomenes 6 kartes stous paiktes apo auth
         * th sunarthsh 8a kalestei h antistoixh sunarthsh giveSixMoreCards(Card[] c)
         * thn klasshs Player pou 8a valei sth lista tou player tis kartes toy
         * @return void
         */
        public void initialiazePlayersWithSixMoreCards(){
            for(int i= 0 ; i < 6; i ++){
                this.Team1.getP1().getPlayersHand().add(this.drawFromDeck());
                this.Team1.getP2().getPlayersHand().add(this.drawFromDeck());
                this.Team2.getP1().getPlayersHand().add(this.drawFromDeck());
                this.Team2.getP2().getPlayersHand().add(this.drawFromDeck());
            }
            this.setState(GameState.WAIT4WISH);
        }
        /**
         * accessors
         * Elegxei an exei teleiwsei h partida, elegxontas thn lista me tous energous players
         * an oloi exoun pei paso,tote exei teleiwsei h partida,epistrefei true alliws false
         * @param p List of Players
         * @return boolean
         */
        public boolean hasFinishedPartRound(List<Player> p){return false;};

        /**
         * transformers
         * Eisagei ta fulla tou paikth pou epekse sthn metavlhth table,pou einai to trapezi me ta trexonta fulla
         * @param p List of Players
         * @return void
         */
        public void insertToTableAfterMove(Player p){};


        /**
         * transformers
         * Sunarthsh pou ektelei o paikths gia na kanei to action tou, dld dialegei poies
         * apo tis kartes poy exei sta xeria tou 8elei na riksei sto trapezi kai an
         * exei to Majhong kanei mia euxh.O elegxos gia to an oi kartes einai swstes ktl
         * ginetai mesa sthn klash Card.an h kinhsh einai swsth prepei na afaire8oun oi
         * kartes apo ta xeria tou paikth kai na mpoun sto trapezi
         * @param p Player
         * @param c Card[]
         * @param wishnumber int
         */
        public boolean PlayersAction(Player p, com.example.geomatmatzi.tichu..Combinations.CardCombination c, int wishnumber) throws Exception{
            /*System.out.println("Tichu1 "+ Team1.isSaidtichu());
            System.out.println("Tichu2 "+ Team2.isSaidtichu());
            this.Team1.CalculateTeamScore(false);
            System.out.println("Score1: "+ this.Team1.getScore());
            this.Team2.CalculateTeamScore(false);
            System.out.println("Score2: "+ this.Team2.getScore());

            System.out.println("Grant1 "+ Team1.isSaidgrant());
            System.out.println("Grant2 "+ Team2.isSaidgrant());*/


            com.example.geomatmatzi.tichu..Combinations.CardCombination.sortDeck(c.getCards());
            int comb = this.getCardsCategory(c);
            com.example.geomatmatzi.tichu..Combinations.CardCombination deck;
            switch(comb){
                case 1 :
                    deck = new com.example.geomatmatzi.tichu..Combinations.OneCard(c.getCards());
                    break;
                case 2:
                    deck = new com.example.geomatmatzi.tichu..Combinations.OnePair(c.getCards());
                    break;
                case 3:
                    deck = new com.example.geomatmatzi.tichu..Combinations.TreeCards(c.getCards());
                    break;
                case 4:
                    deck = new com.example.geomatmatzi.tichu..Combinations.Steps(c.getCards());
                    break;
                case 5:
                    deck = new com.example.geomatmatzi.tichu..Combinations.Kenda(c.getCards());
                    break;
                case 6:
                    deck = new com.example.geomatmatzi.tichu..Combinations.Full(c.getCards());
                    break;
                default:
                    return false;
            }




            System.out.println("Comb" + comb+" Card vald"+ deck.getCards().get(0).getValue());
            //Player has a wish, Only for the first time, the player with the mahjong
            if(wishnumber != 0){
                this.wishNumber= wishnumber;
                this.whishDone = false;
                //this.currPlayer=p;
                this.currentRound = deck;
                for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                    this.table.add(tmp);
                }
                this.state = GameState.PLAYING;
                this.PasoCount=0;
                this.currPlayer.removeCardsFromHands(deck.getCards());

                //this.FindWinners(p);

                this.currPlayer = this.getNextPlayer();

                ArrayList <com.example.geomatmatzi.tichu..Cards.Card> cs = new ArrayList<>();
                cs.add(new com.example.geomatmatzi.tichu..Cards.Mahjong());

                this.client.changePlayer(new com.example.geomatmatzi.tichu..Combinations.CardSet(cs));
                return true;

            }
            //the player just submits the cards, with no wish, for the rest of the times
            else{
                //an den exei perasei to wish
                if((this.whishDone ==  false) && !c.hasCardWithValue(this.wishNumber)){
                    if(p.HasCardWithValue(this.wishNumber)){
                        return false;
                    }
                    else{
                        this.PasoCount=0;
                        for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                            this.table.add(tmp);
                        }
                        this.currPlayer=p;
                        this.currentRound = deck;
                        this.currPlayer = this.getNextPlayer();
                        this.client.changePlayer(deck);
                        return true;
                    }
                }
                else if((this.whishDone ==false) && c.hasCardWithValue(this.wishNumber) ){
                    this.whishDone = true;
                    this.currPlayer=p;
                    this.currentRound = deck;
                    for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                        this.table.add(tmp);
                    }
                    p.removeCardsFromHands(c.getCards());
                    if(this.FindWinners(p) ){
                        return true;
                    }
                    this.state = GameState.PLAYING;
                    this.PasoCount=0;

                    this.currPlayer = this.getNextPlayer();
                    this.client.changePlayer(deck);
                    return true;
                }
                //new round
                else if(this.currentRound == null){
                    if((this.currentRound ==null) && (deck.getCards().get(0) instanceof com.example.geomatmatzi.tichu..Cards.Hund)){
                        //     this.currPlayer = this.getNextPlayer();
                        Player other;
                        if(p.getTeam().getP1() == p){
                            other = p.getTeam().getP2();
                        }
                        else{
                            other = p.getTeam().getP1();
                        }
                        this.PasoCount=0;
                        this.currPlayer=other;
                        if(! other.isIsActive() ){


                            if(this.getNextPlayer().isIsActive()){
                                this.currPlayer=this.getNextPlayer();
                            }
                            else {
                                this.currPlayer=p;
                            }
                        }
                        for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                            this.table.add(tmp);
                        }
                        p.removeCardsFromHands(c.getCards());
                        this.PasoCount=0;
                        this.currentRound=null;
                        this.table.clear();
                        this.client.changePlayer(null);
                        return true;
                    }
                    this.currPlayer=p;
                    this.currentRound = deck;
                    for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                        this.table.add(tmp);
                    }
                    this.state = GameState.PLAYING;
                    this.PasoCount=0;
                    p.removeCardsFromHands(c.getCards());
                    if(this.FindWinners(p) ){
                        return true;
                    }

                    this.currPlayer = this.getNextPlayer();
                    this.client.changePlayer(deck);
                    return true;


                }
                //normal round
                else{


                    if(deck.ispowerOfSetGreaterThan(this.currentRound)){

                        //Dragon in Monofyla
                        if((comb ==1) && (deck.getCards().get(0) instanceof com.example.geomatmatzi.tichu..Cards.Drache)){
                            Player togive = this.client.showTheMpazaWindow();
                            this.PasoCount=0;
                            for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                                this.table.add(tmp);
                            }
                            togive.CollectCardsFromTable(this.table);
                            this.table.clear();
                            this.currentRound = null;
                            p.removeCardsFromHands(c.getCards());
                            if(this.FindWinners(p) ){
                                return true;
                            }
                            this.client.changePlayer(null);

                            return true;
                        }
                        this.currPlayer=p;
                        this.currentRound = deck;
                        for(com.example.geomatmatzi.tichu..Cards.Card tmp : deck.getCards()){
                            this.table.add(tmp);
                        }
                        this.state = GameState.PLAYING;
                        this.PasoCount=0;
                        p.removeCardsFromHands(c.getCards());
                        if(this.FindWinners(p) ){
                            return true;
                        }

                        this.currPlayer = this.getNextPlayer();
                        this.client.changePlayer(deck);
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }

        }

        public boolean FindWinners(Player p){

            if(p.getPlayersHand().size() == 0){
                if(this.firstWinner==null){
                    this.currPlayer=p;
                    this.firstWinner =p;
                }
                else if(this.secondWinner == null){
                    this.currPlayer=p;
                    this.secondWinner = p;
                    //if same team, end of game

                    //1-2
                    if(this.firstWinner.getTeam() == this.secondWinner.getTeam()){
                        EndOfRound();
                        return true;
                    }



                }
                else if(this.thirdWinner == null){
                    //end of game
                    this.thirdWinner=p;
                    this.currPlayer=p;
                    this.lastPlayerOfRound = this.getNextPlayer();
                    EndOfRound();
                    return true;
                }
            }
            return false;

        }

        public void EndOfRound(){


            if(this.firstWinner.getTeam() == this.secondWinner.getTeam()){

                if(this.firstWinner.getTeam().isSaidgrant()){
                    this.firstWinner.getTeam().addPointsToScore(400);
                }
                else if(this.firstWinner.getTeam().isSaidtichu()){
                    this.firstWinner.getTeam().addPointsToScore(300);
                }
                else{
                    this.firstWinner.getTeam().addPointsToScore(200);
                }
                //remove points from othjer team if Statement!

                if(this.firstWinner.getTeam()== this.Team1){
                    if(Team2.isSaidgrant()){
                        Team2.addPointsToScore(-200);
                    }
                    else if(Team2.isSaidtichu()){
                        Team2.addPointsToScore(-100);
                    }
                }
                else{
                    if(Team1.isSaidgrant()){
                        Team1.addPointsToScore(-200);
                    }
                    else if(Team1.isSaidtichu()){
                        Team1.addPointsToScore(-100);
                    }

                }
                System.out.println("Score1: "+this.Team1.getScore());
                System.out.println("Score2: "+this.Team2.getScore());
                //       NewRound();
                if(this.Team1.getScore() >=1000){
                    this.client.showWinnerPanel("Team 1");
                }
                else if(this.Team2.getScore() >=1000){
                    this.client.showWinnerPanel("Team 2");
                }
                else{
                    this.increaseRound();
                    this.client.newRound();
                }




            }
            else{
                //metafora mpazas

                this.firstWinner.add2Mpaza(this.lastPlayerOfRound.getPlayersHand());
                this.firstWinner.add2Mpaza(this.lastPlayerOfRound.getPlayersTable());
                this.lastPlayerOfRound.RemoveLooserCards();



                //do it the hard way!
                this.firstWinner.getTeam().CalculateTeamScore(true);
                if(this.firstWinner.getTeam() == this.Team1){
                    this.Team2.addPointsToScore((100 -this.firstWinner.getTeam().getScore()));
                }
                else{
                    this.Team1.addPointsToScore((100 -this.firstWinner.getTeam().getScore()));
                }

                //this.secondWinner.getTeam().addPointsToScore((100 -this.firstWinner.getTeam().getScore()));
                //this.secondWinner.getTeam().CalculateTeamScore(false);
                //     NewRound();
                System.out.println("2Score1: "+this.Team1.getScore());
                System.out.println("2Score2: "+this.Team2.getScore());
                if(this.Team1.getScore() >=1000){
                    this.client.showWinnerPanel("Team 1");
                }
                else if(this.Team2.getScore() >=1000){
                    this.client.showWinnerPanel("Team 2");
                }
                else{
                    this.increaseRound();
                    this.client.newRound();
                }
            }




        }


        /**
         * accessors
         * Adeiasma tou table meta apo ka8e enarksh neas partidas
         * @return void
         */
        public void resetTable(){};


        /**
         * accessors
         * Elegxei an to trapezi einai adeio, dld an h lista einai kenh, h an exei kartes
         * autos o elegxos xreiazetai stis periptwseis pou 1.kapoios paikths paei na riksei skylakia
         * prepei to trapezi na einai keno 2. otan kapoios paei na riksei vomva to trapezi dn
         * prepei na einai keno
         * @return boolean
         */
        public boolean isTableEmpty(){return false;}

        /**
         * accessors
         * Elegxei an o tupos tou CardCombination pou 8a rikse o trexon paikths einai swsto,
         * dld an einai monofullia ktl kai epishs elegxei an h aksia outou pou erikse
         * einai megaluterh twn fullwn pou vriskontai hdh sto trapezi,an uparxoun.
         * @return boolean
         */
        public boolean isMoveOfPlayerCorrect(){return false;};

        /**
         * accessors
         * Upologizei thn aksia tou SpecialCard Phoenix h opoia einai 0.5+ thn aksia
         * prohgoumenou fullou sthn monofulia.Briskei to prohgoumeno fullo apo thn
         * lista table pou periexei ta fulla pou exoun pesei.
         * @return float
         */
        public float NumberOfPhoenix(){return 0;};

        /**
         * transformers
         * Meta to telos ka8e partidas auksanei ton metrhth numberOfPartRound pou periexei
         * ton ari8mo ton partidwn pou exoun paiktei.
         * @return void
         */
        public void increaseRound(){
            this.Round++;
            this.firstWinner =null;
            this.secondWinner=null;
            this.thirdWinner=null;
            this.lastPlayerOfRound =null;
            this.Team1.CleanTeamForNextround();
            this.Team2.CleanTeamForNextround();
            this.playerWhosaiGrandcom.example.geomatmatzi.tichu..clear();
            this.playerWhosaidcom.example.geomatmatzi.tichu..clear();

            this.whishDone = false;

            this.state = GameState.UNDEFINED;
            this.table =new  ArrayList<com.example.geomatmatzi.tichu..Cards.Card>();
            this.PasoCount = 0;
            //Cards shuffle etc..

            for(int i = 0 ; i < 4; i++){
                for(int j =2; j<15; j++){

                    com.example.geomatmatzi.tichu..Cards.SimpleCard tmp = new com.example.geomatmatzi.tichu..Cards.SimpleCard(i,j);
                    this.table.add(tmp);
                }
            }
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Drache());
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Mahjong());
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Hund());
            this.table.add(new com.example.geomatmatzi.tichu..Cards.Phoenix());
            this.currPlayer = null;


        }//numberOfPartRound++ meta to telos ka8e gurou



        /**
         * accessors
         * Epistrefei tis kartes tou paixnidou
         * @return Card[]
         */
        public ArrayList<com.example.geomatmatzi.tichu..Cards.Card> getTableCards() {
            return this.table;
        }

        public int GetActivePlayers(){
            int count =0;
            for(Player tmp : this.players){
                if(tmp.isIsActive()){
                    count++;
                }


            }
            return count;



        }
        /**
         * transformers
         * Eisagei tis kartes me tis opoies 8a paiksoun oi paiktes
         * @param cards
         */
        public void setCards(ArrayList<com.example.geomatmatzi.tichu..Cards.Card> cards) {
            this.table = cards;
        }

        /**
         * accessors
         * Epistrefei tous paiktes tou prwtou group
         * @return Player[]
         */
        public Team getFirstTeam() {
            return Team1;
        }

        /**
         * transformers
         * 8etei tou paiktes toy Group1
         * @param Group1
         */
        public void setFirstTeam(Team Group1) {
            this.Team1 = Group1;
        }

        /**
         * accessors
         * Epistrefei tous paiktes tou deyterou group
         * @return Player[]
         */
        public Team getSecondTeam() {
            return Team2;
        }

        /**
         * transformers
         * 8etei tou paiktes tou Group2
         * @param Group1
         */
        public void setSecondTeam(Team Group2) {
            this.Team2 = Group2;
        }

        /**
         * accessors
         * Epistrefei to eidos tou trexon guroy
         *
         * @return CardCombination
         */
        public com.example.geomatmatzi.tichu..Combinations.CardCombination getCurrentRound() {
            return currentRound;
        }

        /**
         * transformers
         * 8etei to eidos tou trexontos gurou,monofullia,pair ktl
         * @param currentRound
         */
        public void setCurrentRound(com.example.geomatmatzi.tichu..Combinations.CardCombination currentRound) {
            this.currentRound = currentRound;
        }

        /**
         * accessors
         * Epistrefei se poia partida vriskomaste
         * @return inte
         */
        public int getNumberRound() {
            return this.Round;
        }

        /**
         * transformers
         * 8etei ton ari8mo thn partidas
         * @param numberOfRound
         */
        public void setNumberRound(int numberOfRound) {
            this.Round = numberOfRound;
        }

        /**
         * accessor
         * Ypologizei to sunoliko score ka8e group, dhladh upologizei to score twn
         * 2 sumpektwn. Edw prepei na upologisoume to extrascore pou 8a dwsoume
         * an exei ginei 1-2,tichu 1-2 h grandtichu 1-2 nikh ths omadas.Epishs an kapoios
         * apo thn omada exei pei tichu h grandtichu kai dn einai nikhths prepei na
         * afaire8oun oi pontoi apo thn omada
         * @param group Player[]
         * @return int
         */
        public int getScoreOfGroup(Player[] group){return 0;}

        /**
         * accessors
         * Ypologizei to score tou nikhth pou einai h  mpaza tou, tou sumpaikth tou
         * kai h mpaza kai to xeri tou xamenou.edw prepei na upologisoume an o paikths exei pei
         * tichu h grand tichu na tou pros8esoume tous pontous.
         * @param p
         * @return int
         */
        public int getScoreOfWinner(Player p){return 0;}


        /**
         * accessor
         * Gia ton upologismo tou skore tou nikhth prepei o teleutaio na dwsei ta
         * fulla pou exei sto xeri tou kai thn mpaza tou ston nikhth.Ta dedomena pou
         * xreiazomaste ta pairnoume apo tis metavlhtes stis opoies exoume apo8hkeusei
         * ton nikhth  kai xameno
         * @param p1 winner
         * @param p2 looser
         */
        public void LooserGivesToWinner(Player p1,Player p2){};

        /**
         * accessors
         * Dinei thn lista me tous paiktes tou paixnidiou
         * @return List<Player>
         */
        public ArrayList<Player> getPlayers() {
            return players;
        }

        /**
         * accessors
         * Dinei tis kartes tou paixnidiou
         * @return List<Card>
         */
        public ArrayList<com.example.geomatmatzi.tichu..Cards.Card> getTable() {
            return table;
        }

        /**
         * transformers
         * oi kartes tis trapoulas
         * @param table
         */
        public void setTable(ArrayList<com.example.geomatmatzi.tichu..Cards.Card> table) {
            this.table = table;
        }

        /**
         * accessors
         * to wish tou paikth me to Mahjong
         * @return int
         */
        public int getWishNumber() {
            return wishNumber;
        }

        /**
         * transformers
         * 8etei to wish number tou paikth
         * @param wishNumber
         */
        public void setWishNumber(int wishNumber) {
            this.wishNumber = wishNumber;
        }

        /**
         * accessors
         * Epistrefei ton winner Player ths partidas
         * @return Player
         */
        public Player getFirstWinnerOfPartRound() {
            return firstWinner;
        }

        /**
         * transformers
         * Afou vre8ei o nikhths ton 8etoume ws winner
         * @param firstWinnerOfPartRound
         */
        public void setFirstWinnerOfPartRound(Player firstWinnerOfPartRound) {
            this.firstWinner = firstWinnerOfPartRound;
        }

        /**
         * accessors
         * Epistrefei tous paiktes pou exoun pei GrandTichu sthn partida
         * @return Player[]
         */
        public ArrayList<Player> getPlayerWhosaiGrandTichu() {
            return playerWhosaiGrandTichu;
        }

        /**
         * transformers
         * Apo8hkeuoume poioi exoun pei GrandTichu
         * @param playerWhosaiGrandTichu
         */
        public void addPlayerWhosaiGrandTichu(Player playerWhosaiGrandTichu) {
            this.playerWhosaiGrandcom.example.geomatmatzi.tichu..add( playerWhosaiGrandTichu);
        }
        /**
         * accessors
         * Epistrefei poioi paiktes exoun pei Tichu
         * @return
         */
        public ArrayList<Player> getPlayerWhosaidTichu() {
            return playerWhosaidTichu;
        }

        /**
         * transformers
         * Apo8hkeuoume poioi exoun pei Tichu
         * @param playerWhosaidTichu
         */
        public void addPlayerWhosaidTichu(Player playerWhosaidTichu) {
            this.playerWhosaidcom.example.geomatmatzi.tichu..add(playerWhosaidTichu);
            playerWhosaidcom.example.geomatmatzi.tichu..getTeam().setSaidtichu(true);
            playerWhosaidcom.example.geomatmatzi.tichu..setSaidTichu(true);
        }

        /**
         * accessors
         * Epistrefei ton paikth pou vghke deuteros sthn partida
         * @return Player
         */
        public Player getSecondWinnerOfPartRound() {
            return secondWinner;
        }

        /**
         * transformers
         * Vazei ton deutero paikth tou gurou
         * @param secondWinnerOfPartRound
         */
        public void setSecondWinnerOfPartRound(Player secondWinnerOfPartRound) {
            this.secondWinner = secondWinnerOfPartRound;
        }

        /**
         * accessors
         * Epistrefei poios einai o paikths pou exase sthn partida
         * @return Player
         */
        public Player getLastPlayerOfPartRound() {
            return this.lastPlayerOfRound;
        }

        /**
         * transformers
         * Apo8hkeuoume ton xameno paikth ths partidas
         * @param lastPlayerOfPartRound
         */
        public void setLastPlayerOfPartRound(Player lastPlayerOfPartRound) {
            this.lastPlayerOfRound = lastPlayerOfPartRound;
        }

        /**
         * transformer
         * Edw 8a midenizontai/allazoun oi listes me to tou paiktes ka8e partidas
         * poy exoun pei tichu,grandtichu, ton prwto, deutero k teleutaio paikth.
         * Auto giati meta to telos ka8e partidas kai thn arxh ths kainourias prepei
         * na exoyme tis dhlwseis twn new paiktwn kai allous nikhtes kai xamenous
         *
         * @return void
         */
        public void EmptyAllListOfPlayers(){};


        public int getCardsCategory(com.example.geomatmatzi.tichu..Combinations.CardCombination c){
            com.example.geomatmatzi.tichu..Combinations.CardCombination.sortDeck(c.getCards());

            switch(c.getCards().size()){
                case 1: //monofulo
                    return 1;
                case 2: //zeugos
                    if(c.getCards().get(0).getValue() == c.getCards().get(1).getValue()){
                        return 2;
                    }
                    else if(c.HasPhoenix()){
                        return 2;
                    }
                    return -1;
                case 3:
                    if(c.HasPhoenix()){
                        if((c.getCards().get(0).getValue() == c.getCards().get(1).getValue())|| (c.getCards().get(0).getValue() == c.getCards().get(2).getValue()) ||(c.getCards().get(2).getValue() == c.getCards().get(1).getValue()) ){
                            return 3;
                        }
                    }
                    if((c.getCards().get(0).getValue() == c.getCards().get(1).getValue()) && (c.getCards().get(0).getValue() == c.getCards().get(2).getValue())){
                        return 3;
                    }
                    return -1;
                case 4: //steps
                    int counta =0, countb=0;
                    if(c.HasPhoenix()){
                        if((c.getCards().get(2).getValue()- c.getCards().get(1).getValue() == 1) &&((c.getCards().get(3).getValue()==c.getCards().get(2).getValue())||(c.getCards().get(1).getValue()==c.getCards().get(2).getValue()))){
                            return 4;
                        }
                        else if((c.getCards().get(3).getValue()- c.getCards().get(2).getValue() == 1) &&((c.getCards().get(3).getValue()==c.getCards().get(2).getValue())||(c.getCards().get(1).getValue()==c.getCards().get(2).getValue()))){
                            return 4;
                        }

                    }
                    else{
                        if((c.getCards().get(2).getValue()- c.getCards().get(1).getValue() == 1) && (c.getCards().get(0).getValue()==c.getCards().get(1).getValue())&&(c.getCards().get(3).getValue()==c.getCards().get(2).getValue())){
                            return 4;
                        }


                    }
                    return -1;

                case 5:
                    if(c.HasPhoenix()){
                        //kenta
                        int count=0;
                        //count the gaps
                        for(int i = 1; i < c.getCards().size(); i++){
                            if((c.getCards().get(i).getValue() -c.getCards().get(i-1).getValue()) >1){
                                count++;
                            }
                        }
                        if(count ==1){
                            return 5;
                        }
                        //full
                        int same1= 1, same2 =1;
                        for(int j = c.getCards().size()-2 ; j >0 ; j--){
                            if(c.getCards().get(j).getValue()== c.getCards().get(c.getCards().size()-1).getValue()){
                                same1++;
                            }
                        }
                        for(int k = 2; k < c.getCards().size();k++){
                            if(c.getCards().get(1).getValue() == c.getCards().get(k).getValue()){
                                same2++;
                            }
                        }
                        if(same1 == same2){
                            if(c.getCards().get(c.getCards().size()-1).getValue() >c.getCards().get(1).getValue()){
                                //  c.getCards().get(0).setValue(c.getCards().get(c.getCards().size()-1).getValue());
                            }
                            else{
                                //  c.getCards().get(0).setValue(c.getCards().get(1).getValue());
                            }
                            return 6;
                        }
                        else{
                            if(same1 > same2){
                                c.getCards().get(0).setValue(c.getCards().get(c.getCards().size()-1).getValue());
                            }
                            else{
                                c.getCards().get(0).setValue(c.getCards().get(1).getValue());
                            }
                            return 6;
                        }

                    }
                    else{
                        //full

                        int countaa=0, countbb=0;
                        for(com.example.geomatmatzi.tichu..Cards.Card tmp1 : c.getCards()){

                            if(tmp1.getValue() == c.getCards().get(0).getValue()){
                                countaa++;
                            }
                            else if(tmp1.getValue() == c.getCards().get(c.getCards().size()-1).getValue()){
                                countbb++;
                            }
                        }
                        // System.out.println("Countaa "+ countaa + " Countbb "+ countbb);
                        if(countaa ==3){
                            if(countbb==2){
                                return 6;
                            }
                        }
                        if(countbb ==3){
                            if(countaa==2){
                                return 6;
                            }
                        }/*
                    if((c.getCards().get(0).getValue() == c.getCards().get(1).getValue())&&(c.getCards().get(2).getValue() ==c.getCards().get(3).getValue() &&c.getCards().get(3).getValue()==c.getCards().get(4).getValue())){
                        return 6;
                    }
                    if((c.getCards().get(0).getValue() == c.getCards().get(1).getValue() && c.getCards().get(1).getValue() ==c.getCards().get(2).getValue() )&&(c.getCards().get(3).getValue() ==c.getCards().get(4).getValue())){
                        return 6;
                    }*/
                        //kenta
                        int count=0;
                        //count the gaps
                        for(int i = 1; i < c.getCards().size(); i++){
                            if((c.getCards().get(i).getValue() -c.getCards().get(i-1).getValue())!=1){
                                count++;
                            }
                        }
                        if(count ==0){
                            return 5;
                        }






                    }
                    return -1;
                default:


                    //kenta
                    if(c.HasPhoenix()){
                        int count=0;
                        //count the gaps
                        for(int i = 2; i < c.getCards().size(); i++){
                            if((c.getCards().get(i).getValue() -c.getCards().get(i-1).getValue()) !=1){
                                count++;
                            }
                        }
                        if(count ==1){
                            return 5;
                        }

                        //Steps
                        if(c.getCards().size()%2 ==0){
                            for(int i= 2; i< c.getCards().size() ; i++){
                                if(((c.getCards().get(i).getValue() - c.getCards().get(i-1).getValue())!=1)){
                                    return -1;
                                }
                                i++;
                            }
                            return 4;
                        }


                    }
                    else{
                        int count=0;
                        //count the gaps
                        for(int i = 1; i < c.getCards().size(); i++){
                            if((c.getCards().get(i).getValue() -c.getCards().get(i-1).getValue()) !=1){
                                count++;
                            }
                        }
                        if(count ==0){
                            return 5;
                        }
                        //Steps
                        if(c.getCards().size()%2 ==0){
                            for(int i= 2; i< c.getCards().size() ; i++){
                                if(((c.getCards().get(i).getValue() - c.getCards().get(i-1).getValue())!=1)){
                                    return -1;
                                }
                                i++;
                            }
                            return 4;
                        }

                    }




                    //no match
                    return -1;



            }


        }



        public static void main(String[] args) {
            TICHU test = new TICHU("1","2","3","4");

            for(com.example.geomatmatzi.tichu..Cards.Card tmp : test.table){
                System.out.println("Card: "+tmp.toString());
            }
            System.out.println("Size " + test.table.size());
            // System.out.println("Shuffle: "+ test.drawFromDeck().toString());
            test.initialiazePlayersWithEightCards();
            test.initialiazePlayersWithSixMoreCards();

      /*  CardCombination.sortDeck(test.Team1.getP1().getPlayersHand());

        for(int i = 0 ; i < 14 ; i++){
            System.out.println("P1 "+ test.Team1.getP1().getPlayersHand().get(i).toString());
        }*/


            for(int i =0 ; i< 12 ; i++){
                test.currPlayer = test.getNextPlayer();
                //System.out.println("Play+ "+  test.getNextPlayer().getName());
                test.state=GameState.PLAYING;
            }
        }

        /**
         * @return the state
         */
        public GameState getState() {
            return state;
        }

        /**
         * @param state the state to set
         */
        public void setState(GameState state) {
            this.state = state;
        }
        public boolean CanSayTichu(Player p ){
            if(p.getPlayersHand().size() == 14){
                return true;
            }
            else{
                return false;
            }
        }

        /**
         * @param client the client to set
         */
        public void setClient(IGameClient client) {
            this.client = client;
        }
        public Player getCurrentPlayer(){
            if(this.getState() == GameState.WAIT4WISH){
                if(this.Team1.getP1().hasMahjong()){
                    this.currPlayer = this.Team1.getP1();
                    return this.Team1.getP1();
                }
                else if(this.Team1.getP2().hasMahjong()){
                    this.currPlayer = this.Team1.getP2();
                    return this.Team1.getP2();
                }
                else if(this.Team2.getP1().hasMahjong()){
                    this.currPlayer = this.Team2.getP1();
                    return this.Team2.getP1();
                }
                else{
                    this.currPlayer = this.Team2.getP2();
                    return this.Team2.getP2();
                }

            }
            else{
                return this.currPlayer;
            }
        }



    }

}

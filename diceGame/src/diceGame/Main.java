package diceGame;

/*
steg 1: Programmet ger spelaren 3 val av tärningar.ett unputvärde 1, 2, 3.
Steg 2: 3st objekt initieras roll1, roll2, roll3 baserat på val.
Steg 3: Valt objekt (1, 2, 3) kallar på game metoden där val av tärning exekveras (exempel: roll1.game(1);).
Steg 4: game metoden kallar på set metoden utifrån val av tärning och exekverar vald tärning med get metoden.
Steg 5: När  get metoden exekveras kallar game metoden på calcGameSats som beräknar antalet ronder, vinster, förluster och antalet poäng.
**/

public class Main 
{

  public static void main(String[] args)
  {

   
     Dice roll1 = new Dice(1, 1, 1); // objekt tärning 1
     
     Dice roll2 = new Dice(0, 2, 0); // objekt tärning 2
     
     Dice roll3 = new Dice(0, 0, 3); // objekt tärning 3


    
    System.out.println("Choose a dice [1, 2, 3]");
  
    roll1.game(1); // val av tärning  1
  
    roll2.game(2); // val av tärning  2
  
    roll3.game(3); // val av tärning  3
 
        
    }


  
}
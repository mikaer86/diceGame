package diceGame;
import java.util.*;
import java.util.Scanner;
import java.security.SecureRandom;

public class Dice  {

  private static final SecureRandom diceSides = new SecureRandom(); // deklarerar och initicerar objekt för slumptal.

  Scanner scan = new Scanner(System. in); // deklarerar och initicerar Scanner Objekt
  
  private int diceOne;  // tärning 1
  private int diceTwo;  // tärning 2
  private int diceThree; // tärning 3


  public Dice(int diceOne , int diceTwo, int diceThree){ // konstruktor för tärningar
  
  this.diceOne = diceOne;
  this.diceTwo = diceTwo;
  this.diceThree = diceThree;
  
  }

    public void setDiceOne(int diceOne) { // set metod som ansvarar för hantering av parametrar som beräknar slumptal för varje kast
      
    int min1 = 1; // minimum värde
    int face1 = min1 + diceSides.nextInt(6); // slumptal mellan 1 till 6
    this.diceOne = face1; // tärning 1 lagrar slumptalet
    

  }

  public void setDiceTwo(int diceTwo){ // set metod som ansvarar för  hantering av parametrar som beräknar slumptal för varje kast

    int min2 = 1;
    int face2 = min2 + diceSides.nextInt(6);
    this.diceTwo = face2; // tärning 2 lagrar slumptalet
 }
    

  public void setDiceThree(int diceThree) { // set metod som ansvarar för  hantering av parametrar som beräknar slumptal för varje kast

    int min3 = 1; // minimum värde
    int face3 = min3 + diceSides.nextInt(6); // slumptal mellan 1 till 6
    this.diceThree = face3; // tärning 3 lagrar slumptalet
    
    
  }

  public int getDiceOne() { // get metod hämtar tärningsvärde 
    
   return diceOne;

  }

  

  public int getDiceTwo(){ // get metod hämtar tärningsvärde 

    return diceTwo;
    
  }

   public int getDiceThree(){ // get metod hämtar tärningsvärde 

    return diceThree;
    
  }


  public void game(int choice) { // game metoden hanterar val mellan tärning 1, 2, 3 med parametern choice

    choice = scan.nextInt(); // läser in input värde från spelaren
   

    if (choice == 1) { // val av tärning 1

     this.setDiceOne(diceOne);
     
     System.out.println("Dice nr 1 is rolling.." + getDiceOne() ); // kastar tärning
      
     this.statsDice(0,0,0);  // beräknar vinst och förlust
     this.scoreDice(0,0); // beräknar ronder och poäng
     this.exitGame(true); // ger spelaren möjlighet att lämna spelet

      
    } else if (choice == 2) { // val av tärning 2

     this.setDiceTwo(diceTwo);
    
     System.out.println("Dice nr 2 is rolling.." + getDiceTwo()); // kastar tärning
    
     this.statsDice(0,0,0); // beräknar vinst och förlust
     this.scoreDice(0,0); // beräknar ronder och poäng
     this.exitGame(true); // ger spelaren möjlighet att lämna spelet
   

    } else if (choice == 3 ) { // val av tärning 3

      this.setDiceThree(diceThree);
      
      System.out.println("Dice nr 3 is rolling.." + getDiceThree());//exekverar tärning 3
      
      this.statsDice(0,0,0); // beräknar vinst och förlust
      this.scoreDice(0,0); // beräknar ronder och poäng
      this.exitGame(true); // ger spelaren möjlighet att lämna spelet
    }

  }

  public boolean exitGame(boolean q) { // stoppar programmet efter varje rond

    System.out.println(" Write [true] for Quit or [false] for Continue");
     q = scan.nextBoolean();

    

    if (q == true) {
  
      System.exit(0);

    } else if (q == false) {
      

      System.out.println("Choose another Dice [1, 2, 3]!");
      game(1);
      game(2);
      game(3);
    }
    
    return q;
  }
  
 // kalkylerar och loopar igenom antalet vinster och förluster
  public void statsDice(int wins, int losses, int maxDiceScore) {

   
    wins = 0; // vinster
    losses = 0; // förluster
    maxDiceScore = 6; // maxpoäng

    for (int i = 0; i <= 1; ++i) { // loopar igenom vinst och förlust från en intervall mellan 0 till 1.
                
       if( getDiceOne() == maxDiceScore){

         wins += 1;

         System.out.println("You Win! " + wins );
         
       } else if (getDiceOne() < 6) { // om tärning 1 är mindre än 6 lägg till +1 till losses.

         losses += 1; 
         System.out.println("You Lost! " + losses );
    
         
       } else if(getDiceTwo() == maxDiceScore){ // om tärning 2 är lika med 6 lägg till +1 till wins.

         wins += 1;
         

         System.out.println("You Win! " + wins );
         
       } else if (getDiceTwo() < 6){ // om tärning 2 är mindre än 6 lägg till +1 till losses.

         losses += 1;

         System.out.println("You Lost! " + losses );
         
       } else if(getDiceThree() == maxDiceScore){ // om tärning 3 är lika med 6 lägg till +1 till wins.

         wins += 1;
         

         System.out.println("You Win! " + wins );
         
       } else if (getDiceThree() < maxDiceScore){ // om tärning 1 är mindre än 6 lägg till +1 till losses.

         losses += 1;
        
         System.out.println("You Lost! " + losses);
         
       }

    }
  }

      public void scoreDice (int round, int score ) { // beräknar poäng
     
       round = 0; // rond
  
       score = 0; // poäng
        
       if (getDiceOne() >= getDiceTwo() || getDiceOne() >=  getDiceThree() ) { // Om värdet av tärning 1 är större eller lika med värdet av tärning 2 eller tärning 3. Addera antalet poäng och ronder med 1.
    
            round += 1; // lägger till antalet ronder med 1
            score +=  1; // lägger till antalet poäng med 1

            System.out.println("Round: " + round + " Score: " + score);
         
         } else if (getDiceOne() == getDiceTwo() || getDiceOne() ==  getDiceThree() ) { //Om värdet av tärning 1 lika med värdet av tärning 2 eller tärning 3. Addera antalet poäng och ronder med 1.
    
            round += 1; // lägger till antalet ronder med 1
            score += 1; // lägger till antalet poäng med 1
            
            System.out.println("Round: " + round + " Score: " + score);
            
          } else if(getDiceOne() <= getDiceTwo() || getDiceOne() <=  getDiceThree()) { //Om Tärning 1 är mindre än värdet av tärning 2 eller tärning 3. Addera antalet poäng och ronder med 1.
    
            round += 1; // lägger till antalet ronder med 1
            score += 1; // lägger till antalet poäng med 1
    
            System.out.println("Round: " + round + " Score: " + score);
            
          }
    
           if (getDiceTwo() >= getDiceOne() || getDiceTwo() >=  getDiceThree()) {  //Om Tärning 2 är större än värdet av tärning 1 eller tärning 3. Addera antalet poäng och ronder med 1.
    
    
            round += 1; // lägger till antalet ronder med 1
            score += 1; // lägger till antalet poäng med 1
            
            System.out.println("Round: " + round + " Score: " + score);
             
             
            
          } else if (getDiceTwo() == getDiceOne() || getDiceTwo() == getDiceThree() ) { //Om värdet av tärning 2 lika med värdet av tärning 1 eller tärning 3. Addera antalet poäng och ronder med 1.
    
           round += 1; // lägger till antalet ronder med 1
           score +=  1; // lägger till antalet poäng med 1
            
           System.out.println( "Round: " + round + " Score: " + score);
             
          } else if(getDiceTwo() <= getDiceOne() || getDiceTwo() <= getDiceThree()) { //Om Tärning 2 är mindre än värdet av tärning 1 eller tärning 3. Addera antalet poäng och ronder med 1.
    
           round += 1; // lägger till antalet ronder med 1
           score +=  1; // lägger till antalet ronder med 1
    
          System.out.println("Round: " + round + " Score: " + score);
             
          }
    
           if (getDiceThree() >= getDiceTwo() || getDiceThree() >=  getDiceOne() ) { //Om Tärning 3 är större än värdet av tärning 2 eller tärning 1. Addera antalet poäng och ronder med 1.
    
            round += 1; // lägger till antalet ronder med 1
            score +=  1; // lägger till antalet poäng med 1
    
           System.out.println("Round: " + round + " Score: " + score);
            
          } else if (getDiceThree() == getDiceTwo() || getDiceThree() == getDiceOne() ) { //Om värdet av tärning 3 lika med värdet av tärning 2 eller tärning 1. Addera antalet poäng och ronder med 1.
    
            round += 1; // lägger till antalet ronder med 1
            score +=  1; // lägger till antalet poäng med 1
    
    
            System.out.println("Round: " + round + " Score: " + score);
             
          } else if(getDiceThree() <= getDiceTwo() || getDiceThree() <= getDiceOne() ) { //Om Tärning 3 är mindre än värdet av tärning 2 eller tärning 1. Addera antalet poäng och ronder med 1.
    
           round += 1; // lägger till antalet ronder med 1
           score += 1; // lägger till antalet poäng med 1
    
           
          System.out.println("Round: " + round + " Score: " + score);
    
        }

      }
}

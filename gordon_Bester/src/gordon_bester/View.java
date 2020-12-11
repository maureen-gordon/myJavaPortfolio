/*
 * Maureen Gordon
 * IT-DEV-110-500
 * Assignment 9
 */
package gordon_bester;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Maureen Gordon
 */
public class View {
    int numTurns;//number of turns allowed per game (derived from ScoreCard class)
    int round = 1; //the current round
    Scanner keyboard = new Scanner(System.in);
    String input;//user input, continue or quit
    String name;//user name
    int quitTurn = 0;//turn when the user decided to quit
    boolean quit = false;//ask the user to quit or continue
    
    //ask for user name
    public void promptUserName()
    {
        System.out.println("Please enter your name:");
        name = keyboard.nextLine();
        System.out.println("\nHello, " + name + "!\n\n");
        System.out.println("You are currently playing Round " + round + " against the Computer.  Good luck!\n");
    }
    //exexcute the game
    public void rollDice() throws LineUnavailableException
    {
        SoundUtils soundUt = new SoundUtils();//call SoundUtils class
        
        do
        {
            ScoreCard computer = new ScoreCard("Computer", round);//call the ScoreCard class
            ScoreCard user = new ScoreCard(name, round);
        
            numTurns = ScoreCard.getNumTurns();
            
        
            for( int turn = 0; turn < numTurns; turn++)
            {
                computer.throwDice();//computer throw dice
                soundUt.computerSound();//play sound
                
                boolean invalidInput = true;
                
                do
                {  //to continue or quit the game
                    System.out.println("Input 'R' to roll your next turn or 'Q' to quit");
                    input = keyboard.nextLine().toUpperCase();
            
                    if( input.charAt(0) == 'Q')//if user inputs Q to quit
                    {
                        System.out.println("You quit your current game.");
                        invalidInput = false;
                        quit = true;
                        quitTurn = turn;
                        computer.rollBackTotal(quitTurn);
                        // set turn = numTurns to break out of the for loop
                        turn = numTurns;
                    }
                    else if( input.charAt(0) == 'R' )//if user inputs R to continue the game
                    {
                        System.out.println();
                        user.throwDice();//user to throw the dice if R is entered
                        soundUt.userSound();
                        invalidInput = false;
                    }
                    else
                    {
                        System.out.println("Your input was invalid.");//if user inputs neither Q nor R
                    }
                }while(invalidInput);
            }
            if(!quit)
            {
                System.out.println("Here are the results for Round " + round + ":");//display score results per round
                System.out.println(computer.getName() + "'s Total Score: " + computer.getTotalScore());//computer score per round
                System.out.println(user.getName() + "'s Total Score: " + user.getTotalScore());//user score per round
                
                if( user.getTotalScore() < computer.getTotalScore())//if user score is lower than computer score
                {
                    System.out.println("\n" + computer.getName() + " wins Round " + round + "!\n");//display when computer wins the round
                    soundUt.computerSound();
                }
                else if( user.getTotalScore() > computer.getTotalScore())//if user score is higher than computer score
                {
                    System.out.println("\n" + user.getName() + " wins Round " + round + "!\n");//display when user wins the round
                    soundUt.win();
                }
                else
                {
                    System.out.println("\n" + user.getName() + " and " + computer.getName() + " tied for round " + round + "!\n");//if score is tied
                }
                round++;
            }
            else if (quit)//display when user quits
            {
                System.out.println("\nYou chose to stop playing the game on Turn " + (quitTurn + 1) + ".");
                System.out.println("Here are the results for the last completed Turn of Round " + round + ":");//display the round when user quits
                System.out.println("On Turn " + quitTurn + ", " + computer.getName() + "'s Total Score: " + computer.getTotalScore());//display computer score
                System.out.println("On Turn " + quitTurn + ", " + user.getName() + "'s Total Score: " + user.getTotalScore());//display user score
                
                if( user.getTotalScore() < computer.getTotalScore())//display when computer wins after user quits
                {
                    System.out.println("\n" + computer.getName() + " was winning Round " + round + " when you stopped playing!\n");
                    soundUt.computerSound();
                }
                else if( user.getTotalScore() > computer.getTotalScore())//display when user wins after user quits
                {
                    System.out.println("\n" + user.getName() + " was winning Round " + round + " when you stopped playing!\n");
                    soundUt.win();
                }
                else//display when user and computer are tied after user quits
                {
                    System.out.println("\n" + user.getName() + " and " + computer.getName() + " were tied for round " + round + " when you stopped playing!\n");
                    soundUt.computerSound();
                }
            }
        }while(!quit);
        
    }
}

/*
 * Maureen Gordon
 * IT-DEV-110-500
 * Assignment 9
 */
package gordon_bester;

/**
 *
 * @author Maureen Gordon
 */
import java.util.Random;


public class ScoreCard {
    Random r = new Random();//creating the random number generator
    static final int numTurns = 5;//to declare number of turns
    static final int numThrows = 5;//to declare number of throws
    int [][] diceThrows;//multidimensional arrays
    int [] turnScores;//score each turns
    int totalScore;//total score
    int round;//to declare round
    
    int turnNumber;//to track turns
    String name;
    
    //Constructor for the ScoreCard class.  Each ScoreCard takes a name
    //because the object is associated with a player, and it takes the current round
    //for printing purposes
    public ScoreCard(String name, int round)//
    {
        this.name = name;
        this.round = round;
        turnNumber = 0;
        diceThrows = new int[numTurns][numThrows];
        turnScores = new int[numTurns];
        totalScore = 0;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getTotalScore()
    {
        return totalScore;
    }
    
    static public int getNumTurns()
    {
        return numTurns;
    }
    //to compute the score per round
    public void throwDice()
    {
        System.out.println( name + "'s Turn " + (turnNumber + 1) + " Results for Round " + round + ": ");
        turnScores[turnNumber] = 0;
        System.out.print("Dice Throws:   ");
        for (int diceNumber = 0; diceNumber < diceThrows[turnNumber].length; diceNumber++)
        {
            int diceThrow = r.nextInt(6) + 1;
            diceThrows[turnNumber][diceNumber] = diceThrow;
            turnScores[turnNumber] += diceThrow;
            totalScore += diceThrow;
            System.out.print(diceThrows[turnNumber][diceNumber] + "   ");
        }
        System.out.print("   Score This Turn:   " + turnScores[turnNumber] + "   ");
        System.out.println("   " + name + "'s Running Total Score:   " + totalScore + "\n");
        
        turnNumber++;
    }

    //Because the Computer always goes first, rollback the Computer's total score
    //when the User decides to quit, so to compare the total score for the last
    //turn that both the Computer and User completed
    public void rollBackTotal( int turnQuit )
    {
        totalScore -= turnScores[turnQuit];
    }
}

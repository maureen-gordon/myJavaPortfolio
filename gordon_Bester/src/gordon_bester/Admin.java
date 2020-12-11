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
import javax.sound.sampled.LineUnavailableException;

public class Admin {
    SoundUtils tone;
    
    public Admin()
    {
        tone = new SoundUtils();
    }
    //intro about the game
    public void displayIntro() throws LineUnavailableException
    {
        tone.intro();
        System.out.println("Welcome to Bester game. This game works by beating"
                + " a computer's score through dice rolling.\n" + "You will"
                + " have five chances to roll the dice per round. In each roll"
                + " you will throw 5 dice\n\n");
    }
           
}

/*
 * Maureen Gordon
 * ITDEV110-500
 * Assignment 10
 */
package gordon_guesstheword;

/**
 *
 * @author Maureen Gordon
 */
public class Admin {
       
    public void gameIntro()//game intro and instruction
    {
        System.out.println("Welcome to Guess the Word Game. This game works "
                    + "by guessing the secret word through entering letters. "
                    + "Each word will have a hint. "
                    + "You have 7 attempts to guess the word.\n");
    }
        
    public void gameExit()//exit message
    {
        System.out.println("\n\nThank you for playing Guess the Word Game.");
    }
}

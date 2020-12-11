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
import javax.sound.sampled.LineUnavailableException;
public class Gordon_GuessTheWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LineUnavailableException {
       SoundUtils tone = new SoundUtils();//instantiate soundutils class
       Admin adm = new Admin();//instantiate admin class
       adm.gameIntro();//display game intro
       tone.intro();//sound for game intro to get user's attention
       //ask the user to play again after the game
       boolean restart = true;
       do
       {
           GameController control = new GameController();
           restart = control.toPlayAgain();
       }while (restart == true);
       adm.gameExit();//display exit message
        
    }
    
}

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
public class Gordon_Bester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LineUnavailableException {
        
        Admin adm = new Admin();//call the Admin class
        adm.displayIntro();//display intro
        View v = new View();//call the view class
        v.promptUserName();//ask for user name
        v.rollDice();//execute the game
    }
}

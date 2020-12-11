/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gordon_guesstheword;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Maureen Gordon
 */
public class GameController {
    View v = new View();//initialize the view class
    //method to execute the game and prompt to play another game
    public boolean toPlayAgain() throws LineUnavailableException//
    {
        v.playGame();
        return v.playAgain();
    }
}

/*
 * Maureen Gordon
 * ITDEV110-500 
 * Midterm Exam
 */
package gordon_midtermapp;

import javax.sound.sampled.LineUnavailableException;
/**
 *
 * @author Maureen Gordon
 */
public class Controller {
    //keeps count of how many game scores have been entered
    static int currentGame = 0;
    
    //constructor for the controller, also executes controller responsibilities
    public Controller (View view) throws LineUnavailableException
    {
        int currentFrame;
        int currentThrow;
        
        //increment the game count
        currentGame++;
        //get user input for entering the pins knocked down for this game
        int[] Throws = view.enterThrows();
        
        //clear the throw record and running score from the previous game
        Model clearGame = new Model();
        
        //calculates and prints the score for each standard frame of the game
        for(currentFrame = 1; currentFrame < 10; currentFrame++)
        {
            currentThrow = (currentFrame - 1) * 2;
            Model frame = new Model(currentFrame, Throws[currentThrow], Throws[currentThrow + 1], Throws[currentThrow + 2], Throws[currentThrow + 3], Throws[currentThrow + 4] );
            view.printFrame(frame);
        }
        
       //calculates and prints the score for the final frame of the game
        currentThrow = (currentFrame - 1) * 2;
        Model finalFrame = new Model(currentFrame, Throws[currentThrow], Throws[currentThrow + 1], Throws[currentThrow + 2]);
        view.printFrame(finalFrame);
        
        //prints the stats for this game and for the total stats of all games
        view.printStats(finalFrame, currentGame);
        
    }
}


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
public class Admin {
    
    View view;
    
    public Admin(View view) throws LineUnavailableException
    {
        //displays intro and direction
        this.view = view;
        view.intro();
        view.displayInfo("Welcome to Bowlio, the bowling calulator with attitude! This app calculates bowling scores. "
                + "Please enter your score for the first game:\n");
    }
    //allow the user to enter a new set of scores
    public boolean promptAgain()
    {
        return this.view.promptAgain();
    }
    //allow the user to close the app
    public void close() throws LineUnavailableException
    {
        this.view.goodbye();
    }
}


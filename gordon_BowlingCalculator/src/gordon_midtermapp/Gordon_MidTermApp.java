/*
 * Maureen Gordon
 * ITDEV110-500 
 * Midterm Exam
 */
package gordon_midtermapp;
/**
 *
 * @author Maureen Gordon
 */

import javax.sound.sampled.LineUnavailableException;

public class Gordon_MidTermApp 
{
    /**
     * @param args the command line arguments
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public static void main(String[] args) throws LineUnavailableException {
       
        boolean again;//variable to determine whether the user wants to enter another set of scores
        //creates the View used for the app
        View view = new View();
        //creates the Admin object that greets the user
        Admin adm = new Admin(view);

    
        do{
            Controller controller = new Controller(view);
            again = adm.promptAgain();
        } while(again);//to allow the users to enter new sets of scores

        adm.close();//to close the app
    }   
 }


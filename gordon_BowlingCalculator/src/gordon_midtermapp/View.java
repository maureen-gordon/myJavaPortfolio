/*
 * Maureen Gordon
 * ITDEV110-500 
 * Midterm Exam
 */
package gordon_midtermapp;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Maureen Gordon
 */
public class View {
    
    
    //Variables used in intro and goodbye tunes
    final int noteC = 264;
    final int noteD = 297;
    final int noteE = 330;
    final int noteF = 352;
    final int noteG = 396;
    final int noteAflat = 415;
    final int noteA = 440;
    final int noteBflat = 466;
    final int noteB = 495;
    final int noteC2 = 528;
    final int noteE2 = 660;
    final int noteG2 = 792;
    
    //input information for each game and the ongoing game
    int frameNumber;
    int score;
    int total;


    //create the global input for the view
    Scanner keyboard = new Scanner(System.in);
    
    public final void displayInfo (String content)
    {
        // Displays the directions for the application
        System.out.println(content);
    }
    //displays intro, plays intro sounds
    public void intro() throws LineUnavailableException
    {
        System.out.println("It'sa Meee! BOOOWWWLLIOOOO!!!!\n");
        try {
            SoundUtils.tone (noteE2, 200);
            SoundUtils.tone (noteE2, 200);
            Thread.sleep(150);
            SoundUtils.tone (noteE2, 200);
            Thread.sleep(150);
            SoundUtils.tone (noteC2, 200);
            SoundUtils.tone (noteE2, 200);
            Thread.sleep(150);
            SoundUtils.tone (noteG2, 400);
            Thread.sleep(400);
            SoundUtils.tone (noteG, 400);
           
        } catch (InterruptedException e) {
            System.out.println("sleep exception.");
        }
    }
    //displays goodbye message and plays goodbye sound
    public void goodbye() throws LineUnavailableException
    {
        System.out.println("\nSo loonnga, Bowler!!!");

            SoundUtils.tone (noteC2, 550);
            SoundUtils.tone (noteG, 550);
            SoundUtils.tone (noteE, 550);
            SoundUtils.tone (noteA, 300);
            SoundUtils.tone (noteB, 300);
            SoundUtils.tone (noteA, 300);
            SoundUtils.tone (noteAflat, 300);
            SoundUtils.tone (noteBflat, 300);
            SoundUtils.tone (noteAflat, 300);
            SoundUtils.tone (noteG, 150);
            SoundUtils.tone (noteF, 150);
            SoundUtils.tone (noteG, 1100);
    }
   
   //gets the throws for each frame of the current game from the user 
   public int[] enterThrows()
    {

        int currentFrame;
        int currentThrow = 0;
        int numPins = 0;
        boolean bonusThrow = false;
        int[] Throws = new int[21];
        
        
        //for each frame, prompts the user for the pins knocked down for the first and second throw
        for(currentFrame = 1; currentFrame < 10; currentFrame++)
        {
            currentThrow = (currentFrame - 1) * 2;
            System.out.println("Enter your first throw for Frame " + currentFrame + ": ");
            numPins = inputThrow();
            Throws[currentThrow] = numPins;
            currentThrow++;
            if(numPins == 10)
            {
                System.out.println("Strrrrrriiiike!!!!! X");
            }
            else
            {
                //increments for the next throw entered by the user for this frame
                System.out.println("Enter your second throw for Frame " + currentFrame + ": ");
                numPins = inputThrow(Throws[currentThrow - 1]);
                Throws[currentThrow] = numPins;
                if( (numPins + Throws[currentThrow -1]) == 10)
                {
                    System.out.println("Nice Spare!    /");
                }
            }
        }
        
        currentThrow++;
        
        //prompts the user to enter throws for the final frame
        System.out.println("Enter your first throw for the Final Frame!");
        numPins = inputThrow(Throws[currentThrow -1]);
        Throws[currentThrow] = numPins;
        currentThrow++;
        if(numPins == 10)
        {
            System.out.println("Strrrrrriiiike!!!!! X");
            bonusThrow = true;
        }
        
        System.out.println("Enter your second throw for the Final Frame!");
        numPins = inputThrow();
        Throws[currentThrow] = numPins;
        if(numPins == 10)
        {
            System.out.println("Strrrrrriiiike!!!!! X");

            bonusThrow = true;
        }
        else if((numPins + Throws[currentThrow - 1]) == 10)
        {
            System.out.println("Nice Spare!    /");
            bonusThrow = true;
        }
        
        currentThrow++;
        
        /*if the user scored a strike or spare in the first two throws of the final frame
         *then they can throw a third throw
         */
        if(bonusThrow)
        {
            System.out.println("Enter your final throw for the game!");
            numPins = inputThrow();
            Throws[currentThrow] = numPins;
        }
        else
        {
            Throws[currentThrow] = 0;
        }
        //displays final score
        System.out.println("Great Game!  Here's your score: ");

        return Throws;
    }   
   
   //when no input variable is given, this function represents the first thow of a frame
   private int inputThrow()
   {
       int input = keyboard.nextInt();

       
       while( input < 0 || input > 10 )
       {
           System.out.println("Please enter a value of pins between 0 and 10.");
           input = keyboard.nextInt();
       }
       
       return input;
   }
   
   //when an input variable is given, this function represents the first thow of a frame
   public int inputThrow(int prevThrow)
   {
       int input = keyboard.nextInt();
       
       while( input < 0 || (input + prevThrow) > 10 )
       {
           if( input < 0 || input > 10 )
           {
               System.out.println("Please enter a value of pins between 0 and 10.");
           }
           else if( (input + prevThrow) > 10 )
           {
               System.out.println("Only a maximum of 10 pins can be knocked down per frame.");
           }
           
           input = keyboard.nextInt();
       }
       
       return input;
   }

    // prints the ongoing score at each frame of the inputted game
    public static void printFrame(Model frame)
    {
       System.out.println("Frame " + frame.getFrameNumber() + ": " + frame.getScore());
    }
    
    
    // prints the stats for the current game, and total number of games
    public static void printStats(Model frame, int numGames)
    {
       System.out.println("Your final score for this game was: " + frame.getScore());
       System.out.println("Your total score for " + numGames + " games was: " + frame.getTotal());
       System.out.println("Your average score for " + numGames + " games was: " + (frame.getTotal() / numGames));
    }
   

    boolean currentFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //allow the user to enter a new set of scores or quit
    boolean promptAgain()
    {
        char answer;
        System.out.println("Do you want to calculate another game's stats? (Y or N)");
        answer = keyboard.next().toUpperCase().charAt(0);
 
        
        if(answer == 'Y')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


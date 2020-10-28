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
public class Model {

    static void printFrame(Model frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private int frameNumber;
    private int score;
    private static int frameScore;  //total score for this game
    private static int total;  //total score for all games added together
    
    public Model (View myView)
    {
       //take View instance 
       frameNumber = myView.frameNumber;
       score = myView.score;
       total = myView.total;

    }        
    //getter and setter method
    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public int getScore() {
        return frameScore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }
   

    public void setTotal(int total) {
        this.total = total;
    }
    
   //clear last game's on-going score
    public Model()
    {
        this.frameScore = 0;
    
    }
    
   //constructor to pass the relevant throws to score the current frame
   public Model(int frameNumber, int throw1, int throw2, int bonus1, int bonus2, int bonus3)
   {       
       this.frameNumber = frameNumber;
       this.score = 0;
       
       //strike!
       if(throw1 == 10)
       {
           // if the next frame's first throw is also a strike
           if(bonus1 == 10)
           {
               this.score = throw1 + bonus1 + bonus3;
           }
           //the next frame was not a strike, so all bonuses will be within that frame
           else
           {
               this.score = throw1 + bonus1 + bonus2;
           }
           
       }
       //spare
       else if(throw1 + throw2 == 10)
       {
           //the bonus for a spare is always the first throw of the next frame
           this.score = throw1 + throw2 + bonus1;
       }
       else
       {
           //no bonuses are applied; just add the two throws for the frame
           this.score = throw1 + throw2;
       }
       this.frameScore += this.score;
       this.total += this.score;
       
   }
   
   //constructor to pass the relevant throws to score the final frame
   public Model(int frameNumber, int finalThrow1, int finalThrow2, int finalThrow3)
   {       
       this.frameNumber = frameNumber;
       
       //players always get at least 2 throws in the final frame
       this.score = finalThrow1 + finalThrow2;
       
       //a strike or spare earns them one last throw
       if((finalThrow1 == 10) || (finalThrow1 + finalThrow2 == 10))
       {
           this.score += finalThrow3;
       }
       
       this.frameScore += this.score;
       this.total += this.score;
   }

}

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

import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

public class View {
    Random r = new Random();//initialize to produce random int
    String [] secretWordList = {"eggnog", "gucci", "zootopia", 
        "pikachu", "jordan", "morocco", "the office",
        "lincoln", "subaru", "madonna"};//random words in array
    String [] secretWordListHint = {"holiday drink", "fashion brand", 
        "disney movie", "pokemon character", "Sports Icon. His first name is Michael", "country", 
        "tv show", "Former US President. His first name is Abraham", "car brand", "music icon"};//hints for random words in array
    Scanner keyboard = new Scanner(System.in);
    String secretWord;//for computer selected word
    String hint;//to give user a hint
    char[] wrongLetters;//wrong user guesses
    char[] blanks;//to display blank for each letters
    char guess;//user gues
    int maxAttempt = 7;//number of user attempt to guess the word
    int currentTry = 0;//counts number of tries
    int totalCorrect = 0;//counts correct answers
    int index;//locates which word selected randomly
    String restart;//to ask the user to play again
    char quit = '1';//to have the option to quit every turn
    boolean exit = false;
    
    SoundUtils tone = new SoundUtils();
    
        
        public void playGame() throws LineUnavailableException
        {
           index = r.nextInt(secretWordList.length);//generate random index location in the array
           secretWord = secretWordList[index];//randomly selected word
           hint = secretWordListHint[index];//hint for randomly selected word
           wrongLetters = new char[maxAttempt];//limits wrong guesses
           blanks = new char [secretWord.length()];//displays blanks based on the number of letters of randomly selected word
           for(int i = 0; i < secretWord.length(); i++)
           {
               if(secretWord.charAt(i) == ' ')
               {
                blanks[i] = ' ';
                totalCorrect++;
               }
               else
               {
                   blanks[i] = '_';
               }
               
           }

           do {
               //if the user guess is wrong
               boolean found = false;
               System.out.println("\nYou have guessed wrong " + currentTry + " out of " + maxAttempt + " times.  Please enter a letter to guess the word or 1 to quit");
              
               System.out.println("\nHint: " + hint);
               for (int i = 0; i < blanks.length; i++){
                   System.out.print(" " + blanks[i]);
               }
               System.out.println();
               
               if( currentTry > 0 )//displays wrong guesses
               {
                   System.out.print("Wrong guess(es):");
                   for (int i = 0; i < currentTry; i++){
                        System.out.print(" " + wrongLetters[i]);
                    }
               System.out.println();
               }
               //if the user guess is found in the secretWord, blank will be replaced by correct letter
               guess = keyboard.nextLine().charAt(0);
               for (int i = 0; i < secretWord.length(); i++){
                   if(secretWord.charAt(i) == guess){
                       found = true;
                       blanks[i] = guess;
                       totalCorrect++;
                   }
               }
               if(guess == quit)//if user decides to quit in the middle of the game
               {
                   exit = true;
               }
               if(!found)//if the user input is wrong
               {
                   wrongLetters[currentTry] = guess;
                   currentTry++;
                   tone.LOOOserrrr();
               }
               else
               {
                   System.out.println("Correct!");//if user input is correct
               }
               
               if(totalCorrect == secretWord.length())//if user guesses the secret word
               {
                   System.out.println("You won! You guessed the word " + secretWord);
                   exit = true;
                   tone.win();
               }
               
               if(currentTry == maxAttempt)//if the user has reached maximum attempt and has not guess the word
               {
                   System.out.println("You lost! The correct word was " + secretWord);
                   exit = true;
               }
               
           }while(!exit);
        }
        
        public boolean playAgain()//ask the user to play again
        {
            System.out.println("Would you like to play again? Y or N");
            restart = keyboard.nextLine().toUpperCase();
            if(restart.charAt(0) == 'Y')
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    


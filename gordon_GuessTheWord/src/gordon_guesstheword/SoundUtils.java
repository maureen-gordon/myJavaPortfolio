/*
 * Maureen Gordon
 * IT-DEV-110-500
 * Assignment 9
 */
package gordon_guesstheword;

/**
 *
 *
 */
import javax.sound.sampled.*;

public class SoundUtils 
{

  public static float SAMPLE_RATE = 8000f;
      //An integer value for the notes. See the noteConversion()
  final int noteFsharp = 185;
  final int noteC = 264;
  final int noteD = 297;
  final int noteE = 330;
  final int noteF = 352;
  final int noteG = 396;
  final int noteA = 440;
  final int noteB = 495;
  final int noteC2 = 528;
  final int noteD2 = 594;
  

  public static void tone(int hz, int msecs) throws LineUnavailableException 
  {
     tone(hz, msecs, 1.0);
  }

  public static void tone(int hz, int msecs, double vol)throws LineUnavailableException 
  {
    byte[] buf = new byte[1];
    AudioFormat af = 
        new AudioFormat(
            SAMPLE_RATE, // sampleRate
            8,           // sampleSizeInBits
            1,           // channels
            true,        // signed
            false);      // bigEndian
    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    sdl.open(af);
    sdl.start();
    
    for (int i=0; i < msecs*8; i++) {
      double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
      buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
      sdl.write(buf,0,1);
    }
    sdl.drain();
    sdl.stop();
    sdl.close();
  } 
  
  public void userSound() throws LineUnavailableException
  {
    tone(noteC2, 200);
    tone(noteD2, 200);
  }
  
  public void computerSound() throws LineUnavailableException
  {
    tone(noteD, 200);
    tone(noteC, 200);
  }
  
  public void LOOOserrrr() throws LineUnavailableException
  {
    tone(noteC, 400);
    tone(noteFsharp, 400);
  }
  
  public void win() throws LineUnavailableException
  {
    tone(noteF, 200);
    tone(noteE, 200);
    tone(noteD, 200);
    tone(noteG, 200);
    tone(noteC, 400);
  }
  
  public void intro() throws LineUnavailableException
  {
    tone(noteC, 200);
    tone(noteC2, 200);
    tone(noteE, 200);
    tone(noteG, 200);
    tone(noteC, 200);
    tone(noteC2, 200);
    tone(noteE, 200);
    tone(noteG, 200);
    tone(noteC, 400);
  }
  
  public void outro() throws LineUnavailableException
  {
    tone(noteC2, 200);
    tone(noteC2, 200);
    tone(noteB, 200);
    tone(noteB, 200);
    tone(noteA, 200);
    tone(noteA, 200);
    tone(noteG, 200);
    tone(noteG, 200);
    tone(noteF, 200);
    tone(noteF, 200);
    tone(noteE, 200);
    tone(noteG, 200);
    tone(noteC, 400);
  }
}
/*
 * Maureen Gordon
 * ITDEV 110-500
 * Assignment 4
 */
package gordon_vprofits;
        
/**
 *
 * @author Maureen Gordon
 */
public class Gordon_VProfits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean again = true;
        Calculator calc = new Calculator ();
        
        /*do-while loop to keep the calculator open and allow user to calculate another 
         *profit
         */
        do {
            calc.getUserInput();
            again = calc.calculateProfit();
        } while(again);
        
        System.out.println("Goodbye!");
    }
}

/*
 * This is an app that computes profit and retail price without profit of 
 * a circuit board from a price specified by the user
 */
package gordon_profits;

/*Maureen Gordon
 *ITDEV 110-500
 *Assignment 3
 */

public class Gordon_Profits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.getUserInput();
        calc.calculateProfit();
        calc.printSummary();
        
    }
    
}

/*
 *
 *
 */
package gordon_profits;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Date;

public class Calculator {
    
    Scanner keyboard = new Scanner(System.in);
    String nameOfCompany;
    double retailPrice;
    double profit;
    Date d = new Date();

//this is the constructor method
    public Calculator() {
    
    }
    
//this method prompts user to input company name and price of circuit board   
    public void getUserInput() 
    {
        System.out.println("What is the name of your company?");
        nameOfCompany = keyboard.nextLine();
        
        System.out.println("What is the retail price of a circuit board?");
        retailPrice = keyboard.nextDouble();
    }
 
//this method calculate profit from the price that the user entered
    public void calculateProfit() 
    {
        profit = retailPrice * .4;
        System.out.println("Your earned profit is " + profit);
        System.out.println("\n");
        
        
        
    }
/*this method displays the user's company name, 
 *    date and time, retail price of the circuit board without profit 
 *    and profits
 */
    
    public void printSummary()
    {
        System.out.println("Company name: " + nameOfCompany);
        System.out.println(d);
        System.out.println("Retail price of circuit board without profit: " + (retailPrice-(profit)));
        System.out.println( "Profit: " + profit );
    }
    
    
}

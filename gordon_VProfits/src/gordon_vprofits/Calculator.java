/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gordon_vprofits;

import java.util.Scanner;
import java.util.Date;
import java.text.DecimalFormat;

/**
 *
 * @author Maureen Gordon
 */
public class Calculator {
    
    Scanner keyboard = new Scanner(System.in);
    String nameOfCompany;
    double priceOfCircuitBoard;
    double profitPercentage;
    double profit;
    double retailPrice;
    Date d = new Date();
    String repeatString;
    boolean again;
    
        public Calculator () {
    
        }
        /*this method is for getting user company name, circuit board price, 
         * and preferred profit percentage
         */
        public void getUserInput () 
        {
            System.out.println("Enter company name");
            nameOfCompany = keyboard.nextLine();

            System.out.println("Enter price of circuit board");
            priceOfCircuitBoard = keyboard.nextDouble();

            System.out.println("Enter preferred profit percentage");
            profitPercentage = keyboard.nextDouble();
            keyboard.nextLine();  //needs to be called to consume the newline from the nextDouble input
            System.out.println("\n");
        }
        /*this method is for displaying company name, retail price after profit
         *and the actual amount of profit on top of the retail price
         *as well as prompting if user wants to calculate another profit
         */
        public boolean calculateProfit ()
        {
            profit = priceOfCircuitBoard * (profitPercentage/100);
            retailPrice = priceOfCircuitBoard + profit;
            System.out.println("Name of Company: " + nameOfCompany);
            System.out.println("Date: " + d);
            DecimalFormat df = new DecimalFormat ("0.00");
            System.out.println("Retail price of circuit board is $" + 
                    df.format(retailPrice));
            System.out.println("Your profit is $" + df.format(profit));
            System.out.println("\n");
            System.out.println("Do you want to calculate another profit? "
                + "Yes or No");
            repeatString = keyboard.nextLine();
            again = repeatString.equals("Yes");
            
            return again;
        }   
}

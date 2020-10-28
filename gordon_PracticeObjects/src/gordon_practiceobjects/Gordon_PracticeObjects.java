/*
 * Maureen Gordon
 * ITDEV110-500
 * Assignment 5
 */
package gordon_practiceobjects;

/**
 *
 * @author Maureen Gordon
 */
public class Gordon_PracticeObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee meyers = new Employee ("Susan Meyers", 47899, "Accounting", "Vice President");
        System.out.println(meyers.getName() + "\t" + meyers.getIdNumber() + "\t" + meyers.getDepartment() + "\t" + meyers.getPosition());
        Employee jones = new Employee ("Mark Jones", 39119, "IT", "Programmer");
        System.out.println(jones.getName() + "\t" + jones.getIdNumber() + "\t" + jones.getDepartment() + "\t\t" + jones.getPosition());
        Employee rogers = new Employee ("Joy Rogers", 81774, "Manufacturing", "Engineer");
        System.out.println(rogers.getName() + "\t" + rogers.getIdNumber() + "\t" + rogers.getDepartment() + "\t" + rogers.getPosition());
    }
    
}

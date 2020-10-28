/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gordon_practiceobjects;

/**
 *
 * @author Maureen Gordon
 */
public class Employee {
    //employee fields in private access
    private String name;
    private int idNumber;
    private String department;
    private String position;
    
  /*constructor that has exact arguments and assigned values for name, IdNumber,
     *department and postion*/  
    public Employee (String nme, int idN, String dept, String post) 
    {
        name = nme;
        idNumber = idN;
        department = dept;
        position = post;
    }
     /*constructor that has exact arguments and assigned values for name, IdNumber,
     *and open values for department and postion*/
    public Employee (String nme, int idN) 
    {
        name = nme;
        idNumber = idN;
        department = "";
        position = "";
        
    }
     /*constructor that has no arguments and has no assigned values for name, IdNumber,
     *department and postion*/
    public Employee () 
    {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }
    //getters and setters method in public access are below for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}

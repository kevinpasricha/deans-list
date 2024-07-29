import java.util.Scanner;

public class StudentRecord {
    private String firstName;
    private String lastName;
    private int year; // Year of graduation
    private double gpa;
    
    // Accessors
    public String getFirstName()  {
        return firstName;
    }
    
    public String getLastName()  {
        return lastName;
    }
    
    public int getYear()  {
        return year;
    }
    
    public double getGpa()  {
        return gpa;
    }
    
    // Mutators
    public void setFirstName(String fn)  {
        firstName = fn;
    }
    
    public void setLastName(String ln)  {
        lastName = ln;
    }
    
    public void setYear(int yr)  {
        year = yr;
    }
    
    public void setGpa(double gpAv)  {
        gpa = gpAv;
    }
}


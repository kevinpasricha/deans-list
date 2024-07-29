import java.util.Scanner;

public class StudentRecords{
    public final int maxStudents = 15;
    private int numStudents;
    public StudentRecord[] students;
    
    public StudentRecords()  {
        students = new StudentRecord[maxStudents];
        for  (int i = 0;  i < maxStudents;  i++)
            students[i] = new StudentRecord();
        
        //Initially, no student records have been
        // entered
        numStudents = 0;
    }
    
    //ReadRecords() - Read in the input records
    public int readRecords()  {
        Scanner keyb = new Scanner(System.in);
        String inString = new String();
        int newYear;
        double newGPA;
        
        //Tell the user how to end the input
        System.out.println("Enter \"end\" to indicate no more students");
        
        // For each student, input the first and last
        // name, year of graduation and grade point
        // average
        for  (numStudents = 0; numStudents < maxStudents; numStudents++) {
            System.out.println("First name\t?");
            inString = keyb.next();
            
            //If they entered "end", there aren't any
            // more  records
            if (inString.equals("end"))
            break;
            
            students[numStudents].setFirstName(inString.trim());
            System.out.print("Last name\t?");
            inString = keyb.next();
            students[numStudents].setLastName(inString.trim());
            
            System.out.println("Year\t?");
            newYear = keyb.nextInt();
            students[numStudents].setYear(newYear);
            
            System.out.println("Grade point average\t?");
            newGPA = keyb.nextDouble();
            students[numStudents].setGpa(newGPA);
        }
        return numStudents;
    }
    
    //WriteRecord() - Enter the student record
    public void writeRecord(int index)  {
        // Make sure that all significant places print
        //Print the record, using four spaces for year
        // and gpa
        System.out.println(students[index].getFirstName() + "\t"
                         + students[index].getLastName() + "\t"
                         + students[index].getYear() + "\t"
                         + students[index].getGpa());
    }
}

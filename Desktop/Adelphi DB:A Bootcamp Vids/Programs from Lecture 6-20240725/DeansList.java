import java.util.Scanner;

// DeansList() - Read Student records and print
//               the Data on studetns on the
//               Dean's List
public class DeansList  {
    public static void main(String[]args)  {
        StudentRecords stud = new StudentRecords();
        int            i, numStudents = 0;
        
        //Input the data
        numStudents = stud.readRecords();
        
        //Print the data for students with
        // gpa's of 3.5 or higher
        for  (i = 0;  i < numStudents;  i++)
            if (stud.students[i].getGpa() >= 3.5)
                stud.writeRecord(i);
    }
}


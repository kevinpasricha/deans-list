// Class for a person with a name and dates for
// birth and death.
// Class invariant - A Person always has a date
//                   of birth and if there is a
//                   date of birth it precede the
//                   date of birth
public class Person  {
    private String name;
    private Date born;
    private Date died;  // null indicates still
                        // alive
                      
    // Person() - This constructor initializes the
    //            Date objects uses their copy
    //            constructor.
    public Person(String initName, Date birthDate, Date deathDate)  {
        if (consistent(birthDate, deathDate))  {
            name = initName;
            born = new Date(birthDate);
            if (deathDate == null)
                died = null;
            else
                died = new Date(deathDate);
        }
        else  {
            System.out.println("Inconsistent dates.  Aborting.");
            System.exit(0);
        }
    }
    
    // Person() - A copy constructor for Person
    public Person(Person original)  {
        // It is essential that we determine if the
        // original object exists by seeing if its
        // reference is null or not.
        if (original == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        name = original.name;
        born = new Date(original.born);
        
        // If we had written born = original.born
        // it would be an example of a privacy leak
        if (original.died == null) // Not a problem
            died = null;
        else
            died = new Date(original.died);
    }
    
    // toString() - converts the data into a String
    public String toString()  {
        // First, let's see if there is a date of
        // death
        String diedString;
        if (died == null)  
            diedString = ""; // Empty string
        else
            diedString = died.toString();
        
        // born is converted using Date.toString()
        return(name + ", " + born + "-" + diedString);
    }
    
    // equals() - Returns true if the person's date
    //            matches this object.
    //            Returns false if not
    public boolean equals(Person otherPerson)  {
        if (otherPerson == null)
            return false;
        else
            // We use equals for born because it cannot
            // be null.  We use datesMatch for died
            // because it migt be null
            return (name.equals(otherPerson.name)
                  && born.equals(otherPerson.born)
                  && datesMatch(died, otherPerson.died));
    }
    
    // datesMatch() -Returns true if the dates are
    //                the same or if they are both
    //                null.
    //                Returns false if not.
    private static boolean datesMatch (Date date1, Date date2)  {
        if (date1 == null)
            return(date2 == null); 
        else if (date2 == null)  // and date1 != null
            return false; 
        else // both dates are NOT null
            return(date1.equals(date2));
    }
    
    // setBirthDate(DatenewDate) -A mutator for
    //                            born
    //   Precondition: newDateis a consistent date
    //                 of birth 
    // Postcondition: Date of birth of the calling 
    //                object is newDate
    public void setBirthDate(Date newDate)  {
        if (consistent(newDate, died)) 
            born = new Date(newDate);
        else { 
            System.out.println ("Inconsistent dates.  Aborting."); 
            System.exit(0);
        }
    }
    
    // setDeathDate() - A mutator for deathDate
    public void setDeathDate(Date newDate)  {
        if (!consistent(born, newDate))  {
            System.out.println("Inconsistent dates.  Aborting.");
            System.exit(0);
        }
        
        // A null date of death is valid.  This is
        // different from setBirthDate because
        // birthDate cannot be null.
        if (newDate == null)
            died = null;
        else
            died = new Date(newDate);
    }
    
    // setName() - A mutator for name
    //   Precondition: name cannot be null
    public void setName(String newName) {
        name = newName;
    }
    
    // getName() - An accessor for name
    public String getName() {
        return name;
    }
    
    // getBirthDate() - An accessor for birthDate
    public Date getBirthDate() {
        return new Date(born);
    }
    
    // setBirthYear - A mutator for the person's
    //                year of birth
    //  Precondition: the date of birth has been
    //       set and changing the year will give
    //       consistent date of birth.
    //  Postcondition: The year of birth is newYear
    public void setBirthYear(int newYear) {
        if (born == null)  {
            // Precondition is violated
            System.out.println("Fatal error.  Aborting.");
            System.exit(0);
        }
        
        born.setYear(newYear);
        if (!consistent(born, died))  {
            System.out.println("Inconsistent dates.  Aborting.");
            System.exit(0);
        }
    }
    
    // setDeathYear - A mutator for the person's
    //                year of death
    //  Precondition: the date of death has been
    //        set and changing the year will give
    //        consistent date of death.
    //  Postcondition: The year of death is newYear
    public void setDeathYear(int newYear)   {
        if (died == null)  {
            // Precondition is violated
            System.out.println("Fatal error.  Aborting.");
            System.exit(0);
        }
        
        died.setYear(newYear);
        if (!consistent(born, died))  {
            System.out.println("Inconsistent dates.  Aborting.");
            System.exit(0);
        }
    }
    
    // getDeathDate() - An accessor for deathDate
    //                  We must ensure that it
    //                  exists; else return null
    public Date getDeathDate() {
        if (died == null)
            return null;
        else
            return new Date(died);
    }
    
    // To be consistent birthDate must not be null.
    // If there is no date of death
    // (deathDate == null), that is consistent with
    // any birthDate.  Otherwise, the birthDate
    // must come before or be equal to the
    // deathDate.
    private static boolean consistent(Date birthDate, Date deathDate) {
        if (birthDate == null)
            return false;
        else if (deathDate == null)
            return true;
        else
            return(birthDate.precedes(deathDate)
                || birthDate.equals(deathDate));
    }
}
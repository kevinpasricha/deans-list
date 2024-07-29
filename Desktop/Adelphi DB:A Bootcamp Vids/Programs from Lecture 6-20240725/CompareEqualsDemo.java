public class CompareEqualsDemo  {
  public static void main(String[] args)  {
    ToyClass object1 = new ToyClass("Slinky", 31),
             object2 = new ToyClass("Slinky", 31);
    
    if (object1 == object2)
      System.out.println("Equal using \"==\"");
    else
      System.out.println("Not equal using \"==\"");

    if (object1.equals(object2))
      System.out.println("Equal using \"equals\"");
    else
      System.out.println
            ("Not equal using \"equals\"");
  }
}

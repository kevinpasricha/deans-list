public class TestToyClass {
  public static void main(String[] args)  {
    ToyClass variable1 = new ToyClass("Joe", 42);
    ToyClass variable2;
    variable2 = variable1;
    // Now both variables name the same object.
    variable2.set("Josephine", 1);
    System.out.println(variable1);
  }
}
/**
 * Auto Generated Java Class.
 */
public class Person {
  
  private boolean status;//whether the person is a student or a teacher
  private String name = "";
  private int personNum;
  
  public Person(String name, int num) {
    this.name = name;
    this.personNum = num;
  }
    public Person(String name) {
    this.name = name;
  }
    
    public String getName(){
      return this.name;
    }
  
}

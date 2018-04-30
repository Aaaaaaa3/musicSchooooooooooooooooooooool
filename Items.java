
/**
 * Template for insturments, equipment and sheet music
 */
public class Items {
  private boolean condition;
  private String name;
  private String descr;
  private String num;
  
  private Person stu;
  private String dueDate;//change into appropriate thing later
  
  /********************************************************* the constructors ***********************************************/
  //default constructor
  public Items() { 
    }
  
  public Items(boolean condition, String name, String description, String num){
    this.condition = condition;
    this.name = name;
    this.descr = description;
    this.num = num;
  }
  /********************************************************* the get methods ***********************************************/
  public boolean getCondition(){
    return this.condition;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getDescr(){
    return this.descr;
  }
  
  public String getNum(){
    return this.num;
  }
  
  public Person getPerson(){
    return this.stu;
  }
  
  public String getDate(){
    return this.dueDate;
  }
  /********************************************************* the set methods ***********************************************/
  
  public void setPerson(Person student){
    this.stu = student;
  }
  
}

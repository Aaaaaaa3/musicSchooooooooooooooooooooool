/**
 * Template for insturments, equipment and sheet music
 */

public class Items {
  private boolean condition;
  private String name;
  private String descr = "";
  private String num;
  
  private Person stu;
  private String dueDate;//change into appropriate thing later
  
  /********************************************************* the constructors ***********************************************/
  //default constructor
  public Items() { 
  }
  
  public Items(String name, boolean condition, String num){
    this.condition = condition;
    this.name = name;
    this.num = num;
  }
  
  public void display(){
    
    System.out.println("Name: " + this.name);
    System.out.println("Num: " + this.num);
    System.out.println("Condition: " + this.condition);
    System.out.println("Description: "+ this.descr);
    if(this.stu != null){
      System.out.println("Student: " + this.stu.getName());
//      Date date = new Date();
//      System.out.println("Due date: " + this.dueDate.format(date));
      System.out.println("Due date: " + this.dueDate);
    }
    
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
  
  public void setDescr(String descr){
    this.descr = descr;
  }
  
  public void setDate(String date){
    this.dueDate = date;
  }
  
}

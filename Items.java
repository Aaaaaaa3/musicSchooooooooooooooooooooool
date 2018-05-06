/**
 * Template for insturments, equipment and sheet music
 */

public class Items {
  private boolean condition;
  private String name;
  private String descr = "";
  private String num;
  
  private int stu = -1;
  private String dueDate = "2019-01-01";//change into appropriate thing later
  
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
    if(this.stu != -1){
      System.out.println("Student: " + this.stu);
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
  
  public int getPerson(){
    return this.stu;
  }
  
  public String getDate(){
    return this.dueDate;
  }
  /********************************************************* the set methods ***********************************************/
  
  public void setPerson(int student){
    this.stu = student;
  }
  
  public void setDescr(String descr){
    this.descr = descr;
  }
  
  public void setDate(String date){
    this.dueDate = date;
  }
  
}
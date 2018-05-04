/*
 */
import java.io.*;
public class Output {
  public static void printFile(DoubleLinkedList<Items> array){
    try{
      PrintWriter printOut = new PrintWriter ("file.txt");
      for (int i=0; i<array.size(); i++){
        printOut.println("Name: " + array.get(i).getName());
        printOut.println("Num: " + array.get(i).getNum());
//        printOut.println("Condition: " + array.get(i).getCondition());
//        printOut.println("Description: " + array.get(i).getDescr());
        if (array.get(i).getStu()!=null){
          printOut.println("Student: " + array.get(i).getStu());
          printOut.println("Due Date: " + array.get(i).getDueDate());
        }
        else{
          printOut.println("Available");
        }
        printOut.println("");
      }
      printOut.close();
    }
    catch (Exception e){
      System.out.println ("Error!");
    }
  }
  
  public static void main(String[] args) { 
  } 
}

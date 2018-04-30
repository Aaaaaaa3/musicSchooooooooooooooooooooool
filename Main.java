/**
 * Read in the file
 * Add and remove students
 */
import java.io.*;
import java.util.Scanner;

public class Main {
  
  
  public static void main(String[] args) { 
    
    try {
      File file = new File("Tasha.txt");
      Scanner input = new Scanner(file);
      
      while (input.hasNext()){
        System.out.println(input.nextLine());
      }
    }
    catch(Exception E){
      System.out.println("Error 1");
    }
  }
  
}

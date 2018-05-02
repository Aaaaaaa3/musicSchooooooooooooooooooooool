/**
 * Read in the file
 * Add and remove students
 * 
 * Finished: txt file read in (not yet saved to list)
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) { 
    
    try {
      File file = new File("Tasha.txt");
      Scanner fileInput = new Scanner(file);
      
      while (fileInput.hasNext()){
        String temp = fileInput.nextLine();
        Scanner stringInput = new Scanner(temp);
        
        Items tempItem = new Items(stringInput.next(), stringInput.nextBoolean(),
                                   stringInput.next());
        String tempTemp = stringInput.next();
        //if it has a student
        if (tempTemp.charAt(0) != '"'){
          Person tempStu = new Person(tempTemp);
          tempItem.setPerson(tempStu);
          
          SimpleDateFormat tempDate = new SimpleDateFormat(stringInput.next());
          tempItem.setDate(tempDate);
        }
        //set description
         tempItem.setDescr(temp.substring(temp.indexOf('"')+1));       
        tempItem.display();
        System.out.println();
      }
    }
    catch(Exception E){
      System.out.println("Error 1");
    }
  }
  
}
/*Txt file format:
 * Name condition(0/1) number description student dueDate
 */

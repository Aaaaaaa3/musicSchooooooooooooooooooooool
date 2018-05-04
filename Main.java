/**
 * Read in the file
 * Add and remove students
 * 
 * Finished: txt file read in & saved to list
 * 
 * Add in: proper student/due date
 * 
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class Main {
  
  //reads in students from txt
  public static DoubleLinkedList<Person> readStudents (){
    DoubleLinkedList<Person> students = new DoubleLinkedList<Person>();
    try{
      Scanner read = new Scanner (new File ("students.txt"));
      while (read.hasNextLine()){
        Person newPerson = new Person();
        newPerson.setNum(read.nextInt());
        newPerson.setName(read.nextLine());
        students.add(newPerson);
      }
    }
    catch(Exception e){
    }
    System.out.println ("DONE");
    return students;
  }
  //reads in items from txt
  public static DoubleLinkedList<Items> readItems(){
      DoubleLinkedList<Items> list = new DoubleLinkedList<Items>();
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
          
          tempItem.setDate(stringInput.next());
        }
        //set description
        tempItem.setDescr(temp.substring(temp.indexOf('"')+1));       
        list.add(tempItem);
        
      }
    }
    catch(Exception E){
      System.out.println("Error 1");
    }
    return list;
}
  //returns the searched student
  public Person checkStudent (int num, DoubleLinkedList<Person> students){
    int index=0;
    while (index < students.size()){
      if (num==students.get(index).getNum()){
        return students.get(index);
      }
      index++;
    }
    return null;
  }
  //returns the searched item
    public static Items checkItem (String input, DoubleLinkedList<Items> list){
      for (int i = 0; i<list.size(); i++){
      if (input.equals(list.get(i).getName())){
        return list.get(i);
      }
    }
    return null;
  }
  
  public static void main(String[] args) { 
    
//read in the files----------------------------------
DoubleLinkedList<Items> list = readItems();
DoubleLinkedList<Person> students = readStudents();
  for (int i = 0; i< list.size(); i++){
      Items temp = list.get(i);
      temp.display();
      System.out.println();
    }
    
     for (int i=0; i<students.size(); i++){
       System.out.println (students.get(i).getNum());
     }
//------------------------------------------------------------------------
  
    Scanner input = new Scanner(System.in);
    while (true){
      System.out.println("Press 1 to sign out, press 2 to sign in");
      String temp = input.nextLine();
      if (temp.equals("1")){
        System.out.println("What do you want to sign out?");
        temp = input.nextLine();
        Items tempTemp = checkItem(temp, list);
        Person tempStu = new Person("312106534645345315");
        tempTemp.setPerson(tempStu);
        tempTemp.setDate("2018/6/3");
        
            for (int i = 0; i< list.size(); i++){
      Items temp3 = list.get(i);
      temp3.display();
      System.out.println();
    }
      }
      else if (temp.equals("2")){
      }
    }
  }
  
}
/*Txt file format:
 * Name condition(0/1) number description student dueDate
 */

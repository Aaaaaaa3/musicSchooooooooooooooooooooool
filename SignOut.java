/* SignOut.java
 * Julia Zhao and Tasha Xiao
 * May 02 2018 
 * Version 1.0.0
 * Interface to sign out
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignOut extends JPanel{
  JFrame frame = new JFrame ("Music Sign Out");
  JTextField studentNum1 = new JTextField("Student number");
  JTextField studentNum2 = new JTextField("Student number");
  JTextField studentNum3 = new JTextField("Student number");
  JTextField instrument = new JTextField("Instrument");
  JTextField sheetMusic = new JTextField ("Sheet Music");
  JTextField equipment = new JTextField ("Equipment");
  
  public SignOut(){ //constructor
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    //super(new GridLayout(1, 1));
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel instrumentPanel = new JPanel();
    JPanel sheetPanel = new JPanel();
    JPanel equipmentPanel = new JPanel();
    
    
    JCheckBox condition1 = new JCheckBox("Good condition?");
    JCheckBox condition2 = new JCheckBox("Good condition?");
    JCheckBox condition3 = new JCheckBox("Good condition?");
    JButton signOut1 = new JButton ("Sign Out");
    JButton signOut2 = new JButton ("Sign Out");
    JButton signOut3 = new JButton ("Sign Out");
    
    signOut1.addActionListener(new Listener1());
    
    instrumentPanel.add(studentNum1);
    instrumentPanel.add(instrument);
    instrumentPanel.add(condition1);
    instrumentPanel.add(signOut1);
    
    sheetPanel.add(studentNum2);
    sheetPanel.add(sheetMusic);
    sheetPanel.add(condition2);
    sheetPanel.add(signOut2);
    
    equipmentPanel.add(studentNum3);
    equipmentPanel.add(equipment);
    equipmentPanel.add(condition3);
    equipmentPanel.add(signOut3);
    
    tabbedPane.addTab("Instrument", instrumentPanel);
    tabbedPane.addTab("Sheet Music", sheetPanel);
    tabbedPane.addTab("Equipment", equipmentPanel);
    
    frame.add(tabbedPane); 
    frame.setVisible(true);
  }
  
  class Listener1 implements ActionListener{
    public void actionPerformed(ActionEvent event){
      //get the information from the field
      String name = instrument.getText();
      //check if item is found
      Items item = MusicResource.checkItem(name, MusicResource.getItems());
      if (item==null){
        MenuGUI.createPopUp("Item not found in database!");
      }
      else{
        //check if item is out on repairs
        if (item.getCondition()==false){
          MenuGUI.createPopUp("Out to repairs. Cannot be signed out.");
        }
        else{
          String idNumber = studentNum1.getText();
          //check if item is already signed out by a different user
          if (item.getPerson() !=-1 && item.getPerson()!=Integer.parseInt(idNumber)){
            MenuGUI.createPopUp("Already signed out by someone else!");
          }
          else{
            Person student = MusicResource.checkStudent(Integer.parseInt(idNumber), MusicResource.getStudents());
            if (student==null){
              MenuGUI.createPopUp("Sorry, your student number isn't in the database!");
            }
            else{
              item.setPerson(student.getNum());
              //finds current date
              String tempDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
              //increases day by 1
              item.setDate(LocalDate.parse(tempDate).plusDays(1).toString());
            }
          }
        }
      }
    }
  }
 
  public static void main(String [] args){
    new SignOut();
  }
  
}

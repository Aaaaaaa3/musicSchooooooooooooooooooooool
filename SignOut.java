/* SignOut.java
 * Julia Zhao and Tasha Xiao
 * May 02 2018 
 * Version 1.0.0
 * Interface to sign out an object
 */

import java.awt.event.*; //imports
import javax.swing.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignOut extends JPanel{
  //components of the GUI
  JFrame frame = new JFrame ("Music Sign Out");
  JTabbedPane tabbedPane = new JTabbedPane();
  JTextField studentNum1 = new JTextField("Student number");
  JTextField studentNum2 = new JTextField("Student number");
  JTextField studentNum3 = new JTextField("Student number");
  JTextField instrument = new JTextField("Instrument");
  JTextField instrNum = new JTextField("Instrument Number");
  JTextField sheetMusic = new JTextField ("Sheet Music");
  JTextField sheetNum = new JTextField("Sheet Number");
  JTextField equipment = new JTextField ("Equipment");
  JTextField equipNum = new JTextField("Equipment Number");
  
  public SignOut(){ //constructor
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300); //sets size of frame
    //Print to file once the window is closed
    frame.addWindowListener(new WindowAdapter(){ //overrides original (default) method of the window closing
      public void windowClosing(java.awt.event.WindowEvent windowEvent){
        MusicResource.printFile(MusicResource.getItems());
      }
    });
    JPanel instrumentPanel = new JPanel();
    JPanel sheetPanel = new JPanel();
    JPanel equipmentPanel = new JPanel();
    
    JButton signOut1 = new JButton ("Sign Out");
    JButton signOut2 = new JButton ("Sign Out");
    JButton signOut3 = new JButton ("Sign Out");
    
    signOut1.addActionListener(new SignOutListener());
    signOut2.addActionListener(new SignOutListener());
    signOut3.addActionListener(new SignOutListener());
    
    //add components onto the panels
    instrumentPanel.add(studentNum1);
    instrumentPanel.add(instrument);
    instrumentPanel.add(instrNum);
    instrumentPanel.add(signOut1);
    
    sheetPanel.add(studentNum2);
    sheetPanel.add(sheetMusic);
    sheetPanel.add(sheetNum);
    sheetPanel.add(signOut2);
    
    equipmentPanel.add(studentNum3);
    equipmentPanel.add(equipment);
    equipmentPanel.add(equipNum);
    equipmentPanel.add(signOut3);
    
    //adds a new tab
    tabbedPane.addTab("Instrument", instrumentPanel);
    tabbedPane.addTab("Sheet Music", sheetPanel);
    tabbedPane.addTab("Equipment", equipmentPanel);
    
    //add tabbedPane onto frame and set to visible
    frame.add(tabbedPane); 
    frame.setVisible(true);
  } 
  //inner class (action listener)
  class SignOutListener implements ActionListener{
    /* actionPerformed method
     * Runs if the sign out button is pressed
     * @param event - the action that is performed
     */
    public void actionPerformed(ActionEvent event){
      String name="";
      String idNumber="";
      //get the information from the field
      if (tabbedPane.getSelectedIndex()==0){ //instrument tab
        name=instrument.getText(); //gets value from specified text field
        idNumber = studentNum1.getText(); 
      }
      else if (tabbedPane.getSelectedIndex()==1){//sheet music tab
        name = sheetMusic.getText();
        idNumber = studentNum2.getText();
      }
      else{ //equipment tab
        name = equipment.getText();
        idNumber = studentNum3.getText();
      }
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
        else{ //item is in good condition
          if (isInt(idNumber)==true){
            //check if item is already signed out by a different user
            if (item.getPerson() !=-1 && item.getPerson()!=Integer.parseInt(idNumber)){
              MenuGUI.createPopUp("Already signed out by someone else!");
            }
            else{ //item may be signed out
              Person student = MusicResource.checkStudent(Integer.parseInt(idNumber), MusicResource.getStudents());
              if (student==null){
                MenuGUI.createPopUp("Sorry, your student number isn't in the database!");
              }
              else{ //student number is valid
                item.setPerson(student.getNum());
                //finds current date
                String tempDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
                //increases day by 1
                item.setDate(LocalDate.parse(tempDate).plusDays(1).toString());
                MenuGUI.createPopUp("Successfully signed out!");
              }
            }
          }
          else{
            MenuGUI.createPopUp("Please make sure the student number only has numbers!");
          }
        }
      }
    }
  }
  
  /* isInt method
   * Checks if the given string contains only numbers
   * @param str - string to check
   * @return valid - boolean value, only numbers=true
   */
  public boolean isInt(String str){
    boolean valid = true;
    int i=0;
    do{ //loop while you haven't reached the end of the string and valid is true
      if (!Character.isDigit(str.charAt(i))){ //not a digit
        valid=false; //string does not only contain digits
      }
      i++;
    }while (valid==true && i<str.length());
    return valid;
  }
  
  public static void main(String [] args){
    new SignOut();
  }
}
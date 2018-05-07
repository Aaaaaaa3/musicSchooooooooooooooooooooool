/* MenuGUI.java
 * Julia Zhao and Tasha Xiao
 * May 02 2018
 * Version 1.0.0
 * GUI program for the menu
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuGUI extends JPanel implements ActionListener{
  JFrame frame = new JFrame ("Music Sign Out");
  JButton teacher = new JButton ("Teacher");
  JButton student = new JButton ("Student");
  JButton inventory = new JButton ("Inventory");
  JButton quit = new JButton ("QUIT");
  
  public MenuGUI(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    JPanel panel = new JPanel (new FlowLayout ());
    JLabel label = new JLabel ("What would you like to do?");
    
    teacher.addActionListener(this);
    student.addActionListener(this);
    inventory.addActionListener(this);
    quit.addActionListener(this);
    
    panel.add(label);
    panel.add(teacher);
    panel.add(student);
    panel.add(inventory);
    panel.add(quit);
    frame.add(panel);
    
    frame.setVisible(true);
  }
  
  public static void createPopUp(String msg){
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel (msg);
    
    panel.add(label);
    frame.add(panel);
    
    frame.setSize(400, 100);
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==student){ //student button is clicked
      new StudentGUI();
    }
    else if(e.getSource()==teacher){
     //TeacherGUI.run(items);
    }
    else {//clicked "QUIT"
      MusicResource.printFile(MusicResource.getItems());
      //thank you
      System.exit(0);
    }
    this.setVisible(false);
    frame.dispose();
  }
  
  public static void main(String[]args){
    new MenuGUI();
  }
  
}

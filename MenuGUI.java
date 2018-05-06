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
  JButton teacher = new JButton ("Teacher");
  JButton student = new JButton ("Student");
  JButton inventory = new JButton ("Inventory");
  JButton quit = new JButton ("QUIT");
  
  public MenuGUI(){
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
    add(panel);
  }
  
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==student){ //student button is clicked
      new StudentGUI();
    }
    else if(e.getSource()==teacher){
     //TeacherGUI.run(items);
    }
    else {//clicked "QUIT"
      System.exit(0);
    }
    this.setVisible(false);
    ((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
  }
  
  public static void run(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new MenuGUI(), BorderLayout.CENTER);
    frame.setSize(400,300);
    frame.setVisible(true);
    
  }
  
}

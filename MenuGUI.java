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
  JButton lol = new JButton ("An idiot sandwich");
  JButton quit = new JButton ("QUIT");
  
  public MenuGUI(){
    JPanel panel = new JPanel (new FlowLayout ());
    JLabel label = new JLabel ("What are you?");
    
    teacher.addActionListener(this);
    student.addActionListener(this);
    quit.addActionListener(this);
    
    panel.add(label);
    panel.add(teacher);
    panel.add(student);
    panel.add(lol);
    panel.add(quit);
    add(panel);
  }
  
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==student){ //student button is clicked
      StudentGUI.run();
    }
    else if(e.getSource()==teacher){
    }
    else {//clicked "QUIT"
      System.exit(0);
    }
  }
  
  public static void main(String [] args){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new MenuGUI(), BorderLayout.CENTER);
    frame.setSize(400,300);
    frame.setVisible(true);
    
  }
  
}

/* SignOut.java
 * Julia Zhao and Tasha Xiao
 * May 02 2018 
 * Version 1.0.0
 * Interface to sign out
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignOut extends JPanel{
  public SignOut(){ //constructor
    super(new GridLayout(1, 1));
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel instrumentPanel = new JPanel();
    JPanel sheetPanel = new JPanel();
    JPanel equipmentPanel = new JPanel();
    JPanel alertPanel = new JPanel();
    
    JTextField studentNum1 = new JTextField("Student number");
    JTextField studentNum2 = new JTextField("Student number");
    JTextField studentNum3 = new JTextField("Student number");
    JTextField instrument = new JTextField("Instrument");
    JTextField sheetMusic = new JTextField ("Sheet Music");
    JTextField equipment = new JTextField ("Equipment");
    JLabel alerts = new JLabel ("OVERDUE");
    
    JCheckBox condition1 = new JCheckBox("Good condition?");
    JCheckBox condition2 = new JCheckBox("Good condition?");
    JCheckBox condition3 = new JCheckBox("Good condition?");
    JButton signOut1 = new JButton ("Sign Out");
    JButton signOut2 = new JButton ("Sign Out");
    JButton signOut3 = new JButton ("Sign Out");
    
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
    
    alertPanel.add(alerts);
    
    tabbedPane.addTab("Instrument", instrumentPanel);
    tabbedPane.addTab("Sheet Music", sheetPanel);
    tabbedPane.addTab("Equipment", equipmentPanel);
    tabbedPane.addTab("Overdue", alertPanel);
    
    add(tabbedPane); 
  }
  
  public static void run(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new SignOut(), BorderLayout.CENTER);
    frame.setSize(400,300);
    frame.setVisible(true);
  }
  
}

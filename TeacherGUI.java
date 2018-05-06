/* TeacherGUI.java
 * Julia Zhao and Tasha Xiao
 * May 02 2018
 * Version 1.0.0
 * GUI program for the teacher
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TeacherGUI extends JPanel{
  JFrame frame = new JFrame ("Music Sign Out");
  public TeacherGUI(DoubleLinkedList<Items> items){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    //super(new GridLayout(1, 1));
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel panel = new JPanel();
    JLabel[] label=new JLabel[items.size()];
    
    for (int i=0; i<items.size(); i++){  
      label[i]=new JLabel (items.get(i).getName() + items.get(i).getDate() + items.get(i).getPerson());
      panel.add(label[i]);
    } 
    tabbedPane.addTab("Items by Due Date", panel);
    
    frame.add(tabbedPane); 
    frame.setVisible(true);
  }
  
  public static void run (DoubleLinkedList<Items> items){
    new TeacherGUI(items);
  }
}
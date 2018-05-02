/* tabbed pane
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JPanel{
  public GUI(){ //constructor
    super(new GridLayout(1, 1));
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel instrumentPanel = new JPanel();
    JPanel sheetPanel = new JPanel();
    JPanel equipmentPanel = new JPanel();
    
    JTextField firstName1 = new JTextField("First name");
    JTextField lastName1 = new JTextField("Last name");
    JTextField firstName2 = new JTextField("First name");
    JTextField lastName2 = new JTextField("Last name");
    JTextField firstName3 = new JTextField("First name");
    JTextField lastName3 = new JTextField("Last name");
    JTextField instrument = new JTextField("Instrument");
    JTextField sheetMusic = new JTextField ("Sheet Music");
    JTextField equipment = new JTextField ("Equipment");
    JCheckBox condition1 = new JCheckBox("Good condition?");
    JCheckBox condition2 = new JCheckBox("Good condition?");
    JCheckBox condition3 = new JCheckBox("Good condition?");
    JButton signOut1 = new JButton ("Sign Out");
    JButton signOut2 = new JButton ("Sign Out");
    JButton signOut3 = new JButton ("Sign Out");
    
    instrumentPanel.add(firstName1);
    instrumentPanel.add(lastName1);
    instrumentPanel.add(instrument);
    instrumentPanel.add(condition1);
    instrumentPanel.add(signOut1);
    
    sheetPanel.add(firstName2);
    sheetPanel.add(lastName2);
    sheetPanel.add(sheetMusic);
    sheetPanel.add(condition2);
    sheetPanel.add(signOut2);
    
    equipmentPanel.add(firstName3);
    equipmentPanel.add(lastName3);
    equipmentPanel.add(equipment);
    equipmentPanel.add(condition3);
    equipmentPanel.add(signOut3);
    
    tabbedPane.addTab("Instrument", instrumentPanel);
    tabbedPane.addTab("Sheet Music", sheetPanel);
    tabbedPane.addTab("Equipment", equipmentPanel);
    
    add(tabbedPane); //add tabbed pane to this panel
  }
  
  public static void main(String [] args){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new GUI(), BorderLayout.CENTER);
    frame.setSize(400,300);
    frame.setVisible(true);
  }
}

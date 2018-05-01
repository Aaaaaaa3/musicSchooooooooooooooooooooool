//gui for project
//rename variables
//card layout
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ItemListener{
  JFrame frame = new JFrame("Music Resource Sign Out"); //new frame
  JPanel cards = new JPanel(new CardLayout());
  final String INSTRUMENTS = "Instrument"; //the options in the drop down menu
  final String SHEETS = "Sheet Music";
  final String EQUIPMENT = "Equipment";
  JPanel comboBoxPane = new JPanel();
  
  public void itemStateChanged(ItemEvent evt) {
    CardLayout cl = (CardLayout)(cards.getLayout());
    cl.show(cards, (String)evt.getItem());
  }
      
  public void main(String[] args) { 
    cards.setPreferredSize(new Dimension(300, 500));
    comboBoxPane.setSize(100, 100);
    
    //drop down menu
    String comboBoxItems[] = {INSTRUMENTS, SHEETS, EQUIPMENT};
    JComboBox cb = new JComboBox(comboBoxItems);
    cb.addItemListener(this);
    comboBoxPane.add(cb);
    
    JPanel card1 = new JPanel(new GridLayout(2,4));
    card1.add(new JLabel("First name:"));
    card1.add(new JTextField());
    card1.add(new JLabel("Last name:"));
    card1.add(new JTextField());
    card1.add(new JLabel("Instrument:"));
    card1.add(new JTextField());
    card1.add(new JLabel("Condition"));
    card1.add(new JTextField());
    
    JPanel card2 = new JPanel(new GridLayout(2,4));
    card2.add(new JLabel("First name:"));
    card2.add(new JTextField());
    card2.add(new JLabel("Last name:"));
    card2.add(new JTextField());
    card2.add(new JLabel("Instrument:"));
    card2.add(new JTextField());
    card2.add(new JLabel("Condition"));
    card2.add(new JTextField());
    JPanel card3 = new JPanel();
    
    //Create the panel that contains the cards.
    cards.add(card1, INSTRUMENTS);
    cards.add(card2, SHEETS);
    cards.add(card3, EQUIPMENT);
    //add panels onto frame
    frame.add(cards,BorderLayout.CENTER);
    frame.add(comboBoxPane, BorderLayout.PAGE_START);
    
    //set to visible
    frame.setVisible (true);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);
  }  
}

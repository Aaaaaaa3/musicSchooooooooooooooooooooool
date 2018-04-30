//gui for project
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI{
  public static void main(String[] args) { 
    JFrame frame = new JFrame("Music Resource Sign Out");
    JPanel cards;
    final String BUTTONPANEL = "Instrument";
    final String TEXTPANEL = "Sheet Music";
    
    JPanel comboBoxPane = new JPanel();
    String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
    JComboBox cb = new JComboBox(comboBoxItems);
    comboBoxPane.add(cb);
    
    JPanel card1 = new JPanel();
    card1.add(new JButton("SIGN OUT"));
    JPanel card2 = new JPanel();
    card2.add(new JTextField("First name", 10));
    card2.add(new JTextField("Last name", 10));
    card2.add(new JTextField("Instrument", 10));
    card2.add(new JTextField("Condition", 10));
    
    //Create the panel that contains the "cards".
    cards = new JPanel(new CardLayout());
    cards.add(card1, BUTTONPANEL);
    cards.add(card2, TEXTPANEL);
    frame.add(cards);
    frame.add(comboBoxPane);
    //set to visible
    frame.setVisible (true);
    comboBoxPane.setVisible(true);
    cb.setVisible(true);
    cards.setVisible(true);
    card1.setVisible(true);
    card2.setVisible(true);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);
  }  
}

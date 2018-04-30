//gui for project
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI{
  public static void main(String[] args) { 
    JFrame frame = new JFrame("Music Resource Sign Out");
    JPanel cards;
    final String BUTTONPANEL = "JPanel with JButtons";
    final String TEXTPANEL = "JPanel with JTextField";
    
    JPanel comboBoxPane = new JPanel();
    String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
    JComboBox cb = new JComboBox(comboBoxItems);
    comboBoxPane.add(cb);
    
    JPanel card1 = new JPanel();
    card1.add(new JButton("Button 1"));
    JPanel card2 = new JPanel();
    card2.add(new JTextField("TextField", 20));
    
    //Create the panel that contains the "cards".
    cards = new JPanel(new CardLayout());
    cards.add(card1, BUTTONPANEL);
    cards.add(card2, TEXTPANEL);
    frame.add(cards);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    
    //set to visible
    frame.setVisible (true);
    cards.setVisible(true);
    card1.setVisible(true);
    card2.setVisible(true);
  }  
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Recent {
  public Recent(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setSize(400,300);
    JPanel panel = new JPanel ();
    JLabel label = new JLabel ("Recent sign outs:");
    
    panel.add(label);
    frame.add(panel);
    frame.setVisible(true);
  }
  
}

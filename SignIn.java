import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignIn {
  JLabel confirm = new JLabel ("The database has been updated!");   
  JFrame frame = new JFrame("Music Sign Out");
  //confirm.setVisible(false);
  public SignIn(){
    frame.setSize (400,300);
    JPanel panel = new JPanel();

    JTextField item = new JTextField ("What would you like to sign in?");
    JButton ok = new JButton ("OK");
    JButton back = new JButton ("Back");
    
    ok.addActionListener(new okListener());
    back.addActionListener(new backListener());
    
    panel.add(item);
    panel.add(ok);
    panel.add(back);
    frame.add(panel);
    frame.setVisible (true);
  }
  
  class okListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      confirm.setVisible(true);
    }
  }
  
  class backListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      frame.setVisible(false);
      frame.dispose();
      new StudentGUI();
    }
  }
  
}

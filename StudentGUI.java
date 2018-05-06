import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentGUI extends JPanel{
  JFrame frame = new JFrame ("Music Sign Out");
  public StudentGUI(){
    frame.setSize(400,300);
    
    JPanel panel = new JPanel();
    JLabel question = new JLabel ("What would you like to do?");
    JButton signOut = new JButton ("Sign Out");
    JButton signIn = new JButton ("Sign In");
    JButton recent = new JButton ("View recent actions");
    
    signOut.addActionListener(new signOutListener());
    signIn.addActionListener (new signInListener());
    recent.addActionListener(new recentListener());
    
    panel.add(question);
    panel.add(signOut);
    panel.add(signIn);
    panel.add(recent);
    
    frame.add(panel);
    frame.setVisible (true);
  }
  
  class signOutListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      SignOut.run();
      frame.setVisible(false);
      frame.dispose();
    }
  }
  
  class signInListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new SignIn();
      frame.setVisible(false);
      frame.dispose();
    }
  }
  
  class recentListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new Recent();
      frame.setVisible(false);
      frame.dispose();
    }
  }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Edit extends JPanel implements ActionListener{
  JFrame frame2 = new JFrame("aaa");
  
  public Edit(){
    
    DoubleLinkedList<Items> list = MusicResource.getItems();
    
    
    JPanel panel2 = new JPanel();
    
    frame2.setVisible(false);
    frame2.setSize(500,500);
    
    
    String instName = JOptionPane.showInputDialog(frame2, "What insturment?");
    
    Items tempItem = MusicResource.checkItem(instName, list);
    if (tempItem == null){
      JOptionPane.showMessageDialog(null, "Not found");
    }
    else {
      JLabel nameLab = new JLabel("Name: ");
      JTextField name = new JTextField(tempItem.getName(), 10);
      JLabel descrLab = new JLabel("Description: ");
      JTextField descr = new JTextField(tempItem.getDescr(), 10);
      JLabel conditionLab = new JLabel("Condition: ");
      JTextField condition = new JTextField(10);
      if(tempItem.getCondition() == true){
        condition = new JTextField("OK", 10);
      }
      else {
        condition = new JTextField("Not OK", 10);
      }
      JLabel numLab = new JLabel("Number: ");
      JTextField num = new JTextField(tempItem.getNum(), 10);
      
      JButton ok = new JButton("OK");
      JButton cancel = new JButton("Cancel");
      ok.addActionListener(this);
      cancel.addActionListener(this);
      
      panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
      panel2.add(nameLab);
      panel2.add(name);
      panel2.add(descrLab);
      panel2.add(descr);
      panel2.add(conditionLab);
      panel2.add(condition);
      panel2.add(numLab);
      panel2.add(num);
      panel2.add(ok);
      panel2.add(cancel);
      
      frame2.add(panel2);
      frame2.setVisible(true);
    }
    
  }
  public void actionPerformed(ActionEvent e){
    if (e.getSource()== ok){
      System.out.println("1");
    }
    else{
     this.setVisible(false);
     frame2.dispose();
    }
 
  }
  
}
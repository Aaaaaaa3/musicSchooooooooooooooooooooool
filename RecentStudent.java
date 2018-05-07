import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RecentStudent {
  public RecentStudent(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setSize(300,400);
    JFrame frame2 = new JFrame();
    JPanel panel = new JPanel ();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JLabel label = new JLabel ("Recent Sign Outs:");
    
    String stuNum = JOptionPane.showInputDialog(frame2, "What's your name?");

    DoubleLinkedList<Items> list = MusicResource.getItems();
    JLabel signOuts[] = new JLabel[list.size()];
    
    for(int i = 0; i<list.size(); i++){
      if (list.get(i).getPerson() == Integer.parseInt(stuNum)){
      signOuts[i] = new JLabel(list.get(i).getName() + 
                               "\t Due: " + list.get(i).getDate() + 
                               "\t Name: " + list.get(i).getPerson());
      }
    }
    
    
    panel.add(label);
    for (int i = 0; i<list.size(); i++){
      if(signOuts[i] != null){
      panel.add(signOuts[i]);
      }
    }
    frame.add(panel);
    frame.setVisible(true);
    
  }
}
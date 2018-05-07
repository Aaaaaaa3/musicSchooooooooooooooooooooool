import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Recent {
  public Recent(){
    JFrame frame = new JFrame ("Music Sign Out");
    frame.setSize(400,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel ();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JLabel label = new JLabel ("Recent sign outs:");
    DoubleLinkedList<Items> list = MusicResource.getItems();
    JLabel signOuts[] = new JLabel[list.size()];
    
    for(int i = 0; i<list.size(); i++){
      if (list.get(i).getPerson() != -1){
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

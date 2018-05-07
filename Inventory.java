//add, delete, edit, search, previous/next
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inventory extends JPanel{
  JFrame frame = new JFrame ("Music Sign Out");
  int index=0;
  JLabel[] info = new JLabel[6];
  JButton delete = new JButton ("Delete item"); //delete the item that the user is on right now
  
  public Inventory (){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    //Print to file once the window is closed
    frame.addWindowListener(new WindowAdapter(){
      public void windowClosing(java.awt.event.WindowEvent windowEvent){
        MusicResource.printFile(MusicResource.getItems());
      }
    });
    
    JPanel panel = new JPanel();
    JButton back = new JButton ("Back");
    JButton next = new JButton ("Next");
    JButton add = new JButton ("Add item");
    JButton edit = new JButton ("Edit");
    JButton searchButton = new JButton ("Search");
    JTextField searchField = new JTextField ("Enter name of item you'd like to search for");
    
    back.addActionListener(new BackListener());
    next.addActionListener(new NextListener());
    add.addActionListener(new AddListener());
    delete.addActionListener(new DeleteListener());
    
    for (int i=0; i<6; i++){
      info[i]=new JLabel();
    }
    
    setInfo(info, index);
    
    for (int i=0; i<6; i++){
      panel.add(info[i]);
    }
    
    panel.add(back);
    panel.add(next);
    panel.add(add);
    panel.add(delete);
    panel.add(edit);
    panel.add(searchField);
    panel.add(searchButton);
    
    frame.add(panel);
    frame.setVisible(true);
  }
  
  //assigns the values into the label
  public void setInfo (JLabel[] info, int i){
    info[0].setText("Name: " + MusicResource.getItems().get(i).getName());
    info[1].setText("Number: " + MusicResource.getItems().get(i).getNum());
    if (MusicResource.getItems().get(i).getCondition()==false){
      info[2].setText("Condition: Out to repairs");
    }
    else{
      info[2].setText("Condition: Good");
    }
    info[3].setText(MusicResource.getItems().get(i).getDescr());
    if (MusicResource.getItems().get(i).getPerson()==-1){
      info[4].setText("Not taken out");
      info[5].setText("No due date");
    }
    else{
      info[4] = new JLabel(Integer.toString(MusicResource.getItems().get(i).getPerson()));
      info[5] = new JLabel(MusicResource.getItems().get(i).getDate());
    }
  }
  
  //searches for a value
  public int search (DoubleLinkedList<Items> items, int start, int end, String item){
    if (end-start>=0){
      int mid = (end+start)/2; //middle element of the array
      
      if (items.get(mid).getName().equals(item)){
        return mid;
      }
      
      if (items.get(mid).getName().compareTo(item)>0){
        return search (items, start, mid-1, item); 
      }
      else{
        return search (items, mid+1, end, item);
      }
    }
    //not in the array
    return -1;
  }
  
  class BackListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (index>0){
        index=index-1;
        setInfo(info, index);
      }
      else{
        MenuGUI.createPopUp("No more items!");
      }
    }
  }
  
  class NextListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (index<MusicResource.getItems().size()-1){
        index=index+1;
        setInfo(info, index);
      }
      else{
        MenuGUI.createPopUp("No more items!");
      }
    }
  }
  
  class AddListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      new SignOut();
    }
  }
  
  //deletes the item that the user is on
  class DeleteListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (MusicResource.getItems().size()>0){ //there are items in the list
        //check if item is taken out or at repairs
        if (MusicResource.getItems().get(index).getCondition()==false ||MusicResource.getItems().get(index).getPerson()!=-1 ){
          MenuGUI.createPopUp("Item is currently taken out or at repairs! Cannot sign out.");
        }
        else{
          MusicResource.getItems().remove(index);
          index--;
          MenuGUI.createPopUp("Item successfully removed!");
          if (MusicResource.getItems().size()>2){ //more than two items in the list
            if (index<MusicResource.getItems().size()-1){
              index=index+1; //go to the next item
              setInfo(info,index);
            }
            else{
              index=index-1;
              setInfo(info, index);
            }
          }
          else{//removing the last item
            for (int i=0; i<6; i++){
              info[i].setText("");
            }
            MenuGUI.createPopUp("No more items!");
            delete.setVisible(false);
          }
        }
      }
      else{ //nothing in the list
        MenuGUI.createPopUp("No items!");
        delete.setVisible(false);
      }
    }
  }
  
  class EditListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (index>0){
        index=index-1;
        setInfo(info, index);
      }
      else{
        MenuGUI.createPopUp("No more items!");
      }
    }
  }
  
  class SearchListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (index>0){
        index=index-1;
        setInfo(info, index);
      }
      else{
        MenuGUI.createPopUp("No more items!");
      }
    }
  }
}

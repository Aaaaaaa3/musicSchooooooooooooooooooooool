// ********************** Simple Linked List class in the linked list *********
class DoubleLinkedList<E> { 
  private Node<E> head;//first item in the list
  private Node <E> tail;//last item in the list
  
  public void add(E item) { //add an item to the list
    //no items in the list
    if (head==null) { //creates a new head with value item, next node is null
      head=new Node<E>(item);
      tail=head; //reference points to head
      return;
    }
    
    Node<E> tempNode=tail;
    tempNode.setNext(new Node<E>(item, tempNode, null));
    tail=tempNode.getNext();
    return;
  }
  
  public E get(int index) { //gets the value of item at index
    Node<E> tempNode = head;
    for (int i=0; i<index; i++){
      tempNode=tempNode.getNext();   
    }
    return tempNode.getItem();
  }
  
  public int indexOf(E item) { //returns index of item
    Node<E> tempNode = head;
    int counter=0;
    while (tempNode!=null){
      //compare the values
      if (tempNode.getItem().equals(item)){
        return counter;
      }
      tempNode=tempNode.getNext(); 
      counter++;
    }
    return 0;
  }
  
  public E remove() { //removes the first thing in the list
    head=head.getNext();
    return null;
  }
  
  public void clear() { //clear the list
    head=null;
  }
  
  public int size() { //returns size of list
    Node <E> tempNode=head;
    int counter=0;
    while (tempNode!=null){
      counter++;
      tempNode=tempNode.getNext();
    }
    return counter;
  }
}
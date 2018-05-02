//get double linked list to work
//**********A template  for a simple linked list ********

class linkTemplate {
  public static void main(String[] args) {     //the main method
    
    
    SimpleLinkedList<String> myList = new SimpleLinkedList<String>();   //you can use your list similar to an ArrayList
    
    myList.add("Bob");
    myList.add("Obb");
    myList.add("bbO");
    myList.add("Bbo");
    myList.display();
    System.out.println(myList.size());
  }
}

// ********************** Simple Linked List class in the linked list *********
class SimpleLinkedList<E> { 
  private Node<E> head;
  
  
  public void add(E item) { 
    Node<E> tempNode = head;
    
    if (head==null) {
      head=new Node<E>(item,null);
      return;
    }
    
    while(tempNode.getNext()!=null) { 
      tempNode = tempNode.getNext();
    }
    
    tempNode.setNext(new Node<E>(item,null));
    Node<E> tempTempNode = tempNode.getNext();
    tempTempNode.setPrevious(tempNode);
    
    return;
  }
  
  public E get(int index) { 
    Node<E> tempNode = head;
    for (int i=0; i<index; i++){
      tempNode=tempNode.getNext();   
    }
    return tempNode.getItem();
  }
  
  public int indexOf(E item) { 
    return 0;
  }
  
  public E remove(int index) { 
    return null;
  }
  
  public void display(){
    Node<E> tempNode = head;
    System.out.println(tempNode.getItem());
    for (int i=0; i<(this.size()-1); i++){
      tempNode=tempNode.getNext();   
      System.out.println(tempNode.getItem());
    }
    
    System.out.println();
    
    System.out.println(tempNode.getItem());
    for (int i = 0; i< (this.size()-1); i++){
      tempNode = tempNode.getPrevious();
      System.out.println(tempNode.getItem());
    }
    
  }
  
  public void clear() { 
  }
  
  public int size() { 
    int count = 0;
    Node<E> tempNode = head;
    if (tempNode == null){
      return 0;
    }
    count++;
    while (tempNode.getNext() != null)
    {count++;
     tempNode = tempNode.getNext();
    }
    return count;
  }
  
}

// ********************** A Node in the linked list *********
class Node<T> { 
  private T item;
  private Node<T> next;
  private Node<T> previous;
  
  public Node(T item) {
    this.item=item;
    this.next=null;
  }
  
  public Node(T item, Node<T> next) {
    this.item=item;
    this.next=next;
  }
  
  public Node<T> getNext(){
    return this.next;
  }
  
  public Node<T> getPrevious(){
    return this.previous;
  }
  
  public void setNext(Node<T> next){
    this.next = next;
  }
  
  public void setPrevious(Node<T> temp){
    this.previous = temp;
  }
  
  public T getItem(){
    return this.item;
  }
  
}
import java.util.Scanner;

public class DoublyLinkedList<E> {
   
    public void NewList( E start,E end ){

       DoublyLinkedList<Integer> d2=new DoublyLinkedList<Integer>(); 

      Boolean hast_start=false;

      Boolean hast_end=false;

       Node y=header.getNext();

        for(int i=0;i<size;i++){
          if(y.getElement()==start){
                hast_start=true;
                break;
            }
            y=y.getNext();
        }
         Node z=header.getNext();
      for(int i=0;i<size;i++){
            
            if(z.getElement()==end){
                hast_end=true;
                break;
            }
          
         z=z.getNext();
        }
        try {
          if(hast_start==true & hast_end==true){
          Node x=header.getNext();

        for(int i=0;i<size;i++){
            if(x.getElement()==start){
                break;
            }
             x=x.getNext();
        }
         Node Start_D2=x;
      
         Node prev_start=null;

       if(start!=header.getNext().getElement() && end!=trailer.getPrev().getElement()){
         prev_start=x.getPrev();
        }
        else if(start==header.getNext().getElement() && end!=trailer.getPrev().getElement()){
             prev_start=header;
        }
        
        else if(start!=header.getNext().getElement() && end==trailer.getPrev().getElement()){
             prev_start=x.getPrev();
        }

        else if(start==header.getNext().getElement() && end==trailer.getPrev().getElement()){
             prev_start=header;
        }
       
  
       for(int i=0;i<size;i++){
            if(x.getElement()==end){
                break;
            }
            x=x.getNext();
        }
        Node End_D2=x;

        Node next_end=null;

         if(start!=header.getNext().getElement() && end!=trailer.getPrev().getElement()){
           next_end=x.getNext();
        }
        
        else if(start==header.getNext().getElement() && end!=trailer.getPrev().getElement()){
          next_end=x.getNext();
        }
        
        else if(start!=header.getNext().getElement() && end==trailer.getPrev().getElement()){
            next_end=trailer;
        }

        else if(start==header.getNext().getElement() && end==trailer.getPrev().getElement()){
           next_end=trailer;
        }
        

        prev_start.setNext(next_end);

        next_end.setPrev(prev_start);

        Start_D2.setPrev(d2.header);

        d2.header.setNext(Start_D2);

        End_D2.setNext(d2.trailer);

        d2.trailer.setPrev(End_D2);

        System.out.print("List d2 : ");
        System.out.println(d2.toString());
        

        }
         else if (hast_start!=true){
          System.out.println("start is not in the list");
        }

        else if (hast_end!=true){
          System.out.println("end is not in the list");
        }

        else if (hast_start!=true & hast_end!=true){
          System.out.println("star and end are not in the list");
        }
        }
        catch(Exception e) {
          System.out.println("end<start");
        }
        
       
         
      
    }
  private static class Node<E> {
    private E element;              
    private Node<E> prev;           
    private Node<E> next;            
    
    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    public E getElement() { return element; }   
    public Node<E> getPrev() { return prev; }
    public Node<E> getNext() { return next; }
    public void setPrev(Node<E> p) { prev = p; }
    public void setNext(Node<E> n) { next = n; }
  } 
  private Node<E> header;                    
  private Node<E> trailer;            
  private int size = 0;                      

  public DoublyLinkedList() {
    header = new Node<>(null, null, null);      
    trailer = new Node<>(null, header, null); 
    header.setNext(trailer);                    
  }

  public int size() { return size; }

  
  public boolean isEmpty() { return size == 0; }

  public E first() {
    if (isEmpty()) return null;
    return header.getNext().getElement();   
  }

  public E last() {
    if (isEmpty()) return null;
    return trailer.getPrev().getElement();    
  }

  public void addFirst(E e) {
    addBetween(e, header, header.getNext());    
  }

  public void addLast(E e) {
    addBetween(e, trailer.getPrev(), trailer);  
  }


  public E removeFirst() {
    if (isEmpty()) return null;                  
    return remove(header.getNext());           
  }

  public E removeLast() {
    if (isEmpty()) return null;                  
    return remove(trailer.getPrev());            
  }


  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
   
    Node<E> newest = new Node<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }

  
  private E remove(Node<E> node) {
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = header.getNext();
    while (walk != trailer) {
      sb.append(walk.getElement());
      walk = walk.getNext();
      if (walk != trailer)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
} 

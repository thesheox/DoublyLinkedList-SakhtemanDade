public class main_list {
    public static void main(String[] args)
    {
        DoublyLinkedList<Integer> d1=new DoublyLinkedList<Integer>();
        
        d1.addFirst(1);
        for(int i=2;i<10;i++){
             d1.addLast(i);

        }
        System.out.println(d1.toString());
        d1.NewList(3, 4);
        

    }
    
}

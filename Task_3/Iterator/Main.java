package Task_3.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Generated list:");
        MyLinkedList list = new MyLinkedList(3);        
        System.out.println(list);

        System.out.println("After Add:");
        list.Add(10);
        System.out.println(list);

        System.out.println("After Remove:");
        list.Remove(0);
        System.out.println(list);
        
        System.out.println("Get first value from list:");
        System.out.println(list.Get(0));

    }
}
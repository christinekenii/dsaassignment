package linkedlist;

public class LinkedListTest {
    public static void main (String []args){
        LinkedList1 List1 = new LinkedList1();

        List1.addToHead("ICS 1201");
        List1.addFirst("Orange");
        List1.add("Apple");
        List1.add("50");
        List1.add("Banana");
        List1.add("67");
        List1.add("89");

        // Print the list before removing elements
        System.out.println("Before removing elements:");
        List1.traverse();

        // Remove elements by index
        List1.remove(1); // Removes the first element ("ICS 1201")
        List1.remove(4); // Removes the fifth element ("67")

        // Print the list after removing elements
        System.out.println("After removing elements:");
        List1.traverse();
    }
}

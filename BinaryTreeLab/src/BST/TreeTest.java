package BST;

public class TreeTest {
    public static void main(String[] args) {
        BSTree bst = new BSTree();

        System.out.print("\n Insert 48: ");
        bst.insert(48);
        System.out.print("\n Insert 31: ");
        bst.insert(31);
        System.out.print("\n Insert 78: ");
        bst.insert(78);
        System.out.print("\n Insert 20: ");
        bst.insert(20);
        System.out.print("\n Insert 34: ");
        bst.insert(34);
        System.out.print("\n Insert 54: ");
        bst.insert(54);
        System.out.print("\n Insert 92: ");
        bst.insert(92);
        System.out.print("\n Insert 50: ");
        bst.insert(50);


        System.out.print("\nPost order : ");
        bst.postorder();

        System.out.print("\nPre order : ");
        bst.preorder();

        System.out.print("\nInorder : ");
        bst.inorder();

        System.out.println("\n\nMaximum value: " + bst.findMax());
        System.out.println("Minimum value: " + bst.findMin());
        int searchValue = 54;
        boolean searchResult = bst.search(searchValue);
        System.out.println("\n\nSearch result for value " + searchValue + ": " + (searchResult ? "Found" : "Not Found"));
    }
}

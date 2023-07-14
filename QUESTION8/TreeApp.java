package QUESTION8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a string of letters: ");
        String input = getString();

        Tree theTree = constructTreeFromString(input);
        theTree.displayTree();

        // Rest of the code...
    }

    private static Tree constructTreeFromString(String input) {
        Tree[] treeArray = new Tree[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            Node newNode = new Node();
            newNode.iData = i;
            newNode.dData = letter;
            Tree newTree = new Tree();
            newTree.root = newNode;
            treeArray[i] = newTree;
        }

        while (treeArray.length > 1) {
            int newTreeCount = (int) Math.ceil(treeArray.length / 2.0);
            Tree[] newTreeArray = new Tree[newTreeCount];

            int j = 0;
            for (int i = 0; i < treeArray.length; i += 2) {
                Node parent = new Node();
                parent.iData = -1;
                parent.dData = '+';
                Tree newTree = new Tree();
                newTree.root = parent;
                newTree.root.leftChild = treeArray[i].root;
                newTree.root.rightChild = (i + 1 < treeArray.length) ? treeArray[i + 1].root : null;
                newTreeArray[j++] = newTree;
            }

            treeArray = newTreeArray;
        }

        return treeArray[0];
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

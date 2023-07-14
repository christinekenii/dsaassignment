package QUESTION8;

import java.util.Stack;

class Tree {
    public Node root; // first node of tree

    public Node find(int key) {
        Node current = root; // start at root
        while (current != null && current.iData != key) { // while there is a node and no match
            if (key < current.iData) { // go left?
                current = current.leftChild;
            } else { // or go right?
                current = current.rightChild;
            }
        }
        return current; // return the found node or null if not found
    }

    public void insert(int id, char dd) {
        Node newNode = new Node(); // make new node
        newNode.iData = id; // insert data
        newNode.dData = dd;
        if (root == null) // if the tree is empty
            root = newNode;
        else {
            Node current = root; // start at root
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) { // go left?
                    current = current.leftChild;
                    if (current == null) { // if end of the line
                        parent.leftChild = newNode; // insert on the left
                        return;
                    }
                } else { // go right?
                    current = current.rightChild;
                    if (current == null) { // if end of the line
                        parent.rightChild = newNode; // insert on the right
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current != null && current.iData != key) { // search for the node to delete
            parent = current;
            if (key < current.iData) { // go left?
                isLeftChild = true;
                current = current.leftChild;
            } else { // go right?
                isLeftChild = false;
                current = current.rightChild;
            }
        }

        if (current == null) // node not found
            return false;

        // If the node to delete has no children
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) // if it's the root node
                root = null; // tree is empty
            else if (isLeftChild)
                parent.leftChild = null; // disconnect from parent
            else
                parent.rightChild = null;
        }

        // If the node to delete has no right child, replace it with the left subtree
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }

        // If the node to delete has no left child, replace it with the right subtree
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        // If the node to delete has both left and right children, replace it with the inorder successor
        else {
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            successor.leftChild = current.leftChild;
        }

        return true; // success
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to the right child

        while (current != null) { // until no more left children
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to the left child
        }

        if (successor != delNode.rightChild) { // if the successor is not the right child
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.dData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.dData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.dData + " ");
        }
    }


    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();

                if (temp != null) {
                    System.out.print(temp.dData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("-");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }

            System.out.println();
            nBlanks /= 2;

            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }

        System.out.println("......................................................");
    }
}

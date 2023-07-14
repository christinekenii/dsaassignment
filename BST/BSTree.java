package BST;



/* Class BST */
public class BSTree {
    public BSTNode root;

    /* Constructor */
    public BSTree() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
    public void insert(int data) {
        root = insert(root, data);
    }

    /* Function to insert data recursively */
    public BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        } else {
            if (data <= node.getData()) {
                node.left = insert(node.left, data);
                System.out.print(node.getData() + " ");
            } else {
                node.right = insert(node.right, data);
                System.out.print(node.getData() + " ");
            }
        }
        return node;
    }

    /* Functions to delete data */
    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    public BSTNode delete(BSTNode root, int k) {
        BSTNode p, p2, n;
        if (root.getData() == k) {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    public boolean search(BSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    public void inorder(BSTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(BSTNode r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }


    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    public void postorder(BSTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }

    }
    /* Function to find the maximum value in the BST */
    public int findMax() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return Integer.MIN_VALUE;
        }

        BSTNode current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getData();
    }

    /* Function to find the minimum value in the BST */
    public int findMin() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return Integer.MAX_VALUE;
        }

        BSTNode current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current.getData();
    }

}
//number 8 left

public class ArrayBub {
    private long[] a; // ref to array a
    private int nElems; // number of data items
    //--------------------------------------------------------------
    public ArrayBub(int max) // constructor
    {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value) // put element into array
    {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }
    //--------------------------------------------------------------
    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println(" ");
    }
    //--------------------------------------------------------------
    public void bubbleSort() {
        int left = 0;
        int right = nElems - 1;

        while (left < right) {
            // Forward pass from left to right
            for (int i = left; i < right; i++) {
                if (a[i] > a[i+1]) {
                    swap(i, i+1);
                }
            }

            right--; // Decrement right index after each forward pass

            // Backward pass from right to left
            for (int i = right; i > left; i--) {
                if (a[i] < a[i-1]) {
                    swap(i, i-1);
                }
            }

            left++; // Increment left index after each backward pass
        }
    }

    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
} // end class ArrayBub
////////////////////////////////////////////////////////////////

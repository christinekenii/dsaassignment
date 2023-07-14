// stack.java
// demonstrates stacks
////////////////////////////////////////////////////////////////
public class StackX
{
    private int maxSize; // size of stack array
    public long[] stackArray;
    public int top; // top of stack
    //--------------------------------------------------------------
    public StackX(int s) // constructor
    {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        top = -1; // no items yet
    }
    //--------------------------------------------------------------
    public void push(long j) // put item on top of stack
    {
        if(isFull()){
            System.out.println("\nStack array is now full. New element cannot be added");
        }
        else {
            stackArray[++top] = j; // increment top, insert item
        }
    }
    //--------------------------------------------------------------
    public long pop() // take item from top of stack
    {
        if(isEmpty()){
            System.out.println("Stack array is now empty. No more elements can be removed");
        }
        else {
            return stackArray[top--]; // access item, decrement top
        }
        return 0;
    }
    //--------------------------------------------------------------
    public long peek() // peek at top of stack
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == maxSize-1);
    }
//--------------------------------------------------------------
} // end class StackX
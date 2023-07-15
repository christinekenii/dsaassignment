package QueuesLab;

class Queue
{
    private int maxSize;
    public long[] queArray;			// reference to an array of ‘longs.’
    public int front,  rear,  nItems;
    public Queue (int s)
    {      /* constructor
            Note:  size and structure of queue determined here.  User does not
        		 see (or care) how queue is implemented.  (See:  array here. */
        maxSize = s;
        queArray = new long[maxSize];
        //Note:  Constructor is passed desired queue size from client.
        front = 0;
        //Note:  See instance and local variables??
        rear = -1;
        //Note:  Here’s the queue;  implemented as an array;  front and rear
        nItems = 0;				 //number of Items setup and initialized.

    } // end Constructor

    public void insert(long j) {
        if (isFull()) {
            System.out.println("Queue is now full. New element cannot be added");
        } else {
            // put item at rear of queue
            if (rear == maxSize - 1)         // deals with wraparound    //Note:  insert() FIRST checks to see if there’s room for an insert.
                rear = -1;                //f rear is at maxSize-1, then we need to wrap to 0.
            queArray[++rear] = j;     // increment rear and insert	So rear is set to -1 and it is set to 0 in this statement.
            nItems++;                     // one more item	      	// note:  number of items in queue is incremented.
        } // end insert()
    }
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = front;
        System.out.print("Queue contents are: ");

        // Display items from front to rear
        while (true) {
            System.out.print(queArray[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % maxSize; // Increment index circularly
        }

        System.out.println();
    }
    public void remove() {
        if (isEmpty()) {
            System.out.println("Queue is now empty. No more elements can be removed");
        } else {
            // take item from front of queue
            long temp = queArray[front++]; // get value and increments front    //Note:  creates a temp variable, temp, and moves
            if (front == maxSize)           // deal with wraparound	// the queue item into it and increments front pointer.
                front = 0;                //  it then checks to see if the new value causes wrap.
            nItems--;                      // one less item		//  Lastly, it decrements the queue size;  returns temp.

        } // end remove()
    }
    public long peekFront()
    {   // peek at front of queue
        return queArray[front];
    } // end peek()
    public boolean isEmpty()
    {  // true if queue is empty      // Do you see a problem with insert() ?
        return (nItems==0);
    } // end isEmpty()
    public boolean isFull()
    {
        return (nItems==maxSize);	// true if queue is full
    } // end isFull()
    public int size()
    {          // number of items in queue
        return nItems;
    } // end size()
}  // end class Queue



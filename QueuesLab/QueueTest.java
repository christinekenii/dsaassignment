package QueuesLab;

public class QueueTest {
    public static void main(String[]args){
        Queue queue1=new Queue(10); //create queue
        queue1.displayQueue();

        queue1.insert(20);
        queue1.insert(55);
        queue1.insert(47);
        queue1.insert(119);
        queue1.insert(20);
        queue1.insert(4);
        queue1.insert(35);
        queue1.insert(80);
        queue1.insert(77);
        queue1.insert(13);


        //use a loop to print out the elements of the queue

        for(int i=0;i<10;i++){
            System.out.println(queue1.queArray[i]);
        }
        //print out values of the front and rear
        System.out.println("This is the front: "+ queue1.peekFront());
        System.out.println("This is the rear: "+ queue1.queArray[queue1.rear]);

        queue1.insert(44);

        queue1.displayQueue();

        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();
        queue1.remove();

        queue1.displayQueue();
    }
}


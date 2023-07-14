public class StackTest {
    public static void main(String[] args) {
        StackX thestack=new StackX(10); //make new stack
        thestack.push(20);//push items onto stack
        thestack.push(30);
        thestack.push(40);
        thestack.push(50);
        thestack.push(60);
        thestack.push(70);
        thestack.push(80);
        thestack.push(90);
        thestack.push(100);
        thestack.push(110);
        //use a loop to print out the elements of the stack

        for(int i=0;i<10;i++){
            System.out.print(thestack.stackArray[i]);
            System.out.print(" ");

        }
        thestack.push(120); //add 11th element

        System.out.println("Pop out five elements\n");
        thestack.pop();
        thestack.pop();
        thestack.pop();
        thestack.pop();
        thestack.pop();

        System.out.println("Print out array contents\n");
        for(int i=0; i<thestack.top;i++){
            System.out.print(thestack.stackArray[i]);
            System.out.print("\n");

        }
        System.out.println("Print out the top of the stack\n");
        System.out.print(thestack.top);
        System.out.print("\n");

        System.out.println("Pop out six elements\n");
        thestack.pop();
        thestack.pop();
        thestack.pop();
        thestack.pop();
        thestack.pop();
        thestack.pop();
    }
}
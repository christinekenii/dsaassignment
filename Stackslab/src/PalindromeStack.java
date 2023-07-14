import java.util.Scanner;
import java.util.Stack;

public class PalindromeStack {
    public static void main(String[] args) {
        System.out.println("Enter any string:");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString += stack.pop();
        }

        if (inputString.equals(reverseString)) {
            System.out.println("The input string is a palindrome");
        } else {
            System.out.println("The input is not a palindrome");
        }
    }
}

package QueuesLab;

import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Random;
        import java.util.Scanner;

class SupermarketQueue {
    private Queue<Integer>[] checkoutLines;
    private Random random;
    private Scanner scanner;

    public SupermarketQueue(int numCheckoutLines) {
        checkoutLines = new Queue[numCheckoutLines];
        random = new Random();
        scanner = new Scanner(System.in);

        for (int i = 0; i < numCheckoutLines; i++) {
            checkoutLines[i] = new LinkedList<>();
        }
    }

    public void addCustomer(int customer) {
        int shortestLine = findShortestLine();
        checkoutLines[shortestLine].add(customer);
    }

    public void simulateCheckoutLines() {
        while (true) {
            displayCheckoutLines();

            System.out.print("Press any key to simulate the passage of time (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            processCustomers();
        }
    }

    private void displayCheckoutLines() {
        System.out.println("\nCheckout Lines:");
        for (int i = 0; i < checkoutLines.length; i++) {
            System.out.print("Line " + i + ": ");
            for (Integer customer : checkoutLines[i]) {
                System.out.print(customer + " ");
            }
            System.out.println();
        }
    }

    private void processCustomers() {
        for (int i = 0; i < checkoutLines.length; i++) {
            if (!checkoutLines[i].isEmpty()) {
                int customer = checkoutLines[i].poll();
                int processingTime = random.nextInt(5) + 1; // Random processing time between 1 and 5 minutes
                System.out.println("Processing customer " + customer + " from Line " + i + " (Processing time: " + processingTime + " minutes)");
            }
        }
    }

    private int findShortestLine() {
        int shortestLine = 0;
        int shortestLineSize = Integer.MAX_VALUE;

        for (int i = 0; i < checkoutLines.length; i++) {
            if (checkoutLines[i].size() < shortestLineSize) {
                shortestLine = i;
                shortestLineSize = checkoutLines[i].size();
            }
        }

        return shortestLine;
    }



    public static void main(String[] args) {
        int numCheckoutLines = 3; // Number of checkout lines

        SupermarketQueue simulation = new SupermarketQueue(numCheckoutLines);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter customer ID to add (or 'q' to start simulation): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            int customerId = Integer.parseInt(input);
            simulation.addCustomer(customerId);
        }

        simulation.simulateCheckoutLines();
    }
}


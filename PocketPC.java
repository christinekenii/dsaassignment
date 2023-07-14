public class PocketPC {
    public static int mult(int x, int y) {
        if (y == 0) {
            return 0;
        } else if (y > 0) {
            return x + mult(x, y - 1);
        } else {
            return -mult(x, -y);
        }
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 4;
        int product = mult(x, y);
        System.out.println("Product of " + x + " and " + y + " is: " + product);
    }
}

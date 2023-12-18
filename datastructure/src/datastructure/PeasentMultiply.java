package datastructure;

public class PeasentMultiply {
    public static int peasantMultiply(int x, int y) {
        if (x == 0) {
            return 0;
        } else {
            int x_hat = x / 2;
            int y_hat = y + y;
            int prod = peasantMultiply(x_hat, y_hat);
            if (x % 2 != 0) {
                prod = prod + y;
            }
            return prod;
        }
    }

    public static void main(String[] args) {
        int prod = peasantMultiply(35, 42);
        System.out.println("Answer is : " + prod);
    }
}

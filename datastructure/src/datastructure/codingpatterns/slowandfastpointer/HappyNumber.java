package datastructure.codingpatterns.slowandfastpointer;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println("Is happy number: " + happyNumber.isHappy(23));
    }

    private boolean isHappy(int num) {
        int slowPointer = num;
        int fastPointer = num;
        while (true){
            slowPointer = findSquareSum(slowPointer);
            fastPointer = findSquareSum(findSquareSum(fastPointer));
            if(slowPointer == fastPointer){
                break;
            }
        }
        return slowPointer == 1;
    }

    private int findSquareSum(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
}

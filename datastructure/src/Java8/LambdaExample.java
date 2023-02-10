package Java8;


import java.util.function.Function;

// functional interface- with single abstract method
@FunctionalInterface
interface Calculator{
    void switchOn();
}

public class LambdaExample {

    public static void main(String[] args) {
        // implementing lambda expression
        Calculator calculator = () -> {
            System.out.println("Switch on");
        };

        calculator.switchOn();


        // Thread without lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread from runnable without lambda");
            }
        };

        Thread thread1 = new Thread(r1);
        thread1.start();

        // Thread without lambda

        Runnable r2  = () ->{
            System.out.println("Thread from runnable with lambda");
        };
        Thread thread2 = new Thread(r2);
        thread2.start();
    }

}

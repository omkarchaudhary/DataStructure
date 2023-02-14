package multithreading;

class Hi extends  Thread{
    public void run(){
        for(int i= 0;i <=5;i++){
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Counter{
    int count;

    public synchronized void increment(){
        count++;
    }
}
class Hello implements   Runnable{
    public void run(){
        for(int i= 0;i <=2;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        //By default, there is main thread
        //Two ways to create Thread by extending Thread class and implementing Runnable interface
        // and override the run() method. After that, thread.start() to start thread
        //start() method internally call run() method to create thread

        //Creating Thread Object
        //Hi hiObj = new Hi();

        //Starting Thread
        //Thread scheduler of JVM will determine the which thread will run based on priority.

        // Implementing Runnable Interface
        Runnable helloObj = new Hello();
        Thread t2 = new Thread(helloObj);

        // join() method is used to execute the join thread first
       // hiObj.start();
        t2.start();
        //hiObj.join();
        t2.join();
        System.out.println("Main Thread Hello");

        //set the thread Name
        t2.setName("Thread2");

        //t2.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Thread 2 name :" + t2.getName());
        System.out.println("Thread 2 Priority :" + t2.getPriority());

        Counter c = new Counter();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i  = 0; i<1000;i++){
                    c.increment();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i  = 0; i<1000;i++){
                    c.increment();
                }
            }
        });
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("The counter value is "+ c.count);
    }
}
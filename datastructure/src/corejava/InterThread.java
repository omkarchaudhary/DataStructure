package corejava;

public class InterThread {
    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myObject.firstThread();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                myObject.secondThread();
            }
        });

        t1.start();
        t1.join();
        t2.start();

    }
}

class MyObject{
    public synchronized  void firstThread(){
        System.out.println("First Thread started execution");
        try{
            //wait();
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("First Thread resumed execution");
    }

    public synchronized  void secondThread(){
        System.out.println("Second Thread started execution");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Second Thread  execution");
        //notify();
    }
}

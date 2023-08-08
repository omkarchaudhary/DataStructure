package designpattern.Observer;

public class FirstObserver implements Observer{
    @Override
    public void notifyUpdate(Message message) {
        System.out.println("The message printed from firstObserver is "+message);
    }
}

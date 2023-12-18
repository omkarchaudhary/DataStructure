package designpattern.Observer;

public class SecondObserver implements Observer{
    @Override
    public void notifyUpdate(Message message) {
        System.out.println("The message printed from secondObserver is "+message);
    }
}

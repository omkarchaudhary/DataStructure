package designpattern.Observer;

public class ObserverClient {
    public static void main(String[] args) {
        FirstObserver firstObserver = new FirstObserver();
        SecondObserver secondObserver = new SecondObserver();
        MessagePublisher messagePublisher = new MessagePublisher();
        messagePublisher.register(firstObserver);
        messagePublisher.register(secondObserver);

        messagePublisher.notifyUpdate(new Message("Message is published"));
    }
}

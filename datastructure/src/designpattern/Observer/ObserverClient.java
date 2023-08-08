package designpattern.Observer;

public class ObserverClient {
    public static void main(String[] args) {
        FirstObserver firstObserver = new FirstObserver();
        MessagePublisher messagePublisher = new MessagePublisher();
        messagePublisher.register(firstObserver);

        messagePublisher.notifyUpdate(new Message("Message is published"));
    }
}

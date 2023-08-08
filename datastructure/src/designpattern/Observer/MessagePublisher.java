package designpattern.Observer;

import java.util.HashSet;
import java.util.Set;

public class MessagePublisher implements Subject{
    private Set<Observer> observers = new HashSet<>();
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyUpdate(Message message) {
        for(Observer observer : observers){
            observer.notifyUpdate(message);
        }
    }
}

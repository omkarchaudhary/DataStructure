package designpattern.Observer;

public interface Subject {
    void register(Observer observer);
    void notifyUpdate(Message message);

}

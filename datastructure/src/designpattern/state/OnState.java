package designpattern.state;

public class OnState implements State{
    @Override
    public void doAction() {
        System.out.println("The state is ON");
    }
}

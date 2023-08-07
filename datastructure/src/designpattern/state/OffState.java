package designpattern.state;

public class OffState implements State{
    @Override
    public void doAction() {
        System.out.println("The state is OFF");
    }
}

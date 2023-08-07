package designpattern.state;

public class ContextState implements State{
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void doAction() {
        state.doAction();
    }
}

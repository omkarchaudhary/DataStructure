package designpattern.state;

/**
 *
 */
public class StateClient {
    public static void main(String[] args) {
        ContextState contextState = new ContextState();
        contextState.setState(new OnState());
        contextState.doAction();

        contextState.setState(new OffState());
        contextState.doAction();
    }
}

package designpattern.chainofresponsibility;

public class ChainResponsibilityClient {
    public static void main(String[] args) {
        ATMMachineChain atmMachineChain = new ATMMachineChain();
        ATMMachine atmMachine = atmMachineChain.getAtmMachine();
        atmMachine.dispenseMoney(new Currency(230));
    }
}

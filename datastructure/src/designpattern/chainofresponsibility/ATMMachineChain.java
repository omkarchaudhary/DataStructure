package designpattern.chainofresponsibility;

public class ATMMachineChain {
    private ATMMachine atmMachine;

    public ATMMachineChain() {
        atmMachine = new HundredRupees();
        ATMMachine atmMachine1 = new TenRupees();
        atmMachine.setNextChain(atmMachine1);
    }

    public ATMMachine getAtmMachine() {
        return atmMachine;
    }
}

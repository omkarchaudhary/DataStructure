package designpattern.chainofresponsibility;

public interface ATMMachine {
    void dispenseMoney(Currency currency);
    void setNextChain(ATMMachine atmMachine);
}

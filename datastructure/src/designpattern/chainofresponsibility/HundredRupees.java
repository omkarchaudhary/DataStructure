package designpattern.chainofresponsibility;

public class HundredRupees implements ATMMachine{
    private ATMMachine atmMachine;

    @Override
    public void dispenseMoney(Currency currency) {
        if(currency.getAmount() >= 100){
            int numberOfNotes = currency.getAmount()/100;
            int remainder = currency.getAmount()%100;
            System.out.println("Dispensing "+ numberOfNotes + " of Rs 100");
            if(remainder != 0 ){
                atmMachine.dispenseMoney(new Currency(remainder));
            }
        }else{
            atmMachine.dispenseMoney(currency);
        }
    }

    @Override
    public void setNextChain(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
}

package designpattern.chainofresponsibility;

public class TenRupees implements ATMMachine{
    private ATMMachine atmMachine;

    @Override
    public void dispenseMoney(Currency currency) {
        if(currency.getAmount() >= 10){
            int numberOfNotes = currency.getAmount()/10;
            int remainder = currency.getAmount()%10;
            System.out.println("Dispensing "+ numberOfNotes + " of Rs 10");
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

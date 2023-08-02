package designpattern.strategy;

public class CreditcardPayment implements PaymentMethod{
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiration;

    public CreditcardPayment(String cardHolderName, String cardNumber, String cvv, String dateOfExpiration) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiration = dateOfExpiration;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getDateOfExpiration() {
        return dateOfExpiration;
    }

    @Override
    public void makePayment(int amount) {
        System.out.println("The amount paid by credit card is "+ amount + " by card " + getCardNumber());
    }
}

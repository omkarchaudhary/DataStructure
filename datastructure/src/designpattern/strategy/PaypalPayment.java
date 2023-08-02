package designpattern.strategy;

public class PaypalPayment implements PaymentMethod{
    private String username;
    private String password;

    public PaypalPayment(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void makePayment(int amount) {
        System.out.println("The amount paid by Paypal account  "+ amount + " user by "+ getUsername());
    }
}

package designpattern.strategy;

public class StrategyClient {
    public static void main(String[] args) {
        Product book = new Product("Book", 100);
        Product laptop = new Product("Laptop", 1100);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(book);
        shoppingCart.addProduct(laptop);
        // Stragey used to pay CCreditCard or Paypal account
        //pay with Creditcard
        shoppingCart.paymentMethod(new CreditcardPayment("Design","1234556677","123","02/28"));
        //pay with paypal account
        shoppingCart.paymentMethod(new PaypalPayment("username","password"));
    }
}

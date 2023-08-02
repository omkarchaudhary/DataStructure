package designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProduct(Product product){
        products.remove(product);
    }
    private int calculatePrice(){
        return products.stream()
                .map(x -> x.getPrice())
                .reduce(0,Integer::sum);
    }
    public void paymentMethod(PaymentMethod paymentMethod){
        paymentMethod.makePayment(calculatePrice());
    }
}

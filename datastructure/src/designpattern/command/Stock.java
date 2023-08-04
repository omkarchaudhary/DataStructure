package designpattern.command;

public class Stock {
    private  String name = "Microsoft";
    private int quantity = 100;

    public void buyStock(){
        System.out.println("Bought stock "+name+" and quantity "+quantity);
    }

    public void sellStock(){
        System.out.println("Sold stock "+name+" and quantity "+quantity);
    }
}

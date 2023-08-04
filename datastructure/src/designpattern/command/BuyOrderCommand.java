package designpattern.command;

public class BuyOrderCommand implements OrderCommand{
    Stock stock = new Stock();

    public BuyOrderCommand(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void executeCommand() {
        stock.buyStock();
    }
}

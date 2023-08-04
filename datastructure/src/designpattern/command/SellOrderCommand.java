package designpattern.command;

public class SellOrderCommand implements OrderCommand{
    Stock stock = new Stock();

    public SellOrderCommand(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void executeCommand() {
        stock.sellStock();
    }
}

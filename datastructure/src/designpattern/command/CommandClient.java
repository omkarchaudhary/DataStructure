package designpattern.command;

public class CommandClient {
    /**
     * A request object(Stock) is wrapped under an object as command and passed to invoker object(OrderCommand). Invoker object looks for the appropriate command object(SellOrderCommand, BuyOrderCommand) which
     * can handle this command and passes the command to the corresponding object which executes the command.
     * @param args
     */
    public static void main(String[] args) {
        //Request object
        Stock stock = new Stock();
        //Wrapping request object in command
        BuyOrderCommand buyOrderCommand = new BuyOrderCommand(stock);
        SellOrderCommand sellOrderCommand = new SellOrderCommand(stock);

        //Invoker object adding the command
        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.addOrderCommand(buyOrderCommand);
        commandInvoker.addOrderCommand(sellOrderCommand);

        //executing command
        commandInvoker.executeCommand();
    }
}

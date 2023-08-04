package designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<OrderCommand> orderCommands = new ArrayList<>();
    public void addOrderCommand(OrderCommand orderCommand){
        orderCommands.add(orderCommand);
    }
    public void executeCommand(){
        for(OrderCommand orderCommand : orderCommands){
            orderCommand.executeCommand();
        }
        orderCommands.clear();
    }
}

package corejava;

import java.time.LocalDate;
import java.util.concurrent.*;

public class CallableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new CallableClass("CallThread"));
        String threadName = future.get(10, TimeUnit.SECONDS);
        System.out.println("Thread completed: "+ threadName);
    }
}

class CallableClass implements Callable<String>{
    private final String taskName;

    public CallableClass(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Task ["+taskName+"] executed on "+ LocalDate.now().toString());
        return taskName;
    }
}

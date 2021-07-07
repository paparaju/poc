package poc;

import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args) {

        ExecutorService executor
                = Executors.newFixedThreadPool(5);
        for(int i = 1; i<=3 ; i++){
            System.out.println(Thread.currentThread().getName()+":Retrying "+i);
            Future<Void> future = new SquareCalculator().calculate(10,executor);
            try {
                future.get(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
                System.out.println("Cancelling the thread");
                boolean canceled = future.cancel(true);
            } finally {

            }
        }


        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("In sleeping thread");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        executor.shutdown();
    }
}

 class SquareCalculator {
    public Future<Void> calculate(Integer input,ExecutorService executor) {
        return executor.submit(() -> {
            while(true)
            {
                System.out.println(Thread.currentThread()+ ":Calculating...Inside thread");
                Thread.sleep(10);
            }
        });
    }
}

package poc;

import java.util.concurrent.*;

public class TempCallableFuture {
    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            while(true) {
                System.out.println("In async Thread");
//                System.out.println(Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(100);
                    if (Thread.currentThread().isInterrupted()) {
                        // oh no! an interrupt!
                        Thread.currentThread().interrupt();
                        throw new Exception("Exception from inside thread");
                    }
                }  catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        try {
            future.get(300, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("In exception");
            e.printStackTrace();
            System.out.println("Cancelling thread");
            boolean status = future.cancel(true);
            System.out.println("Cancel status is "+future.isCancelled());
        }

        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("In sleeping thread");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

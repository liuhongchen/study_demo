package _03_future;


import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBuildDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool= Executors.newFixedThreadPool(3);

//        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },threadPool);
        System.out.println(new Date());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello supplyAsync";
        }, threadPool);


        System.out.println(completableFuture.get());
        System.out.println(new Date());

        threadPool.shutdown();
    }


}

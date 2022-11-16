package _03_future;


import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureThreadPoolDemo {




    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        System.out.println(new Date());
        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            Thread.sleep(2000);
            return "task1 over";
        });
        threadPool.submit(futureTask1);



        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            Thread.sleep(3000);
            return "task2 over";
        });

        System.out.println(new Date() + "," + futureTask1.get());//会阻塞等待
        System.out.println(123);

        threadPool.submit(futureTask2);

        threadPool.shutdown();


    }

}

package _03_future;


import java.util.concurrent.*;

public class CompletableFutureUseDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService threadPool= Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(()->{

            System.out.println(Thread.currentThread().getName()+" come in....");

            int res= ThreadLocalRandom.current().nextInt(10);

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int i=10/0;
            System.out.println("-----1秒钟后出结果"+res);

            return res;
        },threadPool).whenComplete((res,e)->{
            if (e==null){
                System.out.println("-----计算完成，更新系统updateValue："+res);
            }else {
                System.out.println("error:"+e);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("异常情况："+e.getCause()+"\t"+e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName()+"线程先去忙其他任务");

//        Thread.sleep(2000);
        threadPool.shutdown();
    }


}

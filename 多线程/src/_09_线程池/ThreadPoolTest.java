package _09_线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:ThreadPoolTest
 * Package:_09_线程池
 * Description:
 *
 * @date: 2023-01-11 10:43
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(5,10,
                3000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());



        executorService.submit(()->{
            System.out.println("123");
        });

        executorService.shutdown();
    }
}

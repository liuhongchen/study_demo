package _08_executors;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:TestPool
 * Package:_08_executors
 * Description:
 *
 * @date: 2022-11-24 09:34
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class TestPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 1000, TimeUnit.NANOSECONDS,
                10, (queue, task) -> {
            //1. 死等
//            queue.put(task);
            //2. 带超时等待
//            queue.offer(task,500,TimeUnit.SECONDS);
            //3. 让调用者放弃任务
//            System.out.println("放弃任务");
            //4. 让调用者抛出异常
//            throw new RuntimeException("任务执行失败 "+task);
            //5. 让调用者自己执行任务
            task.run();
        });

        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {

                try {
                    Thread.sleep(10000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
    }
}


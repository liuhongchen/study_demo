package _08_executors;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:ThreadPool
 * Package:_08_executors
 * Description:
 *
 * @date: 2022-11-24 15:19
 * @author:Hansing liuhongchengege123@gmail.com
 */

class ThreadPool{

    //任务队列
    private BlockingQueue<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers=new HashSet();

    //核心线程数量
    private int coreSize;

    //获取任务的超时时间
    private long timeout;
    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;


    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit,
                      int queueCapacity,RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue=new BlockingQueue<>(queueCapacity);
        this.rejectPolicy=rejectPolicy;
    }

    public void execute(Runnable runnable){

        synchronized (workers){
            //当任务数没有超过coreSize时,直接交给worker对象执行
            if (workers.size()<=coreSize){
                Worker worker=new Worker(runnable);
                System.out.println("加入worker"+worker);
                workers.add(worker);
                worker.start();
            }else {//如果任务数超过coreSize,要加入任务队列
                taskQueue.tryPut(runnable,rejectPolicy);
                taskQueue.put(runnable);
                System.out.println("任务加入队列");
            }
        }




    }

    class Worker extends Thread{

        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }


        @Override
        public void run() {
            //一共有两种情况
            //1) task不为空 2)task为空

            while (task!=null){
                try {
                    System.out.println(this+"开始执行任务");
                    task.run();
                    System.out.println(this+"执行任务结束");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task=null;
                }
                task=taskQueue.poll(timeout,timeUnit);
            }

            synchronized (workers){
                workers.remove(this);
            }
        }
    }
}
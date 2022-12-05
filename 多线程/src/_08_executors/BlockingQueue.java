package _08_executors;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:BlockingQueue
 * Package:_08_executors
 * Description:
 *
 * @date: 2022-11-24 15:19
 * @author:Hansing liuhongchengege123@gmail.com
 */
class BlockingQueue<T> {

    // 1. 任务队列
    private Deque<T> queue = new ArrayDeque<>();

    // 2. 锁
    private ReentrantLock lock = new ReentrantLock();


    //3. 生产者条件变量
    private Condition fullWaitSet = lock.newCondition();


    //4. 消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();


    // 5. 队列大小
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    //阻塞获取
    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T t = queue.removeFirst();
            fullWaitSet.signal();

            return t;

        } finally {
            lock.unlock();
        }

    }


    //超时阻塞获取
    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        long nanos = unit.toNanos(timeout);
        try {
            while (queue.isEmpty()) {
                try {
                    if (nanos<=0)return null;
                    //返回的是剩余的时间
                    nanos=emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T t = queue.removeFirst();
            fullWaitSet.signal();

            return t;

        } finally {
            lock.unlock();
        }

    }

    public void put(T task) {
        lock.lock();
        try {
            while (queue.size() >= capacity) {
                try {
                    System.out.println("阻塞队列满了,await....");
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(task);
            emptyWaitSet.signal();

        } finally {
            lock.unlock();
        }
    }

    public void tryPut(T task,RejectPolicy<T> rejectPolicy){

        lock.lock();

        try {
            if (queue.size()>=capacity){//满了 拒绝
                rejectPolicy.reject(this,task);
            }else {
                queue.addLast(task);
            }

        }finally {
            lock.unlock();
        }

    }

    //带超时时间的入队
    public boolean offer(T task,long timeout,TimeUnit timeUnit) {

        long nanos=timeUnit.toNanos(timeout);

        lock.lock();
        try {
            while (queue.size() >= capacity) {
                try {
                    if (nanos<=0)return false;
                    System.out.println("阻塞队列满了,await....");
                    nanos=fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(task);
            emptyWaitSet.signal();
            return true;

        } finally {
            lock.unlock();
        }
    }
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
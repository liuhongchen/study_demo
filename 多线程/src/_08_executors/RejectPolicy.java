package _08_executors;

/**
 * ClassName:RejectPolicy
 * Package:_08_executors
 * Description:
 *
 * @date: 2022-11-24 15:20
 * @author:Hansing liuhongchengege123@gmail.com
 */
@FunctionalInterface
interface RejectPolicy<T>{

    void reject(BlockingQueue<T> blockingQueue,T task);
}
package _09_concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class HashMapDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(30);

        ConcurrentHashMap<Integer, LongAdder> map = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            threadPool.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    LongAdder value = map.computeIfAbsent(j, (key) -> new LongAdder());
                    value.increment();
                }
                latch.countDown();
            });
        }

        latch.await();

        for (Integer key : map.keySet()) {
            LongAdder longAdder = map.get(key);
            System.out.println(key + ":" + longAdder.intValue());
        }

        threadPool.shutdown();
    }
}

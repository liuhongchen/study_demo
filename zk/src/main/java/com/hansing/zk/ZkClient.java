package com.hansing.zk;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClient {

    private String connectString="127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183," +
            "127.0.0.1:2184";
    private int sessionTimeout=2000;
    ZooKeeper zkClient;
    @Before
    public void init() throws IOException {

        zkClient= new ZooKeeper(connectString, sessionTimeout,
                new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.toString());
            }
        });
    }
//
//    @Test
//    public void create() throws KeeperException, InterruptedException {
//        String s = zkClient.create("/java", "ss.avi".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(s);
//    }


    @Test
    public void getAndWatch() throws KeeperException, InterruptedException {
        List<String> children=zkClient.getChildren("/",true);

        for(String child:children){
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

}

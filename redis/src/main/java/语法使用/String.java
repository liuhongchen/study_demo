package 语法使用;

import redis.clients.jedis.Jedis;
import 连接.连接池.RedisPool;

/**
 * ClassName:String
 * Package:语法使用
 * Description:
 *
 * @date:2019-11-28 15:59
 * @author:892698613@qq.com
 */
public class String {

    public static void main(String[] args) {
        Jedis jedis = RedisPool.getJedis();
        if (jedis!=null){

            System.out.println(jedis.set("key1","value1"));
            System.out.println(jedis.set("key2","value2"));
            System.out.println(jedis.set("key3","value3"));

            System.out.println("删除key2:"+jedis.del("key2"));
            System.out.println("获取key2:"+jedis.get("key2"));
            System.out.println("修改key1:"+ jedis.set("key1","new value1"));
            System.out.println("在key1后面加入值 hello"+jedis.append("key1","hello"));
            System.out.println("获取key1:"+jedis.get("key1"));

            System.out.println("增加多个键值"+jedis.mset("k1","v1","k2","v2"));
            System.out.println("获取多个键值对:"+jedis.mget("k1","k2"));
            System.out.println("删除多个键值对:"+jedis.del("k1","k2"));

            jedis.setnx("m1","v1");
            jedis.setex("m2",2,"v2");


            jedis.flushDB();



            jedis.close();
        }
    }
}

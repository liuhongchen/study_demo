package 连接.连接池;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName:RedisPool
 * Package:连接.连接池
 * Description:
 *
 * @date:2019-11-28 15:39
 * @author:892698613@qq.com
 */
public class RedisPool {

    public  static Jedis getJedis(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(30);
        //设置最大的空闲
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool=new JedisPool("192.168.1.110",6380);
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
        }catch (Exception e){
            e.printStackTrace();
        }
        return jedis;
    }


    public static void main(String[] args) {
        Jedis jedis = getJedis();
        if (jedis!=null) {
            jedis.set("test", "new test");
            String test = jedis.get("test");
            System.out.println(test);
            jedis.close();
        }
    }
}

package 哨兵;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName:JedisSentinel
 * Package:哨兵
 * Description:
 *
 * @date:2019-11-28 21:35
 * @author:892698613@qq.com
 */
public class JedisSentinel  {
    public static void main(String[] args) {
        Set<String> sentinels=new HashSet<String>();

        sentinels.add("192.168.1.110:26380");
        sentinels.add("192.168.1.110:26381");
        sentinels.add("192.168.1.110:26382");


        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxTotal(300);
        poolConfig.setMaxIdle(20);

        JedisSentinelPool jedisSentinelPool
                =new JedisSentinelPool("mymaster",sentinels,poolConfig);

        Jedis jedis=jedisSentinelPool.getResource();
        jedis.auth("password");

    }
}

package 语法使用;

import redis.clients.jedis.Jedis;
import 连接.连接池.RedisPool;

/**
 * ClassName:List
 * Package:语法使用
 * Description:
 *
 * @date:2019-11-28 16:05
 * @author:892698613@qq.com
 */
public class List {

    public static void main(String[] args) {
        Jedis jedis = RedisPool.getJedis();
        if (jedis!=null){
            jedis.flushDB();

            jedis.lpush("list","1");
            jedis.rpush("list","2");
            jedis.lrange("list",0,-1);

            jedis.lrem("list",1,"value");

            jedis.ltrim("list",1,2);

            jedis.lpop("list");


            jedis.close();
        }
    }
}

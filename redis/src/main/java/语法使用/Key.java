package 语法使用;

import redis.clients.jedis.Jedis;
import 连接.连接池.RedisPool;

import java.util.Set;

/**
 * ClassName:Key
 * Package:语法使用
 * Description:
 *
 * @date:2019-11-28 15:48
 * @author:892698613@qq.com
 */
public class Key {

    public static void main(String[] args) {
        Jedis jedis= RedisPool.getJedis();

        if (jedis!=null){

            System.out.println("清空当前数据库数据:"+jedis.flushDB());
            System.out.println("清空所有数据库数据:"+jedis.flushAll());
            System.out.println("判断某个键是否存在:"+jedis.exists("username"));
            System.out.println("新增username,tom键值对:"+jedis.set("username","tom"));
            System.out.println("新增password,pwd键值对:"+jedis.set("password","pwd"));
            System.out.println("获取username:"+ jedis.get("username"));

            System.out.println("系统中所有键如下:");
//            Set<String> keys=jedis.keys("*");
//            System.out.println(keys);

            System.out.println("删除username"+jedis.del("username"));
            System.out.println("判断username是否存在:"+jedis.exists("username"));
            System.out.println("查看password的值类型:"+jedis.type("password"));
            System.out.println("随机返回key空间的一个:"+jedis.randomKey());
            System.out.println("重命名key password为pwd:"+jedis.rename("password","pwd"));
            System.out.println("取出修改后的pwd:"+ jedis.get("pwd"));

            System.out.println("按索引查询:"+jedis.select(0));
            System.out.println("返回当前数据库中key的数目:"+jedis.dbSize());
            System.out.println("删除数据库中所有的key:"+jedis.flushAll());

            jedis.close();
        }
    }
}

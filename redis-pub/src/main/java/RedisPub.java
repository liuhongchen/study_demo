import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * ClassName:RedisPub
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-11-28 18:30
 * @author:892698613@qq.com
 */
public class RedisPub {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.1.110",6380);
        jedis.publish("cctv6","hello from idea");
        System.out.println("消息发布完毕");
    }
}

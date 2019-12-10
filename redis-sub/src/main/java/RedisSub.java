import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * ClassName:Redis
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-11-28 18:24
 * @author:892698613@qq.com
 */
public class RedisSub extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("订阅者1收到"+channel+"的消息:"+message);
    }


    public static void main(String[] args) {
        System.out.println("开启订阅者1");

        Jedis jedis=new Jedis("192.168.1.110",6380);

        RedisSub redisSub=new RedisSub();
        jedis.subscribe(redisSub,"cctv6");
    }

}

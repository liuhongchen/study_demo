package 连接.单实例;

import redis.clients.jedis.Jedis;

/**
 * ClassName:Single
 * Package:连接.单实例
 * Description:
 *
 * @date:2019-11-28 15:33
 * @author:892698613@qq.com
 */
public class Single {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.1.110",6380);
        jedis.set("test","test");

        String test=jedis.get("test");
        System.out.println(test);
        jedis.close();
    }
}

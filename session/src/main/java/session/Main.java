package session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * ClassName:Main
 * Package:session
 * Description:
 *
 * @date:2020-01-10 16:41
 * @author:892698613@qq.com
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context
                =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        JedisConnectionFactory jedisConnectionFactory = context.getBean("jedisConnectionFactory", JedisConnectionFactory.class);

        RedisConnection connection = jedisConnectionFactory.getConnection();
        connection.set("key".getBytes(),"val".getBytes());
        connection.close();
    }
}

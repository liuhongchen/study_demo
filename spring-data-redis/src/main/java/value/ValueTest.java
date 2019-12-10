package value;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:Valuetest
 * Package:value
 * Description:
 *
 * @date:2019-11-28 16:48
 * @author:892698613@qq.com
 */
@SuppressWarnings("unchecked")
public class ValueTest {

    @Autowired
    private JedisConnectionFactory connectionFactory;


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        System.out.println(connectionFactory);
        System.out.println(redisTemplate);
//        redisTemplate.opsForValue().set("spring data","spring data");
    }


    public static void main(String[] args) {
        ApplicationContext context
                =new ClassPathXmlApplicationContext("applicationContext-redis.xml");

        RedisTemplate redisTemplate = context.getBean("redisTemplate", RedisTemplate.class);


        BoundZSetOperations zSetOperations = redisTemplate.boundZSetOps("zset");

        //第二个参数是权重把,应该是用来排序的
        zSetOperations.add("A",1);
        zSetOperations.add("B",2);
        zSetOperations.add("C",3);


        //返回所有元素,并从小到大排序
        zSetOperations.range(1,-1);
        zSetOperations.zCard();


        ZSetOperations.TypedTuple<Object> objectTypedTuple1
                =new DefaultTypedTuple<Object>("zset-5",9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2
                =new DefaultTypedTuple<Object>("zset-6",9.9);
        Set<ZSetOperations.TypedTuple<Object>> tuples
                =new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        System.out.println(zSetOperations.add(tuples));
        System.out.println(zSetOperations.range(0,-1));

    }
}

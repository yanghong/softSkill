package redis;
import redis.clients.jedis.Jedis;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/1 16:57
 */

public class RedisTest {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("119.45.41.22");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());
    }
}

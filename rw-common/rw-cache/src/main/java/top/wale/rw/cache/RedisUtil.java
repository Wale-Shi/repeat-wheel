package top.wale.rw.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.wale.rw.base.utils.SpringUtil;

/**
 * Function:RedisUtil
 *
 * @author wale
 * @date 2019/11/29
 */
public class RedisUtil {

    private static StringRedisTemplate redisTemplate = SpringUtil.getBean(StringRedisTemplate.class);

    /**
     * kv set
     * @param key
     * @param val
     */
    public static void put(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
    }

    /**
     * kv get
     * @param key
     * @return
     */
    public static String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * hash set
     * @param key
     * @param field
     * @param val
     */
    public static void put(String key, String field,String val) {
        redisTemplate.opsForHash().put(key, field, val);
    }

    /**
     * hash get
     * @param key
     * @param field
     * @return
     */
    public static String get(String key, String field) {
        return (String) redisTemplate.opsForHash().get(key, field);
    }

}

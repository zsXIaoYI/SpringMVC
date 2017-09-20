package cn.zsza.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhangSong on 2016/12/23.
 * 20:56
 */
@Component
public class RedisUtil {
    private final long DEFAULT_LOCK_TIMEOUNT = 10000l;
    private static final Logger log = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private Pool<Jedis> redisPool;

    public synchronized Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = redisPool.getResource();
//            System.out.println(jedis.dbSize() + "..........");
        } catch (Exception e) {
            log.error("获取jedis异常:" + e.getMessage() );
        }
        return jedis;
    }

    public String set(String key, String value) {
        Jedis jedis = getJedis();
        try {
            return jedis == null ? null : jedis.set(key, value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    /**
     *
     * @param key
     * @param value
     * @param expireTime(秒)
     * @return
     */
    public String set(String key, String value,int expireTime) {
        Jedis jedis = getJedis();
        try {
            return jedis == null ? null : jedis.setex(key,expireTime,value);
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    public Long setnx(String key,String value){
        Jedis jedis = getJedis();
        try {
            return jedis == null ? null : jedis.setnx(key,value);
        }finally {
            if (jedis != null)
                jedis.close();
        }
    }

    public Long expire(String key,int seconds){
        Jedis jedis = getJedis();

        try {
            return jedis == null ? null : jedis.expire(key,seconds);
        }finally {
            if (jedis != null)
                jedis.close();
        }
    }

    public String get(String key){
        Jedis jedis = getJedis();

        try {
            return jedis == null ? null : jedis.get(key);
        }finally {
            if (jedis != null)
                jedis.close();
        }
    }

    /**
     * 获取锁
     * @param lockKey
     * @param lockValue
     * @return
     */
    public boolean lock(String lockKey,String lockValue){
        boolean result=false;
        try(Jedis resource = redisPool.getResource()){
            String set = resource.set(lockKey, lockValue, "NX", "PX", DEFAULT_LOCK_TIMEOUNT);
            result = "OK".equals(set);
        }catch (Exception e){

        }
        return result;
    }

    /**
     * 释放锁
     * @param lockKey
     * @param lockValue
     * @return
     */
    public boolean unlock(String lockKey,String lockValue ){
        boolean result=false;
        String value=null;
        try(Jedis resource = redisPool.getResource()){
            value = resource.get(lockKey);
            if(null==value){
                result= true;
            }else {
                if (lockValue.equals(value)) {
                    result = resource.del(lockKey) > 0l;
                } else {
                    result = true;
                }
            }
        }catch (Exception e){
        }
        return result;
    }

    /**
     * 存放Map
     * @param key
     * @param map
     * @param expireTime
     * @return
     */

    public boolean setMap(String key, Map<String, String> map, int expireTime) {
        Jedis jedis = getJedis();
        try {
            String result = jedis.hmset(key, map);
            if (!StringUtils.isEmpty(result) && result.equalsIgnoreCase("OK")) {
                jedis.expire(key, expireTime);
                return true;
            } else {
                return false;
            }
        } finally {
            jedis.close();
        }
    }
    public String getMapKey(String key, String field) {
        Jedis jedis = getJedis();
        try {
            String result = jedis.hget(key, field);
            if (!StringUtils.isEmpty(result) && result.equalsIgnoreCase("nil")) {
                return null;
            } else {
                return result;
            }
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取所有的可以对应的value，其结果集封装成一个list
     * @param key
     * @param field
     * @return
     */
    public List<String> getMapVal(String key, String... field) {
        Jedis jedis = getJedis();
        try {
            return jedis.hmget(key, field);
        } finally {
            jedis.close();
        }
    }

    /**
     * 获得所有的key
     * @param key
     * @return
     */
    public Set<String> getMapKeys(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.hkeys(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取所有value
     * @param key
     * @return
     */
    public List<String> getMapVals(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.hvals(key);
        } finally {
            jedis.close();
        }
    }

    public long increment(String key) {
        Jedis jedis = getJedis();
        long n = jedis.incr(key);
        if (jedis != null)
            jedis.close();
        return n;
    }
}

package com.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用第三方内存数据库Redis作为二级缓存
 */
public class RedisCache implements Cache{

    private static final Logger LOGGER= LoggerFactory.getLogger(Cache.class);

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    private String id;

    private final ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public RedisCache(String id) {
        if(id==null){
            throw new IllegalArgumentException("Cache require ID!!!");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * redis缓存放入值
     * Redis：key-value
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        JedisConnection connection=null;
        try {
            connection=jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer=new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key),serializer.serialize(value));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }

    }

    /**
     * 根据Redis的key来获取value
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        Object result=null;
        JedisConnection connection=null;
        try {
            connection=jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer=new JdkSerializationRedisSerializer();
            result=serializer.deserialize(connection.get(serializer.serialize(key)));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }

        return result;
    }

    /**
     * 移除Redis中key-value
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        Object result=null;
        JedisConnection connection=null;
        try {
            connection=jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer=new JdkSerializationRedisSerializer();
            result=connection.expire(serializer.serialize(key),0);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection!=null){

            }
        }

        return result;
    }

    /**
     * 清除Redis缓存
     */
    @Override
    public void clear() {
        JedisConnection connection=null;
        try {
            connection=jedisConnectionFactory.getConnection();
            connection.flushDb();
            connection.flushAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           if (connection!=null){
               connection.close();
           }
        }
    }

    /**
     * 获取Redis数据库长度
     * @return
     */
    @Override
    public int getSize() {
        JedisConnection connection=null;
        int size=0;
        try {
            connection=jedisConnectionFactory.getConnection();
            size=Integer.valueOf(connection.dbSize().toString());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return size;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}

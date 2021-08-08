package com.begin.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTS {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        Transaction t = jedis.multi();
        try {
            t.set("name", "mike");
            t.set("age", "1");
            t.exec();
        } catch (Exception e) {
            e.printStackTrace();
            t.discard();
        } finally {
            jedis.close();
        }

    }
}

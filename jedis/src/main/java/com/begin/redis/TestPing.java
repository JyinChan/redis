package com.begin.redis;

import redis.clients.jedis.Jedis;

public class TestPing {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("k1", "hello world");
        System.out.println(jedis.get("k1"));
    }
}

package com.begin.springbootredis;

import com.begin.springbootredis.models.Customer;
import com.begin.springbootredis.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	@Qualifier("redisTemplateCustom")
	private RedisTemplate redisTemplate2;

	@Test
	void contextLoads() {
		System.out.println(redisTemplate.opsForValue().get("name"));
	}

	@Test
	void test() {
		//默认redisTemplate下User需要序列化
		redisTemplate.opsForValue().set("user", new User("mike", 1));
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

	@Test
	void test2() {
		redisTemplate2.opsForValue().set("customer", new Customer("john", 10));
		System.out.println(redisTemplate2.opsForValue().get("customer"));
	}

}

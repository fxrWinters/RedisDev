package org.redis.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class JedisService {
	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;
	
	public Jedis getJedis() {
		return jedisConnectionFactory.getShardInfo().createResource();
	}
}

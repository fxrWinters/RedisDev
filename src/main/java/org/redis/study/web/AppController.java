package org.redis.study.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.redis.study.model.Topic;
import org.redis.study.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

@Controller
public class AppController {
	@Autowired
	private JedisService jedisService;
	
	private final static String allTopicKey = "forum_1";
	
	private final static String listForumKey = "list_forum_1";
	
	private final static String pickForumKey = "pick_forum_1";
	
	@RequestMapping("/set")
	@ResponseBody
	public String set(HttpServletRequest request, HttpServletResponse response) {
		Jedis jedis = jedisService.getJedis();
		init(jedis);
		
		System.out.println("Before...........");
		List<String> list = jedis.lrange(listForumKey, 0, -1);
		for (String s: list) {
			System.out.println(s + ": " + jedis.get(s));
		}
		
		jedis.lrem(listForumKey, 1, "Topic-3");
		jedis.lpush(listForumKey, "Topic-3");
		
		System.out.println("After............");
		list = jedis.lrange(listForumKey, 0, -1);
		for (String s: list) {
			System.out.println(s + ": " + jedis.get(s));
		}
		
		return "Hello world!";
	}
	
	private void init(Jedis jedis) {
		initTopics();
		
		jedis.del(allTopicKey);
		jedis.del(listForumKey);
		
		// Cache
		jedis.set("Topic-1", topic_1.toString());
		jedis.set("Topic-2", topic_2.toString());
		jedis.set("Topic-3", topic_3.toString());
		jedis.set("Topic-4", topic_4.toString());
		jedis.set("Topic-5", topic_5.toString());
		
		// List
		jedis.lpush(listForumKey, "Topic-5");
		jedis.lpush(listForumKey, "Topic-2");
		jedis.lpush(listForumKey, "Topic-1");
		jedis.lpush(listForumKey, "Topic-3");
		jedis.lpush(listForumKey, "Topic-4");
		
		// Pick_List
		jedis.lpush(pickForumKey, "Topic-1");
		jedis.lpush(pickForumKey, "Topic-3");
		jedis.lpush(pickForumKey, "Topic-2");
		jedis.lpush(pickForumKey, "Topic-4");
		jedis.lpush(pickForumKey, "Topic-5");
	}
	
	private Topic topic_1;
	private Topic topic_2;
	private Topic topic_3;
	private Topic topic_4;
	private Topic topic_5;
	private void initTopics() {
		topic_1 = new Topic();
		topic_1.setTid(1);
		topic_1.setFid(1);
		topic_1.setPid(1);
		topic_1.setName("topic_1");
		topic_1.setCreateAt(new Date(System.currentTimeMillis() - 10*60*1000));
		topic_1.setUpdateAt(new Date(System.currentTimeMillis() - 10*60*1000));
		topic_1.setLastPostAt(new Date(System.currentTimeMillis() - 9*60*1000));
		
		topic_2 = new Topic();
		topic_2.setTid(21);
		topic_2.setFid(1);
		topic_2.setPid(2);
		topic_2.setName("topic_2");
		topic_2.setCreateAt(new Date(System.currentTimeMillis() - 11*60*1000));
		topic_2.setUpdateAt(new Date(System.currentTimeMillis() - 11*60*1000));
		topic_2.setLastPostAt(new Date(System.currentTimeMillis() - 8*60*1000));
		
		topic_3 = new Topic();
		topic_3.setTid(3);
		topic_3.setFid(1);
		topic_3.setPid(3);
		topic_3.setName("topic_3");
		topic_3.setCreateAt(new Date(System.currentTimeMillis() - 18*60*1000));
		topic_3.setUpdateAt(new Date(System.currentTimeMillis() - 18*60*1000));
		topic_3.setLastPostAt(new Date(System.currentTimeMillis() - 7*60*1000));
		
		topic_4 = new Topic();
		topic_4.setTid(43);
		topic_4.setFid(1);
		topic_4.setPid(4);
		topic_4.setName("topic_4");
		topic_4.setCreateAt(new Date(System.currentTimeMillis() - 3*60*1000));
		topic_4.setUpdateAt(new Date(System.currentTimeMillis() - 3*60*1000));
		topic_4.setLastPostAt(new Date(System.currentTimeMillis() - 2*60*1000));
		
		topic_5 = new Topic();
		topic_5.setTid(52);
		topic_5.setFid(1);
		topic_5.setPid(5);
		topic_5.setName("topic_5");
		topic_5.setCreateAt(new Date(System.currentTimeMillis() - 9*60*1000));
		topic_5.setUpdateAt(new Date(System.currentTimeMillis() - 9*60*1000));
		topic_5.setLastPostAt(new Date(System.currentTimeMillis() - 5*60*1000));
	}
}

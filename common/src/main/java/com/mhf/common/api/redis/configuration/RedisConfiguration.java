package com.mhf.common.api.redis.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.configutation<br/>
 * File Name:PropertiesReaderConfiguration.java<br/>
 * 
 * 作成日 ：2016-4-21 上午10:38:07 <br/>
 * 
 * @author ：junkai.zhang
 */
//@Configuration
public class RedisConfiguration {

	@Bean(name = "jedisPoolConfig")
	public JedisPoolConfig jedisPoolConfigBean() {
		JedisPoolConfig bean = new JedisPoolConfig();
		// Defaults
		bean.setMaxTotal(10);
		bean.setMaxIdle(10);
		bean.setMinIdle(2);
		bean.setMaxWaitMillis(15000);
		bean.setMinEvictableIdleTimeMillis(300000);
		bean.setNumTestsPerEvictionRun(3);
		bean.setTimeBetweenEvictionRunsMillis(60000);
		bean.setTestOnBorrow(true);
		bean.setTestOnReturn(true);
		bean.setTestWhileIdle(true);
		return bean;
	}

	@Value("#{propertiesReader['redis.host']}")
	private String host;
	@Value("#{propertiesReader['redis.port']}")
	private String port;
	@Value("#{propertiesReader['redis.timeout']}")
	private String timeout;
	@Value("#{propertiesReader['redis.database']}")
	private String database;
	@Value("#{propertiesReader['redis.password']}")
	private String password;
	@Value("#{propertiesReader['redis.usePool']}")
	private String usePool;
	@Value("#{propertiesReader['redis.useSsl']}")
	private String useSsl;

	@Bean(name = "jedisConnectionFactoryBean")
	public JedisConnectionFactory jedisConnectionFactoryBean(
			@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory bean = new JedisConnectionFactory();
		// Defaults
		bean.setHostName(host);
		bean.setPort(Integer.valueOf(port));
		bean.setTimeout(Integer.valueOf(timeout));
		bean.setDatabase(Integer.valueOf(database));
		bean.setPassword(password);
		bean.setUsePool(Boolean.valueOf(usePool));
		bean.setUseSsl(Boolean.valueOf(useSsl));
		bean.setPoolConfig(jedisPoolConfig);
		return bean;
	}

	/**
	 * 
	 * redisTemplateBean:redis template definition
	 * p表示对该bean里面的属性进行注入，格式为p:属性名=注入的对象 效果与在bean里面使用<property>标签一样
	 * 
	 * @author junkai.zhang
	 * @param jedisConnectionFactoryBean
	 * @param stringRedisSerializerBean
	 * @param jdkSerializationRedisSerializerBean
	 * @return
	 */
	@Bean(name = "redisTemplateBean")
	public RedisTemplate<String, Object> redisTemplateBean(
			@Qualifier("jedisConnectionFactoryBean") RedisConnectionFactory jedisConnectionFactoryBean,
			@Qualifier("stringRedisSerializerBean") StringRedisSerializer stringRedisSerializerBean,
			@Qualifier("jdkSerializationRedisSerializerBean") JdkSerializationRedisSerializer jdkSerializationRedisSerializerBean) {

		RedisTemplate<String, Object> bean = new RedisTemplate<String, Object>();
		// 序列化方式 建议key/hashKey采用StringRedisSerializer。
		bean.setKeySerializer(stringRedisSerializerBean);
		bean.setHashKeySerializer(stringRedisSerializerBean);

		bean.setValueSerializer(jdkSerializationRedisSerializerBean);
		bean.setHashValueSerializer(jdkSerializationRedisSerializerBean);

		bean.setConnectionFactory(jedisConnectionFactoryBean);
		return bean;
	}

	@Bean(name = "stringRedisSerializerBean")
	public StringRedisSerializer stringRedisSerializerBean() {
		StringRedisSerializer bean = new StringRedisSerializer();
		return bean;
	}

	@Bean(name = "jdkSerializationRedisSerializerBean")
	public JdkSerializationRedisSerializer jdkSerializationRedisSerializerBean() {
		JdkSerializationRedisSerializer bean = new JdkSerializationRedisSerializer();
		return bean;
	}

	/**
	 * 
	 * stringRedisTemplateBean:对string的封装
	 * 
	 * @author junkai.zhang
	 * @param jedisConnectionFactoryBean
	 * @return
	 */
	@Bean(name = "stringRedisTemplateBean")
	public StringRedisTemplate stringRedisTemplateBean(
			@Qualifier("jedisConnectionFactoryBean") RedisConnectionFactory jedisConnectionFactoryBean) {
		StringRedisTemplate bean = new StringRedisTemplate();
		bean.setConnectionFactory(jedisConnectionFactoryBean);
		return bean;
	}

	@Bean(name = "cacheManagerBean")
	public CacheManager cacheManagerBean(@Qualifier("redisTemplateBean") RedisTemplate<String, Object> redisTemplateBean) {
		RedisCacheManager bean = new RedisCacheManager(redisTemplateBean);
		// Number of seconds before expiration. Defaults to unlimited (0)
		// Sets the default expire time
		bean.setDefaultExpiration(3000);
		return bean;
	}

}

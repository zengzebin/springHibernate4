package common.cache;

 

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 以Spring与配置文件来管理的redis缓存配置类
 * @author liuyazhuang
 *
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
	
	private volatile JedisConnectionFactory mJedisConnectionFactory;
	private volatile RedisTemplate<String, Object> mRedisTemplate;
	private volatile RedisCacheManager mRedisCacheManager;
	
	public RedisCacheConfig() {
		super();
	}

	public RedisCacheConfig(JedisConnectionFactory mJedisConnectionFactory, RedisTemplate<String,Object> mRedisTemplate,
			RedisCacheManager mRedisCacheManager) {
		super();
		this.mJedisConnectionFactory = mJedisConnectionFactory;
		RedisSerializer  redisSerializer = new JdkSerializationRedisSerializer();
		mRedisTemplate.setKeySerializer(redisSerializer);
		//mRedisTemplate.setHashKeySerializer(redisSerializer);
	   //	mRedisTemplate.setValueSerializer(redisSerializer);
		this.mRedisTemplate = mRedisTemplate;
		this.mRedisCacheManager = mRedisCacheManager;
	
	}

	public   JedisConnectionFactory redisConnectionFactory() {
		return mJedisConnectionFactory;
	}

	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory cf) {
		return mRedisTemplate;
	}

	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		return mRedisCacheManager;
	}
	
	public RedisTemplate getRedisTemplate(){
		return mRedisTemplate;
	}
	
	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
}

package com.neunzwei.common.api.redis.biz;

import java.util.concurrent.TimeUnit;

public interface IRedisService {

	/**
	 * 
	 * set:设置缓存
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param obj
	 */
	void set(String key, Object obj);

	/**
	 * 
	 * get:获取缓存
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	Object get(String key);

	/**
	 * 
	 * getAndSet:覆盖
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param obj
	 * @return
	 */
	Object getAndSet(String key, Object obj);

	/**
	 * 
	 * expire:设置缓存超时
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param timeout
	 * @param unit
	 * @return
	 */
	Boolean expire(String key, long timeout, TimeUnit unit);

	/**
	 * 
	 * defaultExpire:设置缓存超默认配置 10*60秒
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	Boolean defaultExpire(String key);

	/**
	 * 
	 * getExpire:返回超时剩余时间
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	Long getExpire(String key);

	/**
	 * 
	 * getExpire:返回超时剩余时间，带时间单元
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param unit
	 * @return
	 */
	Long getExpire(String key, TimeUnit unit);

	/**
	 * 
	 * hasExpire:有期限
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	boolean hasExpire(String key);

	/**
	 * 
	 * delete:删除缓存,根据key精确匹配删除
	 * 
	 * @author junkai.zhang
	 * @param key
	 */
	void delete(String... key);

}

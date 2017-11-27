package com.mhf.common.api.redis.biz;

import java.util.concurrent.TimeUnit;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IRedisService {

	/**
	 * 
	 * set:设置缓存
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param obj
	 */
	public void set(String key, Object obj);

	/**
	 * 
	 * get:获取缓存
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * 
	 * getAndSet:覆盖
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param obj
	 * @return
	 */
	public Object getAndSet(String key, Object obj);

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
	public Boolean expire(String key, long timeout, TimeUnit unit);

	/**
	 * 
	 * defaultExpire:设置缓存超默认配置 10*60秒
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	public Boolean defaultExpire(String key);

	/**
	 * 
	 * getExpire:返回超时剩余时间
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	public Long getExpire(String key);

	/**
	 * 
	 * getExpire:返回超时剩余时间，带时间单元
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @param unit
	 * @return
	 */
	public Long getExpire(String key, TimeUnit unit);

	/**
	 * 
	 * hasExpire:有期限
	 * 
	 * @author junkai.zhang
	 * @param key
	 * @return
	 */
	public boolean hasExpire(String key);

	/**
	 * 
	 * delete:删除缓存,根据key精确匹配删除
	 * 
	 * @author junkai.zhang
	 * @param key
	 */
	public void delete(String... key);

}

package com.neunzwei.common.api.frequency.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Frequency {

	/**
	 * 
	 * timeout:超时，默认60S
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	long timeout() default 60L;

	/**
	 * 
	 * limit:次数限制
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	int limit() default 10;

}

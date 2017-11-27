package com.mhf.common.api.jsonwebtoken.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.annotation.authorization<br/>
 * File Name:Authorization.java<br/>
 * 
 * 作成日 ：2017-8-2 上午11:09:54 <br/>
 * 
 * @author ：junkai.zhang
 */
@Documented
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {

	/**
	 * 
	 * validate:是否需要身份验证
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	boolean validate() default true;

	/**
	 * 
	 * type:用户类型
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	int type() default 0; /* //TODO 默认权限 UserConstant.USER;*/

}

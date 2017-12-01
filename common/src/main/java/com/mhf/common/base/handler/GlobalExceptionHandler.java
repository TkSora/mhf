package com.mhf.common.base.handler;

import com.mhf.common.base.constant.BusinessCode;
import com.mhf.common.base.controller.BaseController;
import com.mhf.common.base.entity.JsonContainer;
import com.mhf.common.base.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

	/**
	 * 
	 * handleBusinessException:处理业务错误
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public JsonContainer handleBusinessException(BusinessException e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, e);
		return jsonContainer;
	}

	/**
	 * 
	 * handleNullPointerException:处理空指针异常
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public JsonContainer handleNullPointerException(NullPointerException e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, new BusinessException(BusinessCode.C9998, e));
		return jsonContainer;
	}

//	/**
//	 *
//	 * handleHibernateOptimisticLockingFailureException:数据库操作异常
//	 *
//	 * @author junkai.zhang
//	 * @param e
//	 * @return
//	 */
//	@ExceptionHandler(HibernateOptimisticLockingFailureException.class)
//	@ResponseBody
//	public JsonContainer handleHibernateOptimisticLockingFailureException(HibernateOptimisticLockingFailureException e) {
//		JsonContainer jsonContainer = getJsonContainer();
//		setErrorMessage(jsonContainer, null, new BusinessException(BusinessCode.C9995, e));
//		return jsonContainer;
//	}

	/**
	 * 
	 * handleException:处理未捕获异常
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonContainer handleException(Exception e) {
		JsonContainer jsonContainer = getJsonContainer();
		setErrorMessage(jsonContainer, null, new BusinessException(BusinessCode.C9999, e));
		return jsonContainer;
	}

}

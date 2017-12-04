package com.mhf.common.base.exception;

import com.mhf.common.base.constant.BusinessCode;

public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID:
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = -3947674730197952161L;

	private String code;

	private String message;

	private Object data;

	/*************************************************************************/

	/**
	 * 
	 * convert:转换为BusinessException
	 * 
	 * @author junkai.zhang
	 * @param businessCode
	 * @param e
	 * @return
	 */
	public static BusinessException convert(BusinessCode businessCode, Exception e) {
		if (!(e instanceof BusinessException)) {
			e = new BusinessException(businessCode, e);
		}
		return (BusinessException) e;
	}

	/*************************************************************************/

	public BusinessException(BusinessCode businessCode, Throwable e) {
		super(e);
		this.code = businessCode.getCode();
		this.message = businessCode.getMessage();
	}

	public BusinessException(BusinessCode businessCode, Object[] objArr, Throwable e) {
		super(e);
		this.code = businessCode.getCode();
		this.message = businessCode.getMessageFormat(objArr);
	}

	public BusinessException(String code, String message, Throwable e) {
		super(e);
		this.code = code;
		this.message = message;
	}

	public BusinessException(String code, String message, Object data, Throwable e) {
		super(e);
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/*************************************************************************/

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

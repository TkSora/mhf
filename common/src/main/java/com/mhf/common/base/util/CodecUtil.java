package com.mhf.common.base.util;

import org.apache.commons.codec.digest.DigestUtils;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.util<br/>
 * File Name:SHA1Util.java<br/>
 * 
 * 作成日 ：2017-7-26 上午10:52:57 <br/>
 * 
 * @author ：junkai.zhang
 */
public class CodecUtil {

	/**
	 * 
	 * md5Hex:生成MD5
	 * 
	 * @author junkai.zhang
	 * @param str
	 */
	public static String md5Hex(String str) {
		return DigestUtils.md5Hex(str);
	}

	/**
	 * 
	 * sha1Hex:生成SHA1
	 * 
	 * @author junkai.zhang
	 * @param str
	 * @return
	 */
	public static String sha1Hex(String str) {
		return DigestUtils.sha1Hex(str);
	}

}

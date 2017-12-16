package com.neunzwei.common.base.util;

import org.apache.commons.codec.digest.DigestUtils;

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

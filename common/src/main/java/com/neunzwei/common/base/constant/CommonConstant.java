package com.neunzwei.common.base.constant;

import java.text.SimpleDateFormat;

public class CommonConstant {
    /**
     * system
     */
    public static final String SYSTEM = "system";

    /**
     * 成功
     */
    public static final String SUCCESS = "success";

    /**
     * 失败
     */
    public static final String FAILURE = "failure";

    /**
     * 错误
     */
    public static final String ERROR = "error";

//    /**
//     * 错误日志
//     */
//    public static final Log ERRORDATA = LogFactory.getLog("errordata");
//
//    /**
//     * 框架日志
//     */
//    public static final Log FRAMEWORK = LogFactory.getLog("framework");

    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");

}

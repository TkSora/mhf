package com.mhf.common.api.freemarker.biz.impl;

import com.mhf.common.api.freemarker.biz.IFreeMarkerService;
import com.mhf.common.api.freemarker.util.FreeMarkerUtil;
import com.mhf.common.business.biz.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
//@Component
//@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class FreeMarkerServiceImpl extends BusinessServiceImpl implements IFreeMarkerService {

	@Autowired
	private FreeMarkerUtil util;

	public String getFreeMarkerTemplate(String prefix, String templateName, Map<String, Object> params) {
		return util.getFreeMarkerTemplate(prefix, templateName, params);
	}

}

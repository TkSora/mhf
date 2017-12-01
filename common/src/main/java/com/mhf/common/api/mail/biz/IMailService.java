package com.mhf.common.api.mail.biz;



/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

import com.mhf.common.api.mail.domain.MailData;

/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz<br/>
 * File Name:IEdiInteractiveDetailService.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:39 <br/>
 * 
 * @author ：junkai.zhang
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
public interface IMailService {

	/**
	 * 
	 * sendMail:发送邮件
	 * 
	 * @author junkai.zhang
	 * @param mailData
	 */
	public void sendMail(MailData mailData);
}

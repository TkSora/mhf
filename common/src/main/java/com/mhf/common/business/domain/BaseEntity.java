package com.mhf.common.business.domain;

import javax.persistence.*;
import java.util.Date;

/*****************************************************************************/
/**
 * Project Name:downloadFromGAG<br/>
 * Package Name:com.sbm.module.common.domain<br/>
 * File Name:BaseEntity.java<br/>
 * 
 * 作成日 ：2016-11-11 下午3:50:12 <br/>
 * 
 * @author ：junkai.zhang
 */
@MappedSuperclass
public class BaseEntity {

	@Transient
	private int page = 1;
	@Transient
	private int pageCount = 10;
	@Transient
	private Boolean deleteFlag;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "timestamp")
	private Date created;

	@Column(columnDefinition = "timestamp")
	private Date updated;

	private Integer state;

	@Transient
	private Long count;

	public BaseEntity() {
		super();
	}
	
	public BaseEntity(Long count) {
		super();
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}

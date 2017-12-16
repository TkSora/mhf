package com.neunzwei.mhf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Entity
public class Person {

	@Id
	private Integer id;

	private String username;

	@Transient
	private String email;

	@Transient
	private String text;

}

package com.mhf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Person {

	@Id
	private Integer id;

	private String username;

}

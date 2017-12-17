package com.vijay.dev.ob.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String subDomainName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubDomainName() {
		return subDomainName;
	}
	public void setSubDomainName(String subDomainName) {
		this.subDomainName = subDomainName;
	}
}

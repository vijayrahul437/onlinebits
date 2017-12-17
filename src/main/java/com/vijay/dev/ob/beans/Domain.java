package com.vijay.dev.ob.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Domain {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String domainName;
	private List<SubDomain> subDomains;
	
	
	public List<SubDomain> getSubDomains() {
		return subDomains;
	}
	public void setSubDomains(List<SubDomain> subDomains) {
		this.subDomains = subDomains;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
}

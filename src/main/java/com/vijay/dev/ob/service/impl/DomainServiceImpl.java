package com.vijay.dev.ob.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vijay.dev.ob.beans.Domain;
import com.vijay.dev.ob.beans.Questions;
import com.vijay.dev.ob.service.DomainService;

@Component
public class DomainServiceImpl implements DomainService{

	@Override
	public boolean saveDomain(Questions question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Domain> getAllDomains() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Domain getDomain(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Domain getSubDomain(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveSubDomain(Questions question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Domain> getAllSubDomains() {
		// TODO Auto-generated method stub
		return null;
	}

}

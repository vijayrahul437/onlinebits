package com.vijay.dev.ob.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vijay.dev.ob.beans.Domain;
import com.vijay.dev.ob.beans.Questions;

@Component
public interface DomainService {

	boolean saveDomain(Questions question);

	List<Domain> getAllDomains();

	Domain getDomain(Integer id);

	Domain getSubDomain(Integer id);

	boolean saveSubDomain(Questions question);

	List<Domain> getAllSubDomains();

}

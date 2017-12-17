package com.vijay.dev.ob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vijay.dev.ob.beans.Domain;
import com.vijay.dev.ob.beans.Questions;
import com.vijay.dev.ob.service.DomainService;

@ComponentScan
@Controller
@RequestMapping(path="/service")
public class DomainController {

	@Autowired
	DomainService domainService;
	
	@RequestMapping(path = "/domain", method = RequestMethod.POST)
	public @ResponseBody boolean saveDomain(@RequestBody Questions question) {
		return domainService.saveDomain(question);
	}
	
	@RequestMapping(path = "/domain", method = RequestMethod.GET)
	public @ResponseBody List<Domain> getAllDomains() {
		
		return domainService.getAllDomains();
	}
	
	@RequestMapping(path = "/domain/{id}", method = RequestMethod.GET)
	public @ResponseBody Domain getDomain(@PathVariable Integer id) {
		return domainService.getDomain(id);
	}
	@RequestMapping(path = "/subdomain", method = RequestMethod.POST)
	public @ResponseBody boolean saveSubDomain(@RequestBody Questions question) {
		return domainService.saveSubDomain(question);
	}
	
	@RequestMapping(path = "/subdomain", method = RequestMethod.GET)
	public @ResponseBody List<Domain> getAllSubDomains() {
		
		return domainService.getAllSubDomains();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Domain getSubDomain(@PathVariable Integer id) {
		return domainService.getSubDomain(id);
	}
}

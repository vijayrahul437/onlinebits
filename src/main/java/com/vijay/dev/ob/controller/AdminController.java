package com.vijay.dev.ob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vijay.dev.ob.service.AdminService;

@ComponentScan
@Controller
@RequestMapping(path="/service/admin/")
public class AdminController {
	@Autowired
	AdminService adminService;

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public @ResponseBody boolean login(@RequestBody String loginDetails) {
		return adminService.login(loginDetails);
	}
	
}

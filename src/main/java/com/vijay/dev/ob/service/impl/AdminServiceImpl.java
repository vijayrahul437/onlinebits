package com.vijay.dev.ob.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vijay.dev.ob.beans.Admin;
import com.vijay.dev.ob.dao.AdminDao;
import com.vijay.dev.ob.service.AdminService;
import com.vijay.dev.ob.utils.PasswordHashingUtils;

@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public boolean login(String loginDetails) {
		Boolean isAuthenticated = false;
		JSONObject loginObj = new JSONObject(loginDetails);
		String email = (String) loginObj.get("emailId");
		String password = (String) loginObj.get("password");
		
		String hashedPassword = PasswordHashingUtils.generateHash(password);
		
		Admin admin = adminDao.getAdminDetails(email,password);
		return isAuthenticated;
	}
	

}

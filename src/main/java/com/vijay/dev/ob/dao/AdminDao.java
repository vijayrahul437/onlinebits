package com.vijay.dev.ob.dao;

import org.springframework.stereotype.Component;

import com.vijay.dev.ob.beans.Admin;

@Component
public interface AdminDao {

	boolean login(String email,String password);

	Admin getAdminDetails(String username, String password); 
}

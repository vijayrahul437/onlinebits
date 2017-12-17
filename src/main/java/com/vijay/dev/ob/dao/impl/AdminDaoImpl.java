package com.vijay.dev.ob.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.vijay.dev.ob.beans.Admin;
import com.vijay.dev.ob.beans.Questions;
import com.vijay.dev.ob.dao.AbstractDAO;
import com.vijay.dev.ob.dao.AdminDao;

@Component
public class AdminDaoImpl extends AbstractDAO implements AdminDao{

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin getAdminDetails(String username, String password) {
		CriteriaBuilder builder =  getSession().getCriteriaBuilder();
//		Criteria criteria = getSession().createCriteria(Questions.class);
		CriteriaQuery<Admin> criteria = builder.createQuery(Admin.class);
		Root<Admin> root = criteria.from(Admin.class);
		criteria.select(root);
		//criteria.where(builder.equal(root.get(Admin_.password), password));
       // criteria.add(Restrictions.eq("password", password));
        return getSession().createQuery(criteria).getSingleResult();
	}

	

}

package com.jspider.poc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.poc.dto.RegisterDto;

@Repository
public class ForgotDao {

	@Autowired
	private SessionFactory sessionFactory;

	public ForgotDao() {
		System.out.println(this.getClass().getSimpleName());
	}

	public RegisterDto forgotPassword(String userName) {
		Session s = sessionFactory.openSession();
		String qry = "from RegisterDto where userName=:name";
		Query query = s.createQuery(qry);
		query.setParameter("name", userName);
		RegisterDto fromDb = (RegisterDto) query.uniqueResult();
		return fromDb;
	}
	

	public int updatePassword(String userName,String password) {
		Session s = sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		String qry="update RegisterDto set password=:pwd where userName=:name";
		Query query=s.createQuery(qry);
		query.setParameter("pwd", password);
		query.setParameter("name", userName);
		int fromDb=query.executeUpdate();
		tx.commit();
		return fromDb;
	}
}

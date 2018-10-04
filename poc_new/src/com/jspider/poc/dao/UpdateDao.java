package com.jspider.poc.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.poc.dto.RegisterDto;

@Repository
public class UpdateDao {

	@Autowired
	private SessionFactory factory;
	
	
	public UpdateDao() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	
	public RegisterDto update(RegisterDto dto) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			RegisterDto  dtoFromDb= (RegisterDto) session.merge(dto);
			tx.commit();
			return dtoFromDb;
			
			
			
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}

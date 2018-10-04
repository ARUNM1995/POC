package com.jspider.poc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.poc.dto.LoginDto;
import com.jspider.poc.dto.RegisterDto;

@Repository
public class LoginDao {

	@Autowired
	private SessionFactory factory;

	public RegisterDto login(LoginDto dto) {
		System.out.println(dto);
		Session session = factory.openSession();
		String hql = "from RegisterDto where userName=:user and password=:pwd";
		Query query = session.createQuery(hql);
		query.setParameter("user", dto.getUserName());
		query.setParameter("pwd", dto.getPassword());
		RegisterDto fromDb = (RegisterDto) query.uniqueResult();
		return fromDb;
	}
}

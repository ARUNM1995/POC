package com.jspider.poc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.poc.dto.RegisterDto;
import com.jspider.poc.service.RegisterService;

@Repository
public class RegisterDao {

	@Autowired
	private SessionFactory factory;
	private final static Logger logger = Logger.getLogger(RegisterService.class);
	public RegisterDao() {
		//System.out.println(this.getClass().getSimpleName()+"created");
		logger.info(this.getClass().getSimpleName()+"created");
	}
	public void register(RegisterDto dto) {
		logger.debug("register method of RegisterDao ");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(dto);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}

























/*int a=1;
Long numb=(long) a;
String qry=" from RegisterDto where id=:newid ";
Session session = factory.openSession();
Query query=session.createQuery(qry);
query.setParameter("newid",numb );
RegisterDto dtoFromdb=(RegisterDto) query.uniqueResult();
List<RegisterDto>	 fromDb=query.list();
fromDb.forEach(a->{
	System.out.println(a);
});
System.out.println(dtoFromdb);*/
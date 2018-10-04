package com.jspider.poc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.poc.controller.RegisterController;
import com.jspider.poc.dao.RegisterDao;
import com.jspider.poc.dto.RegisterDto;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;
	private final static Logger logger = Logger.getLogger(RegisterService.class);
	public RegisterService() {
		//System.out.println(this.getClass().getSimpleName()+"created");
		logger.info(this.getClass().getSimpleName()+"created");
	}
	
	public void register(RegisterDto dto) {
		logger.debug("register method of RegisterService class ");
		registerDao.register(dto);
	}
}

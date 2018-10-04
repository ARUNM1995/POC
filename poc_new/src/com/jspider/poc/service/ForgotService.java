package com.jspider.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.poc.dao.ForgotDao;
import com.jspider.poc.dto.RegisterDto;

@Service
public class ForgotService {

	@Autowired
	private ForgotDao forgotDao;

	public RegisterDto forgotPassword(String userName) {
		return forgotDao.forgotPassword(userName);
	}

	public int updatePassword(String userName,String password) {
		return forgotDao.updatePassword(userName, password);
	}

}

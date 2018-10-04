package com.jspider.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.poc.dao.LoginDao;
import com.jspider.poc.dto.LoginDto;
import com.jspider.poc.dto.RegisterDto;

@Service
public class LoginService {
@Autowired
private LoginDao loginDao;
	
	public RegisterDto  login(LoginDto dto) {
		return loginDao.login(dto);
	}
}

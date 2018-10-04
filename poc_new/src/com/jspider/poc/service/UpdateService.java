package com.jspider.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.poc.dao.UpdateDao;
import com.jspider.poc.dto.RegisterDto;

@Service
public class UpdateService {

	@Autowired
	private UpdateDao updateDao;
	
	
	public UpdateService() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	
	public RegisterDto update(RegisterDto dto) {
		 return updateDao.update(dto);
	}
}

package com.jspider.poc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jspider.poc.dto.RegisterDto;
import com.jspider.poc.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	private final static Logger logger = Logger.getLogger(RegisterController.class);
	
	public RegisterController() {
		//System.out.println(this.getClass().getSimpleName()+"created");
		logger.info(this.getClass().getSimpleName()+"created");
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public ModelAndView register(RegisterDto dto) {
		//System.out.println(dto);
		logger.debug("entered register method of RegisterController");
		Long id=(long) 10;
		
		dto.setId(id);
		registerService.register(dto);
		logger.debug("leaving register method of RegisterController");
		return new ModelAndView("login.jsp" ,"msg","registration sucessfull please login");
	}

}

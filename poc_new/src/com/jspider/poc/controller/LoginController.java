package com.jspider.poc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jspider.poc.dto.LoginDto;
import com.jspider.poc.dto.RegisterDto;
import com.jspider.poc.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	

	@RequestMapping("/login.do")
	public ModelAndView login(LoginDto dto,HttpServletRequest req) {
		RegisterDto fromDb = loginService.login(dto);

		if (fromDb != null) {
			req.getSession().setAttribute("dto", fromDb);
			return new ModelAndView("home.jsp");
		} else {
			return new ModelAndView("login.jsp", "msg", "InvalidCrefentials");
		}
		
	}
}

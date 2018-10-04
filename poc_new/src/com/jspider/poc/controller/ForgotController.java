package com.jspider.poc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jspider.poc.dto.RegisterDto;
import com.jspider.poc.service.ForgotService;

@Controller
@RequestMapping("/")
public class ForgotController {

	@Autowired
	private ForgotService forgotService;

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	public ForgotController() {
		System.out.println(this.getClass().getSimpleName());
	}
@RequestMapping("/forgot.do")
	public ModelAndView forgotPassword(HttpServletRequest req) {
		String userName = req.getParameter("userName");
		System.out.println(userName);
		RegisterDto fromDb = forgotService.forgotPassword(userName);
		if (fromDb != null) {
			int idFromDb = forgotService.updatePassword(userName,"newPassword");
			SimpleMailMessage mail=new SimpleMailMessage();
			mail.setFrom("arunkumar.nhce@gmail.com");
			mail.setTo("arunkumar.nhce@gmail.com");
			mail.setSubject("New Password");
			mail.setText("new passowrd= newPassword");
			javaMailSenderImpl.send(mail);
			return new ModelAndView("/forgot.jsp", "msg", "password updated");
		} else {
			return new ModelAndView("/forgot.jsp", "msg", "invalidusername");
		}

	}
}

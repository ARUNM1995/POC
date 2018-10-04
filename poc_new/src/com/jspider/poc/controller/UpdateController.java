package com.jspider.poc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jspider.poc.dto.RegisterDto;
import com.jspider.poc.service.UpdateService;

@Controller
@RequestMapping("/")
public class UpdateController {
	@Autowired
	private UpdateService updateService;

	public UpdateController() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}

	@RequestMapping("/update.do")
	public ModelAndView update(RegisterDto dto, HttpServletRequest req) {
	HttpSession httpSession=req.getSession(false);
		RegisterDto fromSession = (RegisterDto) httpSession.getAttribute("dto");
		dto.setId(fromSession.getId());
		RegisterDto fromDb = updateService.update(dto);
		String message;
		if(fromDb!=null) {
			httpSession.setAttribute("dto", fromDb);
			message="data updated Sucessfully";
		}else {
			message="data failed to updated";
		}
		return new ModelAndView("home.jsp","msg",message);
	}

}

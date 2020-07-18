package com.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.bean.Login;
import com.webapp.dao.DAO;

@Controller
public class MainController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String main(){
		DAO dao=new DAO();
		dao.checkLogin(new Login());
		return "welcome";
	}
}

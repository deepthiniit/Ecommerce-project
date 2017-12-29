package com.niit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DaoImpl.UserDaoImpl;
import com.niit.model.*;

@Controller
public class PageController 
{
	
	
	@RequestMapping("/")
	public String getPage()
	{
		return"index";
	}

	
}


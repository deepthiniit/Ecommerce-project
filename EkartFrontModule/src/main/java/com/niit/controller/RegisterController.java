package com.niit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.UserDao;
import com.niit.model.User;

@Controller
public class RegisterController {

	@Autowired
	UserDao userDao;
   @Autowired
	User user;
	@RequestMapping("/register")
	public String registerUser(Model model) {

		User usersDetail = new User();
		model.addAttribute("usersDetail", usersDetail);
		return "register";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPost(@Valid @ModelAttribute("usersDetail") User usersDetail,
			BindingResult result) {
		
		if (result.hasErrors()) {					
			ModelAndView model=new ModelAndView("customerRegister");
			model.addObject("message", "You have entered invalid details");
			
			System.out.println("Page has errors");
			return model;
		}
		
		List<User> usersDetailList = userDao.getAllUsers();

        for (int i=0; i< usersDetailList.size(); i++) {
        	ModelAndView model=new ModelAndView("customerRegister");
        	if(usersDetail.getEmail().equals(usersDetailList.get(i).getEmail())) {
                model.addObject("emailError", "Email already exists");

                return model;
            }

            if(usersDetail.getName().equals(usersDetailList.get(i).getName())) {
                model.addObject("usernameError", "Username already exists");
                return model;
            }
            if(usersDetail.getPhone().equals(usersDetailList.get(i).getPhone())) {
                model.addObject("userPhoneError", "User phone already exists");
                return model;
            }
        }
		
		usersDetail.setEnabled(true);
		userDao.insertUser(usersDetail);
		ModelAndView model=new ModelAndView("registrationSuccess");
		return model;
	}
	
	
}

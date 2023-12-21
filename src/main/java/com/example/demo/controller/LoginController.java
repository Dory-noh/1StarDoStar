package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class LoginController {
	@Autowired
	private UserService userService;	
	
	@RequestMapping("/login")
    public String viewLogin() {
		return "login";		
	}
	
	@PostMapping("/login")
	public String login(User user, HttpSession session) {
		User findUser = userService.getUser(user);
		if(findUser != null && findUser.getPassword().equals(user.getPassword())){
			 //사용자아이디와 패스워드를 세션에 저장
			session.setAttribute("user", findUser);
			
			return "index";
		}else
			return "login";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserSaveRequestDTO;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}
	
	@PostMapping("/signup")
    public String signup(UserSaveRequestDTO userSaveRequestDTO) {
        String user_id = userService.join(userSaveRequestDTO);
        return "index";
    }
	
}

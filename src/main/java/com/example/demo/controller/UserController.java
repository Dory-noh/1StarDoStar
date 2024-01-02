package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserSaveRequestDTO;
import com.example.demo.entity.User;
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
    public String signup(User user, Model model, UserSaveRequestDTO userSaveRequestDTO) {
		// 필수 항목이 비어있는지 확인
        if (user.getUser_id() == null
        		|| user.getPassword() == null
        		|| user.getName() == null
        		|| user.getEmail() == null
        		|| user.getNickname() == null
        		|| user.getPhone_number() == null) {
            model.addAttribute("error", "모든 항목을 입력해주세요.");
            return "signup"; // 입력이 안 된 경우 회원가입 페이지로 다시 이동
        }

        String user_id = userService.join(userSaveRequestDTO);
        return "redirect:/login";
    }
	
	@RequestMapping("/updateuser")
    public String updateUser() {
		return "updateuser";		
	}
}

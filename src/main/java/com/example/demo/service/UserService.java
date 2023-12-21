package com.example.demo.service;

import com.example.demo.dto.UserSaveRequestDTO;
import com.example.demo.entity.User;

public interface UserService {
	String join(UserSaveRequestDTO userSaveRequestDTO);
	public User getUser(User user);
}

package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSaveRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String join(UserSaveRequestDTO userSaveRequestDTO) {
		User user = User.builder()
				.user_id(userSaveRequestDTO.getUser_id())
				.password(userSaveRequestDTO.getPassword())
				.name(userSaveRequestDTO.getName())
				.email(userSaveRequestDTO.getEmail())
				.nickname(userSaveRequestDTO.getNickname())
				.phone_number(userSaveRequestDTO.getPhone_number())
				.build();
				
		return userRepository.save(user).getUser_id();
	}

	@Override
	public User getUser(User user) {
		Optional<User> findUser = userRepository.findById(user.getUser_id());
		if(findUser.isPresent())
			return findUser.get();
		else
		    return null;
	}

}

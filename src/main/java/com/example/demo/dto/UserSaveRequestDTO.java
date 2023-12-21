package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDTO {

	private String user_id;
	private String password;
	private String name;
	private String email;
	private String nickname;
	private String phone_number;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "UserFormDTO [user_id=" + user_id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", nickname=" + nickname + ", phone_number=" + phone_number + "]";
	}
	
}

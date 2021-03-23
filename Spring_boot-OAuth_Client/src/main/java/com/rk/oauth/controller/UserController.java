package com.rk.oauth.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rk.oauth.domain.User;

@RestController
public class UserController {
	
	@RequestMapping("/getUserList")
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		userList = fetchUser();
		return userList;
	}
	
	private List<User> fetchUser() {
		List<User> users = new ArrayList<User>();

		Gson gson = new Gson(); 
		try 
		{ 
			users = gson.fromJson(new FileReader("C:\\Users\\HP\\Documents\\Spring-Boot-Sample\\Simple-Spring-Boot-Web-App\\src\\main\\resources\\user.json"), ArrayList.class); 
		} 
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
		}
		return users;
	}

}

package com.ShoeShop.Service;

import java.util.List;

import com.ShoeShop.Model.User;

public interface UserService {
	public User getUserById(int id);
	public List<User> getUserByName(String name);
	public List<User> getUserByEmail(String email);
	public List<User> getUserByAge(int age);
	public List<User> getAll();
	

}

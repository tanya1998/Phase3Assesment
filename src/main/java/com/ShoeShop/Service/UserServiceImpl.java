package com.ShoeShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoeShop.Model.User;
import com.ShoeShop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public User getUserById(int id) {
		
		User user = repository.findById(id).get();
		return user;
	}

	@Override
	public List<User> getUserByName(String name) {
		
		return repository.findByName(name);
	}

	@Override
	public List<User> getUserByEmail(String email) {
		
		return repository.findByEmail(email);
	}

	@Override
	public List<User> getUserByAge(int age) {
		
		return repository.findByAge(age);
	}

	@Override
	public List<User> getAll() {
		
		return repository.findAll();
	}

}

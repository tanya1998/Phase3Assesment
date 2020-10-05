package com.ShoeShop.repository;

import org.springframework.stereotype.Repository;

import com.ShoeShop.Model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	public List<User> findByAge(int age);
	public List<User> findByEmail(String email);
	public List<User> findByName(String name);
	

}

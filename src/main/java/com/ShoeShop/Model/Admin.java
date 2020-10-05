package com.ShoeShop.Model;


import org.springframework.stereotype.Component;

@Component
public class Admin {

	private static String id = "admin@shoeshop";
	private static String pwd = "{noop}"+"password";
	
	public String getAdminId() {
		return id;
	}
	public void setPwd(String pwd) {
		Admin.pwd = "{noop}"+pwd;
	}
	public String getPwd() {
		return Admin.pwd;
	}
	
	
}

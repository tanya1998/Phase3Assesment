package com.ShoeShop.Service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ShoeShop.Model.Admin;
import com.ShoeShop.config.WebSecurityConfig;

@Service
public class AdminService  implements UserDetailsService  {
		
	 	@Autowired
		Admin admin = new Admin();
	 	
	 	WebSecurityConfig config;
	 	public void changepwd(String newpwd)
	 	{
	 		admin.setPwd(newpwd);
	 		
	 	}
	 	public String getpwd()
	 	{
	 		return admin.getPwd();
	 	}
		@Transactional
		public Admin authenticate(String adminId, String pwd) {
			if(adminId.equals(admin.getAdminId()) && pwd.equals(admin.getPwd()))
				return admin;
			return null;
		}

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			if(username.equals(admin.getAdminId()))
			{
				List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
				grantList.add(authority);
				UserDetails userDetails = (UserDetails) new User(admin.getAdminId(), //
						admin.getPwd(), grantList);
		 
		        return userDetails;
			}
			else
			{
			    System.out.println("User not found! " + username);
			    throw new UsernameNotFoundException("User " + username + " was not found in the database");
			        
			 
			}
			
		}
		
}
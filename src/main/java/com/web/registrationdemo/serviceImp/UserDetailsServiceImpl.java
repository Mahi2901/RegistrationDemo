package com.web.registrationdemo.serviceImp;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.registrationdemo.model.RegisterModel;
import com.web.registrationdemo.model.RoleModel;
import com.web.registrationdemo.repository.RegisterRepo;



@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService 
{
	
	@Autowired
	RegisterRepo userRepo; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		RegisterModel u=userRepo.findByEmail(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	       
		System.out.println(u.getRoles().toString());
		for (RoleModel role : u.getRoles())
		{
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
	    }

        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(),true, true, true, true, grantedAuthorities);

		}

}

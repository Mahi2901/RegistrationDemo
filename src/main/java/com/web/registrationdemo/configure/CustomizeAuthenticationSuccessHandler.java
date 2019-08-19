package com.web.registrationdemo.configure;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.web.registrationdemo.model.RegisterModel;
import com.web.registrationdemo.repository.RegisterRepo;
	

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler 
{
	@Autowired
	RegisterRepo userRepo;
	
		@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException 
	{
        response.setStatus(HttpServletResponse.SC_OK);
        
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
       
        HttpSession session = request.getSession(false);
        if (session != null) 
        {
        	String user=authentication.getName();
            RegisterModel u=userRepo.findByEmail(user);           
            session.setAttribute("userid", u.getId());
            session.setAttribute("u", u);
            
        }

        
        
        if (roles.contains("ROLE_ADMIN")) 
        {
            response.sendRedirect("/admin");
            
        }else if (roles.contains("ROLE_USER")) 
        {
            response.sendRedirect("/user");
            
        }else 
        {
        	
        }
        
       
		
	}
}

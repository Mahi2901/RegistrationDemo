package com.web.registrationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.registrationdemo.model.RegisterModel;

@Repository
public interface RegisterRepo extends JpaRepository<RegisterModel, Long> 
{
	RegisterModel findByEmail(String email);
	RegisterModel findByResetToken(String resetToken);
}

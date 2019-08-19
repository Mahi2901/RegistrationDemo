package com.web.registrationdemo.service;

import java.util.List;

import com.web.registrationdemo.model.RegisterModel;

public interface RegisterService 
{
	public RegisterModel save(RegisterModel register);
	public Iterable<RegisterModel> findAll();
	public RegisterModel findOne(long rid);
	public void delete(RegisterModel register);
	public  List<RegisterModel> findAll1();
	
}

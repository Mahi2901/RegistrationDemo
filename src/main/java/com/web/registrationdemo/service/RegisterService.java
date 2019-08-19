package com.web.registrationdemo.service;

import com.web.registrationdemo.model.RegisterModel;

public interface RegisterService 
{
	public RegisterModel save(RegisterModel r);
	public Iterable<RegisterModel> findAll();
	public RegisterModel findOne(long id);
	public void delete(RegisterModel s);
	public void delete(long id);

}

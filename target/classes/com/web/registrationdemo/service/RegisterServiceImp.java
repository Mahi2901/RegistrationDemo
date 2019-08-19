package com.web.registrationdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.registrationdemo.model.RegisterModel;
import com.web.registrationdemo.repository.RegisterRepo;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService 
{
	@Autowired
	RegisterRepo registerRepo;

	@Override
	public RegisterModel save(RegisterModel register) {
		// TODO Auto-generated method stub
		return registerRepo.save(register);
	}

	@Override
	public Iterable<RegisterModel> findAll() {
		// TODO Auto-generated method stub
		return registerRepo.findAll();
	}

	@Override
	public RegisterModel findOne(long rid) {
		// TODO Auto-generated method stub
		return registerRepo.findById(rid).orElse(null);
	}

	@Override
	public void delete(RegisterModel register) {
		// TODO Auto-generated method stub
		registerRepo.delete(register);

	}

	@Override
	public List<RegisterModel> findAll1() {
		// TODO Auto-generated method stub
	return registerRepo.findAll();

	}

}

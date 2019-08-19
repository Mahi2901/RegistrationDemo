package com.web.registrationdemo.serviceImp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.registrationdemo.model.RegisterModel;
import com.web.registrationdemo.repository.RegisterRepo;
import com.web.registrationdemo.service.RegisterService;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService {

	@Autowired
	RegisterRepo registerRepo;
	
	@Override
	public RegisterModel save(RegisterModel r) {
		// TODO Auto-generated method stub
		return registerRepo.save(r);
	}

	@Override
	public Iterable<RegisterModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisterModel findOne(long id) {
		// TODO Auto-generated method stub
		return registerRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(RegisterModel s) 
	{
		registerRepo.delete(s);
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		registerRepo.deleteById(id);
	}

}

package com.web.registrationdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.registrationdemo.model.StateModel;


@Repository
public interface Repostate extends JpaRepository<StateModel, Long> {
	
}

package com.web.registrationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.registrationdemo.model.RoleModel;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Long> {

}

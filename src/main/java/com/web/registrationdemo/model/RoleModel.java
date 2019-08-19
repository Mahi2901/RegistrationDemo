package com.web.registrationdemo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class RoleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleid;

	private String rolename;

	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<RegisterModel> users;

	

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<RegisterModel> getUsers() {
		return users;
	}

	public void setUsers(Set<RegisterModel> users) {
		this.users = users;
	}

	
	
}

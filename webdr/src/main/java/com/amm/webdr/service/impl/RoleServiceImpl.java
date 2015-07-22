package com.amm.webdr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amm.webdr.dao.RoleDAO;
import com.amm.webdr.model.Role;
import com.amm.webdr.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional
	public void add(Role object) {
		roleDAO.insert(object);	
	}

	@Transactional
	public List<Role> list() {
		return roleDAO.list();
	}
	
	@Transactional
	public List<Role> list(Boolean active) {
		return roleDAO.list(active);
	}

	@Transactional
	public void remove(Integer id) {
		roleDAO.delete(id);		
	}

	@Transactional
	public Role get(Integer id) {
		return roleDAO.get(id);
	}

	@Transactional
	public void update(Role object) {
		roleDAO.update(object);	
	}
	
	@Transactional
	public Role getByRolename(String rolename){
		return roleDAO.getByRolename(rolename);
	}

	@Transactional
	public void savePrivilegesPerRole(List<Role> roles) {
		for(Role role : roles){
			roleDAO.update(role);
		}
	}
	
	
}

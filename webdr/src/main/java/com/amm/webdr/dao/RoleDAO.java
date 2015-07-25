package com.amm.webdr.dao;

import java.util.List;

import com.amm.webdr.model.Role;

public interface RoleDAO extends GenericDAO<Role>{
	public Role getByRolename(String rolename);
	
	public List<Role> list(Boolean active);
	
	public void deleteAllPrivileges();
}

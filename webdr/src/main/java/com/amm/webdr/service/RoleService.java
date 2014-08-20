package com.amm.webdr.service;

import java.util.List;

import com.amm.webdr.model.Role;

public interface RoleService extends GenericService<Role> {

	Role getByRolename(String rolename);

	List<Role> list(Boolean active);
}

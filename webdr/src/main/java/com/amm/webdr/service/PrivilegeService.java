package com.amm.webdr.service;

import java.util.List;

import com.amm.webdr.model.Privilege;

public interface PrivilegeService extends GenericService<Privilege>{

	Privilege getByPrivilegename(String privilegename);

	List<Privilege> list(Boolean active);
	
}

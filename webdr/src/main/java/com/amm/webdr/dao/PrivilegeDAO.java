package com.amm.webdr.dao;

import java.util.List;

import com.amm.webdr.model.Privilege;

public interface PrivilegeDAO extends GenericDAO<Privilege> {

	Privilege getByPrivilegename(String privilegename);

	List<Privilege> list(Boolean active);

}

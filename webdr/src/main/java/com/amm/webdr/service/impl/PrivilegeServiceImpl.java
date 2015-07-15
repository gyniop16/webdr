package com.amm.webdr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amm.webdr.dao.PrivilegeDAO;
import com.amm.webdr.model.Privilege;
import com.amm.webdr.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	PrivilegeDAO privilegeDAO;
	
	@Transactional
	public void add(Privilege object) {
		privilegeDAO.insert(object);
	}

	@Transactional
	public List<Privilege> list() {
		return privilegeDAO.list();
	}

	@Transactional
	public void remove(Integer id) {
		privilegeDAO.delete(id);
	}

	@Transactional
	public Privilege get(Integer id) {
		return privilegeDAO.get(id);
	}

	@Transactional
	public void update(Privilege object) {
		privilegeDAO.update(object);

	}

	@Transactional
	public Privilege getByPrivilegename(String privilegename) {
		return privilegeDAO.getByPrivilegename(privilegename);
	}

	@Transactional
	public List<Privilege> list(Boolean active) {
		return privilegeDAO.list(active);
	}

}

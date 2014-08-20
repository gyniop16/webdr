package com.amm.webdr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amm.webdr.dao.UserDAO;
import com.amm.webdr.model.User;
import com.amm.webdr.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void add(User object) {
		userDAO.insert(object);
	}

	@Transactional
	public List<User> list() {
		return userDAO.list();
	}

	@Transactional
	public void remove(Integer id) {
		userDAO.delete(id);
	}

	@Transactional
	public User get(Integer id) {
		return userDAO.get(id);
	}

	@Transactional
	public void update(User object) {
		userDAO.update(object);		
	}

	@Transactional
	public User getByUserename(String username) {
		return userDAO.getByUsername(username);
	}

}

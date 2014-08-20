package com.amm.webdr.dao;

import com.amm.webdr.model.User;

public interface UserDAO extends GenericDAO<User>{

	User getByUsername(String username);

}

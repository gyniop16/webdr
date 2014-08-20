package com.amm.webdr.service;

import com.amm.webdr.model.User;

public interface UserService extends GenericService<User> {

	User getByUserename(String username);

}

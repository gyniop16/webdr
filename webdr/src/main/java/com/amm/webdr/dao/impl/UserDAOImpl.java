package com.amm.webdr.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amm.webdr.dao.UserDAO;
import com.amm.webdr.model.Role;
import com.amm.webdr.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void insert(User object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void delete(Integer id) {
		User contact = (User) sessionFactory.getCurrentSession().load(
				User.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}

	public void update(User object) {
		sessionFactory.getCurrentSession().update(object);

	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
	}

	public User get(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().get(
				User.class, id);
		return user;
	}

	public User getByUsername(String username) {
		User user = null; 
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("getUserByUsername");
		query.setParameter("username", username);
		List<User> users =	(List<User>)query.list();
		if(users != null && users.size() > 0){
			user = users.get(0);
		}
		return user;
	}
}

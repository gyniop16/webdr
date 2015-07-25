package com.amm.webdr.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amm.webdr.dao.RoleDAO;
import com.amm.webdr.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void insert(Role contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public void delete(Integer id) {
		Role contact = (Role) sessionFactory.getCurrentSession().load(
				Role.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}

	public void update(Role contact) {
		sessionFactory.getCurrentSession().update(contact);
	}

	public List<Role> list() {
		return sessionFactory.getCurrentSession().createQuery("from Role")
                .list();
	}

	public List<Role> list(Boolean active) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Role where active = :active ");
		query.setParameter("active", active);
		return query.list();
	}
	
	public Role get(Integer id) {
		Role contact = (Role) sessionFactory.getCurrentSession().get(
				Role.class, id);
		return contact;
	}
	
	public Role getByRolename(String rolename) {
		Role contact = null; 
				
		Query query = sessionFactory.getCurrentSession().getNamedQuery("getRoleByRolename");
		query.setParameter("rolename", rolename);
		List<Role> roles =	(List<Role>)query.list();
		if(roles != null && roles.size() > 0){
			contact = roles.get(0);
		}
		return contact;
	}
	
	public void deleteAllPrivileges(){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("deleteAllPrivileges");
		query.executeUpdate();
	}
}

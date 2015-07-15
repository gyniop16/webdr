package com.amm.webdr.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amm.webdr.dao.PrivilegeDAO;
import com.amm.webdr.model.Privilege;

@Repository
public class PrivilegeDAOImpl implements PrivilegeDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void insert(Privilege object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void delete(Integer id) {
		Privilege contact = (Privilege) sessionFactory.getCurrentSession().load(
				Privilege.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}

	public void update(Privilege object) {
		sessionFactory.getCurrentSession().update(object);
	}

	public List<Privilege> list() {
		return sessionFactory.getCurrentSession().createQuery("from Privilege")
                .list();
	}

	public Privilege get(Integer id) {
		Privilege contact = (Privilege) sessionFactory.getCurrentSession().get(
				Privilege.class, id);
		return contact;
	}

	public Privilege getByPrivilegename(String privilegename) {
		Privilege contact = null; 
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("getPrivilegeByPrivilegename");
		query.setParameter("privilegename", privilegename);
		List<Privilege> privileges =	(List<Privilege>)query.list();
		if(privileges != null && privileges.size() > 0){
			contact = privileges.get(0);
		}
		return contact;
	}

	public List<Privilege> list(Boolean active) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Privilege where active = :active ");
		query.setParameter("active", active);
		return query.list();
	}

}

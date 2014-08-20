package com.amm.webdr.dao;

import java.util.List;

public interface GenericDAO<T>{
	public void insert(T object);
	public void delete(Integer id);
	public void update(T object);
    public List<T> list();    
	public T get(Integer id);
}

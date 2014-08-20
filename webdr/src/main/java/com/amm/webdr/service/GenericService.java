package com.amm.webdr.service;

import java.util.List;

public interface GenericService<T> {
	public void add(T object);
    public List<T> list();
    public void remove(Integer id);
    public T get(Integer id);
	public void update(T object);
}

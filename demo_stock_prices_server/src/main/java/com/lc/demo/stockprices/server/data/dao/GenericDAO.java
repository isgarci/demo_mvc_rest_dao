package com.lc.demo.stockprices.server.data.dao;

import java.util.List;

public interface GenericDAO<K, T> 
{
    public T find(K id);
    public List<T> findAll();
    public K create(T value);
    public void update(T value);
    public void delete(K id);
}
		

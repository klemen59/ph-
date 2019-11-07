package fr.formation.inti.dao;

import java.io.Serializable;
import java.util.List;




public interface IGenericDao<T, I extends Serializable> {

	
	public List<T> getAll();
	
	public void persist(T e);
	
	
	public I save(T e);
	
	
	public void update(T e);
	
	public void delete(T e);
	
	public void deleteByID(I id);
	
	public T findById(I id);
	
	
	public void close();

	
}

package net.slipp.support;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

public abstract class CustomJpaDao<E> {
	@Autowired
	private ObjectifyFactory objectifyFactory;
	
	private Class<E> persistenceClass = null;

	@SuppressWarnings("unchecked")
	public CustomJpaDao() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		persistenceClass = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	public void setObjectifyFactory(ObjectifyFactory objectifyFactory) {
		this.objectifyFactory = objectifyFactory;
	}
	
	public Class<E> getPersistenceClass() {
		return persistenceClass;
	}
	
	public void put(E entity) {
		getObjectify().put(entity);
	}
	
	public void put(E... entity) {
		getObjectify().put(entity);
	}
	
	public void delete(Long id) {
		getObjectify().delete(getPersistenceClass(), id);
	}
	
	protected Objectify getObjectify() {
		return objectifyFactory.begin();
	}
	
	public E findById(Long id) {
		return getObjectify().find(getPersistenceClass(), id);
	}
	
	@SuppressWarnings({ "unchecked" })
	public E findByKey(Key<?> key) {
		return (E)getObjectify().find(key);
	}
	
	public List<E> findAll() {
		return getObjectify().query(getPersistenceClass()).list();
	}
}

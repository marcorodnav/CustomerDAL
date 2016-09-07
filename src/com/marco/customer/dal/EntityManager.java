package com.marco.customer.dal;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marco.customer.dal.interfaces.IBaseDAO;
import com.marco.customer.dal.interfaces.IEntityManager;

public class EntityManager implements Serializable, IEntityManager {

	// Atributos

	private static final long serialVersionUID = -270524853480037420L;

	@SuppressWarnings("rawtypes")
	private LinkedHashMap<String, IBaseDAO> persistenceMap;

	// Constructores

	@SuppressWarnings("rawtypes")
	public EntityManager() {
		persistenceMap = new LinkedHashMap<String, IBaseDAO>();
	}

	// Metodos

	@SuppressWarnings({ "unchecked" })
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends BaseDO> void persist(T o) {
		this.getPersistenceMap().get(o.getClass().getName()).persist(o);
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends BaseDO> void delete(T o) {
		this.getPersistenceMap().get(o.getClass().getName()).delete(o);
	}

	@SuppressWarnings({ "unchecked" })
	public <T extends BaseDO, K> T findById(String className, K o) {
		return (T) this.getPersistenceMap().get(className).findById(o);
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends BaseDO> void merge(T o) {
		this.getPersistenceMap().get(o.getClass().getName()).merge(o);
	}

	@SuppressWarnings({ "unchecked" })
	public <T extends BaseDO> List<T> findAll(String className) {
		return this.getPersistenceMap().get(className).findAll();
	}

	@SuppressWarnings("rawtypes")
	public LinkedHashMap<String, IBaseDAO> getPersistenceMap() {
		return persistenceMap;
	}

	@SuppressWarnings("rawtypes")
	public void setPersistenceMap(LinkedHashMap<String, IBaseDAO> persistenceMap) {
		this.persistenceMap = persistenceMap;
	}

}

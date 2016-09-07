package com.marco.customer.dal.interfaces;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marco.customer.dal.BaseDO;

public interface IEntityManager {

	/**
	 * Salvar Entidad
	 * 
	 * @param <T>
	 * @param o
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract <T extends BaseDO> void persist(T o);

	/**
	 * Actualizar Entidad
	 * 
	 * @param <T>
	 * @param o
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract <T extends BaseDO> void merge(T o);

	/**
	 * Borrar Entidad
	 * 
	 * @param <T>
	 * @param o
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract <T extends BaseDO> void delete(T o);

	/**
	 * Buscar por Id
	 * 
	 * @param <T>
	 * @param <K>
	 * @param className
	 * @param o
	 * @return
	 */
	public abstract <T extends BaseDO, K> T findById(String className, K o);

	/**
	 * Recuperar Todos
	 * 
	 * @param <T>
	 * @param className
	 * @return
	 */
	public abstract <T extends BaseDO> List<T> findAll(String className);

	/**
	 * Get del map de persistencia
	 * 
	 * @return
	 */

	@SuppressWarnings("rawtypes")
	public abstract LinkedHashMap<String, IBaseDAO> getPersistenceMap();

	/**
	 * Set del map de persistencia
	 * 
	 * @param persistenceMap
	 */
	@SuppressWarnings("rawtypes")
	public abstract void setPersistenceMap(LinkedHashMap<String, IBaseDAO> persistenceMap);
}

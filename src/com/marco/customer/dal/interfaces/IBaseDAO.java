package com.marco.customer.dal.interfaces;

import java.util.List;

/**
 * Interface que implementan todos los objetos de acceso a datos
 * Recibe como parametros la entidad de negocio y la llave primaria de la misma
 * 
 * @author lsanabria
 *
 * @param <T>
 * @param <K>
 */
public interface IBaseDAO<T,K> {
	
	/**
	 * Guarda la entidad 
	 * @param o - Entidad a persistir
	 */
	public abstract void persist(T o);
	
	/**
	 * Actualiza la entidad
	 * @param o - entidad a actualizar
	 * @return 
	 */
	public abstract T merge(T o);
	
	/**
	 * Borra la entidad
	 * @param o	- entidad a borrar
	 */
	public abstract void delete(T o);	

	/**
	 * Busca la entidad por llave primaria
	 * @param o - llave primaria de la entidad a buscar
	 * @return
	 */
	public abstract T findById(K o);
	
	/**
	 * Lista todas las entidades
	 * @return
	 */
	public abstract List<T> findAll();
}
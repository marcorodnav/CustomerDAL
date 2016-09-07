package com.marco.customer.dal;

import java.io.Serializable;

/**
 * Clase base para las entidades
 * 
 * @author lsanabria
 *
 */
public class BaseDO implements Serializable {

	/**
	 * propiedad de serializacion
	 */
	private static final long serialVersionUID = 5090697068549050345L;

	/**
	 * propiedad utilizada para almacenar el usuario que realiza modificaciones
	 * sobre la entidad (mecanismo de auditoria)
	 */
	private String usuario;

	// Metodos de acceso

	/**
	 * 
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}

package com.marco.customer.dal;
// Generated 06/09/2016 09:29:58 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;

import javax.naming.InitialContext;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.marco.customer.dal.interfaces.IBaseDAO;

/**
 * Home object for domain model class Customers.
 * @see com.marco.customer.Customers
 * @author Hibernate Tools
 */
@Transactional
public class CustomersDAO implements IBaseDAO<Customers,Integer>{

	private static final Logger log = LoggerFactory.getLogger(CustomersDAO.class);

	private SessionFactory sessionFactory = getSessionFactory();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Customers transientInstance) {
		log.debug("persisting Customers instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Customers instance) {
		log.debug("attaching dirty Customers instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customers instance) {
		log.debug("attaching clean Customers instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Customers persistentInstance) {
		log.debug("deleting Customers instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customers merge(Customers detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customers result = (Customers) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customers findById(java.lang.Integer id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customers instance = (Customers) sessionFactory.getCurrentSession().get("com.marco.customer.dal.Customers", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Customers> findByExample(Customers instance) {
		log.debug("finding Customers instance by example");
		try {
			List<Customers> results = (List<Customers>)sessionFactory.getCurrentSession().createCriteria("com.marco.customer.dal.Customers")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Customers> findAll() {
		log.debug("finding all Customers instances");
		try {
			String queryString = "from Customers";
			List<Customers> results = (List<Customers>)sessionFactory
					.getCurrentSession()
					.createQuery(queryString).list();
			log.debug("find all succesful, result size: "+ results.size());
			return results;
		} catch(RuntimeException re){
			log.error("find all failed"+ re);
			throw re;
		}
	}
}

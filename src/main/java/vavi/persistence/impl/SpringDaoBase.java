/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;

import vavi.persistence.Dao;
import vavi.persistence.Entity;


/**
 * SpringDaoBase.
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070206 nsano initial version <br>
 */
public abstract class SpringDaoBase<E extends Entity<I>, I extends Serializable>
    extends DaoBase<E, I> implements Dao<E, I> {

    /** */
    private JpaTemplate jpaTemplate;

    /** @see SpringDaoFactory */
    @PersistenceContext
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.jpaTemplate = new JpaTemplate(entityManagerFactory);
    }

    /* */
    public void persist(E entity) {
        jpaTemplate.persist(entity);
    }

    /* */
    public void merge(E entity) {
        jpaTemplate.merge(entity);
    }

    /* */
    public void remove(E entity) {
        jpaTemplate.remove(entity);
    }

    /* */
    public E find(I id) {
        return jpaTemplate.find(getEntityClass(), id);
    }

    /* */
    public boolean contains(E entity) {
        return jpaTemplate.contains(entity);
    }

    /* */
    public void flush() {
        jpaTemplate.flush();
    }

    /* */
    public E getReference(I primaryKey) {
        return jpaTemplate.getReference(getEntityClass(), primaryKey);
    }

    /* */
    public void refresh(E entity) {
        jpaTemplate.refresh(entity);
    }

    /** TODO JpaCallback is SpringFramework specific */
//    public Object execute(JpaCallback action) {
//        return jpaTemplate.execute(action);
//    }

    /** TODO JpaCallback is SpringFramework specific */
//    public Object execute(JpaCallback action, boolean exposeNativeEntityManager) {
//        return jpaTemplate.execute(action, exposeNativeEntityManager);
//    }

    /** TODO JpaCallback is SpringFramework specific */
//    public List<E> executeFind(JpaCallback action) {
//        return jpaTemplate.executeFind(action);
//    }

    /* */
    public int execute(final String queryString) {
        Integer count = Integer.class.cast(jpaTemplate.execute(new JpaCallback() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                Query query = entityManager.createQuery(queryString);
                return query.executeUpdate();
            }
        }));
        return count.intValue();
    }

    /* */
    public int execute(final String queryString, final Object ... params) {
        Integer count = Integer.class.cast(jpaTemplate.execute(new JpaCallback() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                Query query = entityManager.createQuery(queryString);
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i + 1, params[i]);
                }
                return query.executeUpdate();
            }
        }));
        return count.intValue();
    }

    /* */
    public int executeByNamedParams(final String queryString, Map<String, ? extends Object> params) {
        Integer count = Integer.class.cast(jpaTemplate.execute(new JpaCallback() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                Query query = entityManager.createQuery(queryString);
                return query.executeUpdate();
            }
        }));
        return count.intValue();
    }

    /* */
    public List<E> find(String queryString) {
        return jpaTemplate.find(queryString);
    }

    /* */
    public List<E> find(String queryString, Object ... params) {
        return jpaTemplate.find(queryString, params);
    }

    /* */
    public List<E> findByNamedParams(String queryString, Map<String, ? extends Object> params) {
        return jpaTemplate.findByNamedParams(queryString, params);
    }

    /* */
    public List<E> findByNamedQuery(String queryName) {
        return jpaTemplate.findByNamedQuery(queryName);
    }

    /* */
    public List<E> findByNamedQuery(String queryName, Object ... params) {
        return jpaTemplate.findByNamedQuery(queryName, params);
    }

    /* */
    public List<E> findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params) {
        return jpaTemplate.findByNamedQueryAndNamedParams(queryName, params);
    }

    /* */
    public void setHints(Map<String, ? extends Object> hints) {
        // TODO cache
        // TODO offset, limit
    }
}

/* */

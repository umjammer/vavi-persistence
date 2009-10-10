/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence.impl;

import java.io.Serializable;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import vavi.persistence.Dao;
import vavi.persistence.Entity;


/**
 * SpringDaoFactoryBean.
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070207 nsano initial version <br>
 */
public class SpringDaoFactoryBean<E extends Entity<I>, I extends Serializable>
    implements FactoryBean, InitializingBean {

    /** property */
    private DaoFactory daoFactory;

    /** property */
    private Class<E> entityClass;

    /** object */
    private Dao<E, I> dao = null;

    /** */
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /** */
    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /** */
    public Object getObject() throws Exception {
        return dao;
    }

    /** */
    public Class<?> getObjectType() {
        return Dao.class;
    }

    /** */
    public boolean isSingleton() {
        return true;
    }

    /** */
    public void afterPropertiesSet() throws Exception {
        try {
            dao = daoFactory.createDao(entityClass);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}

/* */

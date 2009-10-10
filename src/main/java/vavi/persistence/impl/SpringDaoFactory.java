/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence.impl;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import vavi.persistence.Dao;
import vavi.persistence.Entity;


/**
 * SpringDaoFactory.
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070206 nsano initial version <br>
 */
public class SpringDaoFactory implements DaoFactory {

    /** */
    private EntityManagerFactory entityManagerFactory;

    /** for DI */
    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    /** */
    public <E extends Entity<I>, I extends Serializable> Dao<E, I> createDao(final Class<E> entityClass) {
        SpringDaoBase<E, I> springDaoBase = new SpringDaoBase<E, I>() {
            @Override
            protected Class<E> getEntityClass() {
                return entityClass;
            }
        };
        springDaoBase.setEntityManagerFactory(entityManagerFactory);
        return springDaoBase;
    }
}

/* */

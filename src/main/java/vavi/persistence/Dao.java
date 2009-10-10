/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;


/**
 * DAOを表すインターフェース。
 * 
 * @param <E> エンティティの型
 * @param <I> エンティティのIDフィールドの型
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070206 nsano initial version <br>
 */
public interface Dao<E extends Entity<I>, I extends Serializable> {

    /** @see EntityManager */
    void persist(E entity);

    /** @see EntityManager */
    void merge(E entity);

    /** @see EntityManager */
    void remove(E entity);

    /** @see EntityManager */
    E find(I primaryKey);

    /* */
    int execute(String queryString);

    /* */
    int execute(String queryString, Object ... params);

    /* */
    int executeByNamedParams(final String queryString, Map<String, ? extends Object> params);

    /** */
    List<E> find(String queryString);

    /** */
    List<E> find(String queryString, Object ... params);

    /** */
    List<E> findByNamedParams(String queryString, Map<String, ? extends Object> params);

    /** */
    List<E> findByNamedQuery(String queryName);

    /** */
    List<E> findByNamedQuery(String queryName, Object ... params);

    /** */
    List<E> findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params);

    /** */
    void setHints(Map<String, ? extends Object> hints);
}

/* */

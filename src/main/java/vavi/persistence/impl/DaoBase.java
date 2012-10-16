/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence.impl;

import java.io.Serializable;

import vavi.persistence.Dao;
import vavi.persistence.Entity;


/**
 * DaoBase.
 * <li> TODO Dao と統合してもいいけど {@link #getEntityClass()} を protected にしたいがため...
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070206 nsano initial version <br>
 */
public abstract class DaoBase<E extends Entity<I>, I extends Serializable>
    implements Dao<E, I> {

    /** */
    protected abstract Class<E> getEntityClass();

    /** */
    public E newInstance() {
        try {
            return getEntityClass().newInstance();
        } catch (Exception e) {
            throw (RuntimeException) new IllegalStateException().initCause(e);
        }
    }
}

/* */

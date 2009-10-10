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
 * �G���e�B�e�B��\�����N���X�B
 * {@link Dao} �ň����G���e�B�e�B��\�����N���X�ł��B
 *
 * @param <I> ID�t�B�[���h�̌^
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070206 nsano initial version <br>
 */
public abstract class EntityBase<I extends Serializable> implements Entity<I> {

    /* */
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        } else {
            return super.hashCode();
        }
    }

    /* */
    public boolean equals(Object object) {
        if (object == null || !(this.getClass().isInstance(object))) {
            return false;
        } else {
            return this.hashCode() == object.hashCode();
        }
    }
}

/* */

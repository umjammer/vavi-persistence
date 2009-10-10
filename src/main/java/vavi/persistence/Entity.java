/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence;

import java.io.Serializable;


/**
 * エンティティを表すインターフェース。
 * {@link Dao} で扱うエンティティを表すインターフェースです。
 *
 * @param <I> IDフィールドの型
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 070206 nsano initial version <br>
 */
public interface Entity<I extends Serializable> extends Serializable {
    /** */
    I getId();

    /** */
    void setId(I id);
}

/* */

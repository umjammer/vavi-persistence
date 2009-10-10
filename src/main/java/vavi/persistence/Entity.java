/*
 * Copyright (c) 2007 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.persistence;

import java.io.Serializable;


/**
 * �G���e�B�e�B��\���C���^�[�t�F�[�X�B
 * {@link Dao} �ň����G���e�B�e�B��\���C���^�[�t�F�[�X�ł��B
 *
 * @param <I> ID�t�B�[���h�̌^
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entites;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import javax.persistence.Version;

/**
 *
 * @author Ekue_Weledji
 */
@MappedSuperclass
public abstract class BaseEntite implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Version
    private int version = 1;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}

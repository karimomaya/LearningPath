package com.learning.system.Attribute;

import javax.persistence.Transient;

/**
 * Created by karim on 4/16/20.
 */
public interface StatusAttribute extends SystemAttribute {
    boolean isActive = true;
    @Transient
    int status = -1;
}

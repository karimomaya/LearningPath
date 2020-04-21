package com.learning.system.Attribute;

import com.learning.model.Account;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by karim on 4/16/20.
 */
public interface ModificationSystemAttribute extends SystemAttribute {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifiedBy")
    Account modifiedBy = null;
    Date modifiedDate = new Date();
}

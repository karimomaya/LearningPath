package com.learning.repository;

import com.learning.model.FootPrint;
import com.learning.model.Organization;

import java.util.Optional;

/**
 * Created by karim on 4/16/20.
 */
public interface FootPrintRepository extends GenericRepository<FootPrint, Long> {

    Optional<FootPrint> findAllByFootPrintCatAndOrg(long cat, Organization org);
}

package com.learning.repository;

import com.learning.model.Organization;

import java.util.Optional;

/**
 * Created by karim on 4/17/20.
 */
public interface OrganizationRepository extends GenericRepository<Organization, Long> {
    public Optional<Organization> findByOrgName(String orgName);
}

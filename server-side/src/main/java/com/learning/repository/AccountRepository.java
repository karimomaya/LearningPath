package com.learning.repository;

import com.learning.model.Account;
import com.learning.model.Organization;

import java.util.Optional;

/**
 * Created by karim on 4/18/20.
 */
public interface AccountRepository extends GenericRepository<Account,Long> {
    public Optional<Account> findByUsername(String username);
    public Optional<Account> findByEmailOrUsername(String email, String username);
    public Optional<Account> findByEmail(String email);
}

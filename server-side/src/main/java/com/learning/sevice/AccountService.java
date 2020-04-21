package com.learning.sevice;

import com.learning.model.Account;
import com.learning.model.Organization;
import com.learning.repository.AccountRepository;
import com.learning.system.exception.AlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by karim on 4/18/20.
 */
@Service("userDetailsService")
public class AccountService extends SystemService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SystemDataService systemDataService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        Account account = null;
        if (accountOptional.isPresent()) account= accountOptional.get();


        return null;
    }

    @Override
    public Object save(Object object) throws AlreadyExistException {

        Organization creationalOrg = ((Account) object).getOrg();


        Optional<Account> accountOptional = accountRepository.findByEmail(((Account)object).getEmail());
        if (accountOptional.isPresent()){
            throw new AlreadyExistException("Email Already Exist");
        }

        accountOptional = accountRepository.findByUsername(((Account)object).getUsername());
        if (accountOptional.isPresent()){
            throw new AlreadyExistException("Username Already Exist");
        }

        object = super.save(object);
        ((Account) object).setPassword(bCryptPasswordEncoder.encode(((Account) object).getPassword()));
        return accountRepository.save((Account) object);

    }

    @Override
    public Object save(Object object, Account account) throws AlreadyExistException {
        object =  super.save(object, account);
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        accountRepository.save((Account) object);
        return object;
    }

}
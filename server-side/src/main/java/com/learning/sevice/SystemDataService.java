package com.learning.sevice;

import com.learning.model.Account;
import com.learning.model.Organization;
import com.learning.repository.AccountRepository;
import com.learning.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by karim on 4/17/20.
 */
@Service
public class SystemDataService {
    private static Account account;
    private static Organization org;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OrganizationRepository orgRepository;



    public Account getUser(){
        if (this.account != null) {
            return this.account;
        }

        Optional<Account> accountOptional = accountRepository.findByEmail("shared@learningpath.com");
        if (accountOptional.isPresent()) {
            this.account= accountOptional.get();
        }
        return this.account;
    }


    public Organization getOrg(){
        if (this.org != null){
            return this.org;
        }
        Optional<Organization> orgOptional = orgRepository.findByOrgName("shared");
        if (orgOptional.isPresent()){
            this.org = orgOptional.get();
        }
        return this.org;

    }

}

package com.learning.sevice;

import com.learning.model.Account;
import com.learning.model.Organization;
import com.learning.repository.OrganizationRepository;
import com.learning.system.exception.AlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karim on 4/17/20.
 */
@Service
public class OrganizationService extends SystemService {

    @Autowired
    OrganizationRepository orgRepository;

    @Override
    public Object save(Object object, Account account) {
        try {
            object =  super.save(object, account);
        } catch (AlreadyExistException e) {
            e.printStackTrace();
        }
        orgRepository.save((Organization) object);
        return object;
    }
}

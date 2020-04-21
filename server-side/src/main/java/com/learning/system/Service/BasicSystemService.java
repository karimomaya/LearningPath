package com.learning.system.Service;

import com.learning.model.Account;
import com.learning.system.exception.AlreadyExistException;

/**
 * Created by karim on 4/16/20.
 */
public interface BasicSystemService {
    Object save(Object object) throws AlreadyExistException;
    Object save(Object object, Account account) throws AlreadyExistException;
    Object update(Object object);
    boolean delete(Object object);
    Object read(int id);
}

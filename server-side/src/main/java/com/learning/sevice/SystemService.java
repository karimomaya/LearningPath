package com.learning.sevice;

import com.learning.model.Account;
import com.learning.model.FootPrint;
import com.learning.model.FootPrintAction;
import com.learning.repository.FootPrintActionRepository;
import com.learning.repository.FootPrintRepository;
import com.learning.system.FootPrintKeys;
import com.learning.system.Service.BasicSystemService;
import com.learning.system.exception.AlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;


/**
 * Created by karim on 4/16/20.
 */
public abstract class SystemService implements BasicSystemService {

    @Autowired
    FootPrintRepository footPrintRepository;
    @Autowired
    FootPrintActionRepository footPrintActionRepository;
    @Autowired
    SystemDataService systemDataService;

    @Override
    public Object save(Object object) throws AlreadyExistException {

        Optional<FootPrint> footPrintOptional = footPrintRepository.findAllByFootPrintCatAndOrg(FootPrintKeys.CREATE.val(), systemDataService.getOrg());
        if (footPrintOptional.isPresent()) {
            createFootPrintAction(footPrintOptional.get(), systemDataService.getUser() ,FootPrintKeys.CREATE.name()  + " " + object.getClass().getSimpleName());
        }
        return object;

    }

    public void createFootPrintAction(FootPrint footPrint, Account performer, String actionName) {
        FootPrintAction footPrintAction = new FootPrintAction();
        footPrintAction.setFootPrint(footPrint);
        footPrintAction.setDescription(actionName);
        footPrintAction.setAccount(performer);
        footPrintAction.setCreatedDate(new Date());
        footPrintActionRepository.save(footPrintAction);
    }


    @Override
    public Object save(Object object, Account account) throws AlreadyExistException {

        Optional<FootPrint> footPrintOptional = footPrintRepository.findAllByFootPrintCatAndOrg(FootPrintKeys.CREATE.value(), account.getOrg());

        if (footPrintOptional.isPresent()) {
            createFootPrintAction( footPrintOptional.get(), account, FootPrintKeys.CREATE.name() + " " + object.getClass().getSimpleName());
        }

        return object;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public Object read(int id) {
        return null;
    }


    public void setFootPrintRepository(FootPrintRepository footPrintRepository){
        this.footPrintRepository = footPrintRepository;
    }


}

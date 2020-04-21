package com.learning.controller;

import com.learning.model.Account;
import com.learning.sevice.AccountService;
import com.learning.sevice.ErrorLogService;
import com.learning.system.ErrorLogSourceKeys;
import com.learning.system.ResponseBuilder;
import com.learning.system.StatusCodeKeys;
import com.learning.system.exception.AlreadyExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by karim on 4/15/20.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class AccountController {
    @Autowired
    ErrorLogService errorLogService;
    @Autowired
    AccountService accountService;
    @PostMapping("/save")
    public ResponseBuilder<Account> saveObject( @RequestBody Account account) {
        ResponseBuilder<Account> responseBuilder = new ResponseBuilder<>();
        try {
            account = (Account) accountService.save(account);
            responseBuilder.setData(account);
        } catch (AlreadyExistException e) {
            errorLogService.warn(ErrorLogSourceKeys.BACKEND, e.getMessage());

            responseBuilder.setStatus(StatusCodeKeys.CONFLICT);
            if (e.getMessage().equals("Email Already Exist"))
                responseBuilder.setStatus(StatusCodeKeys.EMAIL_CONFLICT);
        }
        return responseBuilder.build();
    }

    @GetMapping("/get")
    public ResponseBuilder<Account> get() throws Exception {
//        userService.save(user, user);
        System.out.print("test");
        return null;

    }


}

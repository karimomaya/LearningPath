package com.learning.controller;

import com.learning.sevice.ErrorLogService;
import com.learning.system.ErrorLogSourceKeys;
import com.learning.system.ResponseBuilder;
import com.learning.system.StatusCodeKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by karim on 4/21/20.
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/log")
public class ErrorLogController {
    @Autowired
    ErrorLogService errorLogService;

    @GetMapping("/error/{message}")
    public ResponseBuilder<String> error(@PathVariable("message") String message) {
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>();
        errorLogService.error(ErrorLogSourceKeys.FRONTEND, message);
        return responseBuilder.setData("SUCCESS").setStatus(StatusCodeKeys.SUCCESS).build();
    }

    @GetMapping("/info/{message}")
    public ResponseBuilder<String> info(@PathVariable("message") String message) {
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>();
        errorLogService.info(ErrorLogSourceKeys.FRONTEND, message);
        return responseBuilder.setData("SUCCESS").setStatus(StatusCodeKeys.SUCCESS).build();
    }
}

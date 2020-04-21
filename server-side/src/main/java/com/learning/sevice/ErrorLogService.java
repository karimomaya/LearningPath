package com.learning.sevice;

import com.learning.model.ErrorLog;
import com.learning.repository.ErrorLogRepository;
import com.learning.system.ErrorLogSourceKeys;
import com.learning.system.ErrorLogTypeKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karim on 4/21/20.
 */
@Service
public class ErrorLogService {
    @Autowired
    ErrorLogRepository errorLogRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void warn(ErrorLogSourceKeys errorLogSourceKeys, String message) {
        String type = "BACK-END";
        if (errorLogSourceKeys.value()){
            type = "FRONT-END";
        }
        log.warn(type + message);
        save(errorLogSourceKeys, ErrorLogTypeKeys.WARN, message);
    }

    public void info(ErrorLogSourceKeys errorLogSourceKeys, String message) {
        String type = "BACK-END";
        if (errorLogSourceKeys.value()){
            type = "FRONT-END";
        }
        log.info(type + message);
        save(errorLogSourceKeys, ErrorLogTypeKeys.INFO, message);
    }

    public void error(ErrorLogSourceKeys errorLogSourceKeys, String message) {
        String type = "BACK-END";
        if (errorLogSourceKeys.value()){
            type = "FRONT-END";
        }
        log.error(type + message);
        save(errorLogSourceKeys, ErrorLogTypeKeys.ERROR, message);
    }

    private void save(ErrorLogSourceKeys errorLogSourceKeys, ErrorLogTypeKeys errorLogTypeKeys, String message){
        ErrorLog errorLog = new ErrorLog();
        errorLog.setLogSource(errorLogSourceKeys.value());
        errorLog.setLogType(errorLogTypeKeys.value());
        errorLog.setMessage(message);
        errorLogRepository.save(errorLog);
    }

}

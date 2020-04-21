package com.learning.system;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.model.Account;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by karim on 4/15/20.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBuilder<T>  implements Serializable{
    StatusCodeKeys status;
    int code;

    T data;
    String message;

    public ResponseBuilder setStatus(StatusCodeKeys status){
        this.status = status;
//        this.message = buildResponseMessage();
        return this;
    }

    public ResponseBuilder setData(T data){
        if (data != null) this.data = data;
        return this;
    }

    public ResponseBuilder build(){
        if (data != null && this.status == null){
            this.status = StatusCodeKeys.SUCCESS;
            this.code = this.status.value();
            this.message = this.status.name();
        } else if(message == null && status != null) {
            buildResponseMessage();
            this.code = this.status.value();
        } else if (data == null){
            this.status = StatusCodeKeys.BAD_REQUEST;
            this.code = this.status.value();
            buildResponseMessage();
        }

//        if (data instanceof Account){
//            ((Account)data).setPassword(null);
//        }
        return this;
    }


    private void buildResponseMessage(){
        switch (this.status.value()){
            case 200:
                this.message = "Item Created Successfully";
                break;
            case 409:
            case 410:
                this.message = "Save Conflict Error";
                break;
            default:
                this.message = "Unhandled Error";


        }
    }

}



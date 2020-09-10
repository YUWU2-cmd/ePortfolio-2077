package com.eportfolio2077.eportfolio.common;

import lombok.Data;

@Data
public class ResponseMessage {
    private static final String WRONG_USERNAME_PASSWORD = "Incorrect Username or Password.";
    private static final String UPLOAD_FAIL = "Could not upload file.";
    private String message;

    public ResponseMessage(String message){
        this.message = message;
    }

    public static ResponseMessage loginFail(){
        return new ResponseMessage(WRONG_USERNAME_PASSWORD);
    }

    public static ResponseMessage uploadFail(){
        return new ResponseMessage(UPLOAD_FAIL);
    }
}

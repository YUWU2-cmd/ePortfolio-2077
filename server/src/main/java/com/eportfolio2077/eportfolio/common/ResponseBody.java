package com.eportfolio2077.eportfolio.common;

import lombok.Data;

@Data
public class ResponseBody {
    private static final String WRONG_USERNAME_PASSWORD = "Incorrect Username or Password.";
    private static final String UPLOAD_FAIL = "Could not upload file.";
    private static final String SUCCESS = "Success!";
    private static final String DUPLICATE_EMAIL = "Email already existed";
    private static final String SERVER_ERROR = "There maybe a server error";

    private String message;
    private Object obj;

    public ResponseBody(String message){ this.message = message; }

    public ResponseBody(String message, Object obj){ this.message = message; this.obj=obj;}

    public static ResponseBody loginFail(){ return new ResponseBody(WRONG_USERNAME_PASSWORD); }

    public static ResponseBody uploadFail(){ return new ResponseBody(UPLOAD_FAIL); }

    public static ResponseBody success(){ return new ResponseBody(SUCCESS); }

    public static ResponseBody dupEmail(){ return new ResponseBody(DUPLICATE_EMAIL); }

    public static ResponseBody serverError(){ return new ResponseBody(SERVER_ERROR); }

}
package com.eportfolio2077.eportfolio.common;

import com.eportfolio2077.eportfolio.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * A wrapper class for providing response to frontend with fixed structure
 */
@Data
public class Response implements Serializable {
    public static final int OK = 200;
    public static final int ERROR = 400;

    private int status;
    private String message;
    private Object body;


    public static Response assign(int status, String message, Object body){
        Response r = new Response();
        r.setStatus(status);
        r.setMessage(message);
        r.setBody(body);
        return r;
    }

    public static Response success(Object body){
        return assign(OK, "", body);
    }

    public static Response error(String message){
        return assign(ERROR, message, null);
    }

}

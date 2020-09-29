package com.eportfolio2077.eportfolio.utils;

import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public Long readCookie(@CookieValue(value = "id", defaultValue = "none") Long id) {
        return id;
    }

    public void setCookie(HttpServletResponse response){

        Cookie cookie = new Cookie("username", "");
        response.addCookie(cookie);

    }
}

package com.eportfolio2077.eportfolio.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieUtil {

    public void setCookie(Long userId, HttpServletResponse response) {

        Cookie cookie = new Cookie("userId", userId.toString());
        //expires in one day
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    public void deleteCookie(HttpServletResponse response) {

        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}

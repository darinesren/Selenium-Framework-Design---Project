package com.qart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookiesUtils {
public  static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies){

    List<org.openqa.selenium.Cookie> SelenuimCookie=new ArrayList<>();

    for(io.restassured.http.Cookie cookie : restAssuredCookies){
        org.openqa.selenium.Cookie sCookie=new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
        SelenuimCookie.add(sCookie);
    }
    return SelenuimCookie;
    }
}

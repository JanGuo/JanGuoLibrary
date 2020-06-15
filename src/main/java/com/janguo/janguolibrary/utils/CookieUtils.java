package com.janguo.janguolibrary.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    // Cookie存在时间
    private static int COOKIE_AGE = 60 * 60 * 24 * 7;

    /**
     * 向response中写入由String和Value组成的Cookie
     * @param key Cookie的name
     * @param value Cookie的 value
     * @param response 向浏览器发送的响应对象，使用addCookie方法添加Cookie
     */
    public static void writeCookie(String key, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(COOKIE_AGE);
        response.addCookie(cookie);
    }

    /**
     * 通过 Cookie的名字获取request中的所有的cookie值，因为cookie中的name属性可以重复所以返回的cookie是一个数组
     * @param key 用于获取request中cookie的name
     * @param request 从request中获取cookie
     * @return 返回指定name的cookie的value 如果没有对应的name 则返回null
     */
    public static String getCookie(String key, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 移除request中的cookie
     * @param key 需要被移除的cookie的name
     * @param request 从request中移除cookie
     * @param response 用于封装移除cookie的响应体
     */
    public static void removeCookie(String key, HttpServletRequest request,
                                    HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
            if ((key).equalsIgnoreCase(cookies[i].getName())) {
                Cookie cookie = new Cookie(key, "");
                cookie.setPath("/");
                cookie.setMaxAge(0);// 设置保存cookie最大时长为0，即使其失效
                response.addCookie(cookie);
            }
        }
    }
}

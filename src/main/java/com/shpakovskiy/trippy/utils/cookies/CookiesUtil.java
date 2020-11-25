package com.shpakovskiy.trippy.utils.cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class CookiesUtil {

    public void setCookies(HttpServletResponse response, String key, String content) {
        deleteCookies(response, key);
        content = content.replaceAll(" ", "");
        Cookie cookie = new Cookie(key, content);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
    }

    public String getCookies(HttpServletRequest request, String cookiesName) {
        try {
            return Arrays.stream(request.getCookies())
                    .filter(c -> cookiesName.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean containsCookies(HttpServletRequest request, String cookiesName) {
        return getCookies(request, cookiesName) != null;
    }

    public void deleteCookies(HttpServletResponse response, String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}

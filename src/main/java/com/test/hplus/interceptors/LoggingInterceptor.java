package com.test.hplus.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //log session id
        // log the request path

        String sessionId = null;

        if(null != request.getCookies()) {
            //get all cookies
            for(Cookie cookie: request.getCookies()) {
                //If you want to get hold of the session id, the cookie, that the servlet jsp or any other mvc framework reserves, is JSESSIONID.
                if("JSESSIONID".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                }
            }
        }
        //Here a message is printed out, that says an incoming request will enter the LoggingInterceptor and when it does it had a specific session id, and happened at a specific date for a particular url pattern that was invoked.
        System.out.println("Incoming request data log: " + sessionId +
                " at " + new Date() + " for " + request.getRequestURI());

        //When the function returns true, it means that the entire execution of the interceptor was a success and control of the request can be given to the controller.
        //If the interceptor returns falls, then the response will go back to the jsp from here and the specific controller will never get invoked.
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("in post handle");
    }
}

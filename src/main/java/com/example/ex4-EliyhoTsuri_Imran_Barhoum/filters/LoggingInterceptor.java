package com.example.ex4.filters;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor
{

    public LoggingInterceptor() { }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true; // continue with the request to next filter or to controller
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception
    { }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception
    {
        //System.out.print("-------- afterCompletion ---: ");
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.print("Request URL: " + request.getRequestURL());
        //System.out.println("; End Time: " + endTime);
        System.out.println("Time Taken: " + (endTime - startTime));
    }
}
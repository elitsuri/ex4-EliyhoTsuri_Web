package com.example.ex4.filters;
import com.example.ex4.Bean.myUser;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@Component
public class ChatFilter implements Filter
{
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session =req.getSession();
        System.out.println("newsession" + session.isNew() + session.getAttribute("scopedTarget.sessionBeanExam"));
        if(session.getAttribute("scopedTarget.sessionBeanExam") != null)
        {
            myUser u = (myUser) session.getAttribute("scopedTarget.sessionBeanExam");
            System.out.println("myUser Session is :" + u.getUser().getUserName());
        }
        else
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        Enumeration<String> attribs  = session.getAttributeNames();
        String attrib = null;
        while (attribs.hasMoreElements())
        {
            System.out.println("sesion name"+ attrib);
            attrib = attribs.nextElement();
            Object obj = session.getAttribute(attrib);
        }
        System.out.println("Remote Host:"+servletRequest.getRemoteHost());
        System.out.println("Remote Address:"+servletRequest.getRemoteAddr());
        System.out.println(
                "Logging Request  {} : {}"+ req.getMethod()+
                req.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(
                "Logging Response :{}"+
                res.getContentType());

    }
}
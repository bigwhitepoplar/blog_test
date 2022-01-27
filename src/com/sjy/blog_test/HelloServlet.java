package com.sjy.blog_test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("?????????????");
        System.out.println(servletConfig.getInitParameter("user"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet启动！");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String method =  httpServletRequest.getMethod();
        if("GET".equals(method)) {

        } else {

        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

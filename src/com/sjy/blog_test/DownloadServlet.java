package com.sjy.blog_test;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        获取客户端传来的cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            System.out.println(cookie.getName() + cookie.getValue());
        }

//        获取客户端要下载的文件名
        String downLoadFileName = "null-7a388f015acb19cc.jpg";
//        读取文件
        ServletContext servletContext = getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/png/" + downLoadFileName);

//        设置响应头，告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/png/" + downLoadFileName);
        response.setContentType(mimeType);

//        设置响应头，告诉客户端这个文件是用于下载的，而不是直接在浏览器中显示
        //response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode("女孩.jpg", "UTF-8"));

//        创建cookie
        Cookie cookie1 = new Cookie("key1", "newValue1");
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("key2", "value2");
        response.addCookie(cookie2);

        ServletOutputStream outputStream = response.getOutputStream();
//        通过IO包进行输出，读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);

    }
}

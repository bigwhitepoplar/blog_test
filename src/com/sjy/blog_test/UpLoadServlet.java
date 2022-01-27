package com.sjy.blog_test;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);

                for(FileItem fileItem : list) {
                    if(fileItem.isFormField()) {
//                        表单项名
                        System.out.println(fileItem.getFieldName());
//                        内容
                        System.out.println(fileItem.getString("UTF-8"));
                    } else {
//                        表单项名
                        System.out.println(fileItem.getFieldName());
//                        文件名
                        System.out.println(fileItem.getName());
//                        把文件放在指定位置
                        fileItem.write(new File("e:\\桌面\\" + fileItem.getName()));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

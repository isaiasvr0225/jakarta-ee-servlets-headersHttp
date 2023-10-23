package com.example.servletsheaders;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletHeader", value = "/servlet-header")
public class ServletHeader extends HttpServlet {
    private String message;

    public void init() {
        message = "Header gotten!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String methodType = request.getMethod();
        String uri = request.getRequestURI();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>Tipo de método HTTP: " + methodType + "</p>");
        out.println("<p>uri:  " + uri + "</p>");
        Enumeration enume = request.getHeaderNames();
        out.println("<br>");
        while (enume.hasMoreElements()){
            String headerName = (String) enume.nextElement();
            out.println("<b>" + headerName + ": </b>");
            out.println(request.getHeader(headerName));
            out.println("<br>");
        }
        out.println("</body></html>");
        out.close();
    }

    public void destroy() {
    }
}
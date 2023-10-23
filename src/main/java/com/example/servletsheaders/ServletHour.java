package com.example.servletsheaders;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ServletHour", value = "/ServletHour")
public class ServletHour extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("refresh", "1");
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("'Hora actualizada:' HH:mm:ss");
        String dateFormated = formater.format(date);

        PrintWriter out = response.getWriter();
        out.println(dateFormated);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

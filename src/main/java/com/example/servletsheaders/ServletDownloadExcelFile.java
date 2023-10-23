package com.example.servletsheaders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servletExcelFileGenerataor", value = "/servlet-excel")
public class ServletDownloadExcelFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Para un uso más profesional de excel poi.apache.org
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-Disposition", "attachment;filename=suma.xlsx");

        //Indicar al navegador que no guarde caché
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-store");
        resp.setDateHeader("Expires", -1);

        //Desplegar información
        PrintWriter out = resp.getWriter();
        out.println("\tCantidad");
        out.println("\t10");
        out.println("\t35");
        out.println("\t50");
        out.println("Total\t=SUMA(B2:B3);");
        out.close();

    }
}

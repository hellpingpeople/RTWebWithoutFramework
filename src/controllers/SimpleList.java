package controllers;

import models.Persona;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vashurin Alexander on 25.01.2017.
 */
public class SimpleList extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text / html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<B> Список людей</B>");
        pw.println("<table border = 1>");
        try {
            List l = null;
            try {
                l = (List) ManagementSystem.getInstance().getAllPersonas();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Iterator it = l.iterator(); it.hasNext();) {
                Persona gr = (Persona) it.next();
                pw.println("<tr>");
                pw.println("<td>" + gr.getPersonaId() + "</td>");
                pw.println("<td>" + gr.getFirstName() + "</td>");
                pw.println("<td>" + gr.getPatronymic() + "</td>");
                pw.println("<td>" + gr.getSurName() + "</td>");
                pw.println("</tr >");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table>");
    }
}


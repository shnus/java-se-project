package com.nusrat.java.drive_club.locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nusrat on 1/29/2017.
 */
@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String locale = req.getParameter("com/nusrat/java/drive_club/locale");
        req.getSession(true).setAttribute("com/nusrat/java/drive_club/locale",locale);
        req.getRequestDispatcher("/WEB-INF//index.jsp").forward(req,resp);
    }

}

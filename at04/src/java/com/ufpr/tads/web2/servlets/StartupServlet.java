package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.ConfigBean;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "StartupServlet", urlPatterns = {"/StartupServlet"}, loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init() {
        ConfigBean config = new ConfigBean();
        config.setEmail("vaisefoder@cucucu.com");
        ServletContext ctx = getServletContext();
        ctx.setAttribute("configura", config);
        System.out.println("FUNCIONA EM NOME DE JESUS");
    }

}

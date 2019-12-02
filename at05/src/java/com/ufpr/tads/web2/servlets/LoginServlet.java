package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.dao.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    String login, password;
    HttpSession session = null;
    LoginBean userLogged = null;
    UserDao uDao = new UserDao();

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);

        if (session != null) {
            userLogged = (LoginBean)session.getAttribute("userLogged");
            if (userLogged != null) {
                response.sendRedirect(request.getContextPath() + "/main.jsp");
            } else {
                request.setAttribute("errorMsg", "you aren't logged... login first"); // errorMsg - mensagem de erro 
                request.setAttribute("errorLink", request.getContextPath() + "/"); // errorLink - Link para retornar
                request.setAttribute("errorLinkText", "return to login screen"); // errorLinkText - Hyperlink do retorno
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("errorMsg", "you aren't logged... login first"); // errorMsg - mensagem de erro 
            request.setAttribute("errorLink", request.getContextPath() + "/"); // errorLink - Link para retornar
            request.setAttribute("errorLinkText", "return to login screen"); // errorLinkText - Hyperlink do retorno
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
    
    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login = request.getParameter("userLogin");
        password = request.getParameter("userPass");
        userLogged = uDao.userLogin(login, password);
        if (userLogged != null) {
            session = request.getSession();
            session.setAttribute("userLogged", userLogged);
            response.sendRedirect(request.getContextPath() + "/main.jsp");
        } else {
            // changed to msg for showing in the index.jsp
            request.setAttribute("msg", "login or password incorrect..."); // errorMsg - mensagem de erro 
            // not used anymore :(
            /*
            request.setAttribute("errorLink", request.getContextPath() + "/"); // errorLink - Link para retornar
            request.setAttribute("errorLinkText", "return to login screen"); // errorLinkText - Hyperlink do retorno
            */
            // now the forward goes to index.jsp instead of error.jsp :(
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp"); 
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

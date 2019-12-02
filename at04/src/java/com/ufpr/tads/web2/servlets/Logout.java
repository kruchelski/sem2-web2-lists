package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.LoginBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Logout", urlPatterns = {"/logout"})
public class Logout extends HttpServlet {

    String msg = "";
    LoginBean userLogged = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            userLogged = (LoginBean) session.getAttribute("userLogged");
            if ((userLogged != null) && (userLogged.getLogin() != null)) {
                if (request.getParameter("n") != null) { //if user is logged, there is a login and the logout was made by click
                    msg = "bye, " + userLogged.getLogin();
                    session.invalidate();
                    request.setAttribute("msg", msg);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/logout.jsp");
                    rd.forward(request, response);
                } else { //if there is a session active but the logout wasn't accessed through the link
                    request.setAttribute("msg", null);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/logout.jsp");
                    rd.forward(request, response);
                }
            } else { //if there is a session but no loggedUser
                request.setAttribute("errorMsg", "you aren't logged... login first"); // errorMsg - mensagem de erro 
                request.setAttribute("errorLink", request.getContextPath() + "/"); // errorLink - Link para retornar
                request.setAttribute("errorLinkText", "return to login screen"); // errorLinkText - Hyperlink do retorno
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else { //if there isn't a session
            request.setAttribute("errorMsg", "you aren't logged... login first"); // errorMsg - mensagem de erro 
            request.setAttribute("errorLink", request.getContextPath() + "/"); // errorLink - Link para retornar
            request.setAttribute("errorLinkText", "return to login screen"); // errorLinkText - Hyperlink do retorno
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

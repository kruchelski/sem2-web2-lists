package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

@WebServlet(name = "Logout", urlPatterns = {"/logout"})
public class Logout extends HttpServlet {

    String msg = "";
    User userLogged = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            userLogged = (User) session.getAttribute("userLogged");
            if (userLogged != null) {
                if (request.getParameter("n") != null) {
                    msg = "bye, " + userLogged.getLogin();
                    session.invalidate();
                    request.setAttribute("msg", msg);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/logout.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("msg", null);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/logout.jsp");
                    rd.forward(request, response);
                }
            } else {
                msg = "you need to login before you try to logout";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else {
            msg = "you need to login before you try to logout";
            request.setAttribute("msg", msg);
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

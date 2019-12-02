package Servlets;

import dao.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    boolean loged;
    String login, password;
    HttpSession session = null;
    User userLogged = null;
    UserDao uDao = new UserDao();

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);

        if (session != null) {
            userLogged = (User) session.getAttribute("userLogged");
            if (userLogged != null) {
                response.sendRedirect(request.getContextPath() + "/main.jsp");
            } else {
                String msg = "you aren't logged... login first";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else {
            String msg = "you aren't logged... login first";
            request.setAttribute("msg", msg);
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
            String msg = "login or password incorrect...";
            request.setAttribute("msg", msg);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    //??
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

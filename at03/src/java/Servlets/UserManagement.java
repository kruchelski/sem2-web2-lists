package Servlets;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

@WebServlet(name = "UserManagement", urlPatterns = {"/users"})
public class UserManagement extends HttpServlet {

    String msg = "";
    User userLogged = null;
    UserDao uDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("msg", null);
        HttpSession session = request.getSession(false);
        if (session != null) {
            userLogged = (User) session.getAttribute("userLogged");
            if (userLogged != null) {
            } else {
                msg = "you aren't logged... login first";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else {
            msg = "you aren't logged... login first";
            request.setAttribute("msg", msg);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        List<User> usersList = uDao.getUsers();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            int i;

            StringBuilder res = new StringBuilder("[");
            for (i = 0; i < usersList.size(); i++) {
                res.append("{");
                res.append("\"id\":\"").append(usersList.get(i).getId()).append("\",");
                res.append("\"name\":\"").append(usersList.get(i).getUserName()).append("\",");
                res.append("\"login\":\"").append(usersList.get(i).getLogin()).append("\",");
                res.append("\"password\":\"").append(usersList.get(i).getPassword()).append("\"");
                res.append("}");
                if (i < usersList.size() - 1) {
                    res.append(",");
                }
            }
            res.append("]");
            out.print(res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("msg", null);
        HttpSession session = request.getSession(false);
        userLogged = (User) session.getAttribute("userLogged");
        if (userLogged != null) {
        } else {
            msg = "you aren't logged... login first";
            request.setAttribute("msg", msg);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        // receive data from form
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        //verify is something is missing and begin the error response;
        List<String> errorList = new ArrayList<>();
        if ((name == null) || (name.equals(""))) {
            errorList.add("NAME is missing");
        }
        if ((login == null) || (login.equals(""))) {
            errorList.add("LOGIN is missing");
        }
        if ((password == null) || (password.equals(""))) {
            errorList.add("PASSWORD is missing");
        }
        if (errorList.size() > 0) {
            response.setStatus(422);
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            StringBuilder res = new StringBuilder("{");
            res.append("\"status\":\"error\",");
            res.append("\"messages\":[");
            for (int i = 0; i < errorList.size(); i++) {
                res.append("\"").append(errorList.get(i)).append("\"");
                if (i < (errorList.size() - 1)) {
                    res.append(",");
                }
            }
            res.append("]}");
            try (PrintWriter out = response.getWriter()) {
                out.print(res);
            }
        } else {
            response.setStatus(200);
            int id = uDao.insertUser(new User(0, name, login, password));
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            StringBuilder res = new StringBuilder("{");
            res.append("\"status\":\"success\",");
            res.append("\"user\":{");
            res.append("\"id\":\"").append(id).append("\",");
            res.append("\"name\":\"").append(name).append("\",");
            res.append("\"login\":\"").append(login).append("\",");
            res.append("\"password\":\"").append(password).append("\"");
            res.append("}}");
            try (PrintWriter out = response.getWriter()) {
                out.print(res);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

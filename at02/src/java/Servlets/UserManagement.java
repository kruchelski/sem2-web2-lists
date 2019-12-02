package Servlets;

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

    String userName, userLogin, userPass;
    String msg = "";
    User userLogged = null;
    

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
        List<User> usersList = null;
        usersList = (ArrayList<User>) session.getAttribute("usersList");
        if (usersList == null) { //Primeira vez acessando a Servlet, instanciando usuários padrão
            usersList = new ArrayList<User>();
            usersList.add(new User("Juruna Simão", "Juzera", "jurers"));
            usersList.add(new User("Palmito de Pupuha", "Palmers", "pupu"));
            usersList.add(new User("Jucrécia Farofoski", "polenta", "pol123"));
            usersList.add(new User("Miroslava Fraviola", "Mira", "ehnois"));
            usersList.add(new User("Waldisney Twitterson", "walder", "piolho"));
            session.setAttribute("usersList", usersList);
        }

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            int i;

            String res = "[";
            for (i = 0; i < usersList.size(); i++) {
                res = res + "{";
                res = res + "\"name\":" + "\"" + usersList.get(i).getUserName() + "\",";
                res = res + "\"login\":" + "\"" + usersList.get(i).getLogin() + "\",";
                res = res + "\"password\":" + "\"" + usersList.get(i).getPassword() + "\"";
                res = res + "}";
                if (i < usersList.size() - 1) {
                    res = res + ",";
                }
            }
            res = res + "]";
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
        userName = request.getParameter("name");
        userLogin = request.getParameter("login");
        userPass = request.getParameter("password");
        User u = new User(userName, userLogin, userPass);
        List<User> usersList = (ArrayList<User>) session.getAttribute("usersList");
        usersList.add(u);
        session.setAttribute("usersList", usersList);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String res = "";
        res = res + "{";
        res = res + "\"name\":" + "\"" + u.getUserName() + "\",";
        res = res + "\"login\":" + "\"" + u.getLogin() + "\",";
        res = res + "\"password\":" + "\"" + u.getPassword() + "\"";
        res = res + "}";
        try (PrintWriter out = response.getWriter()) {
            out.print(res);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

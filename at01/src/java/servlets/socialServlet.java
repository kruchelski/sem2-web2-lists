package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Social;

@WebServlet(name = "socialServlet", urlPatterns = {"/social"})
public class socialServlet extends HttpServlet {
    //Declaração da lista que será passada por atributo da requisição
    List<Social> socialList = new ArrayList<>();    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        socialList.clear();
        socialList.add(new Social("facebook", "https://www.facebook.com/cassianovidal", request.getContextPath() + "/imgs/facebook.png"));
        socialList.add(new Social("twitter", "https://twitter.com/cassianovidal", request.getContextPath() + "/imgs/twitter.png"));
        socialList.add(new Social("lastfm", "https://www.last.fm/user/cassianovidal", request.getContextPath() + "/imgs/lastfm.png"));
        socialList.add(new Social("soundcloud", "https://www.soundcloud.com/cassianovidal", request.getContextPath() + "/imgs/soundcloud.png"));
        socialList.add(new Social("flickr", "https://www.flickr.com/photos/desastronauta/", request.getContextPath() + "/imgs/flickr.png"));
        socialList.add(new Social("github", "https://github.com/kruchelski", request.getContextPath() + "/imgs/github.png"));
        
        request.setAttribute("lista", socialList);
        request.getServletContext().getRequestDispatcher("/social.jsp").forward(request, response);
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

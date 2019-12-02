package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;

@WebServlet(name = "Tads", urlPatterns = {"/curso"})
public class CursoServlet extends HttpServlet {
    List<Curso> lista = new ArrayList<Curso>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista.clear();
        lista.add(new Curso("Agente Comunitário de Saúde", "http://www.tacs.ufpr.br", request.getContextPath() + "/imgs/01acs.png"));
        lista.add(new Curso("Petróleo e Gás", "http://www.sept.ufpr.br/portal/petroleogas/", request.getContextPath() + "/imgs/02pg.png"));
        lista.add(new Curso("TADS", "https://www.tads.ufpr.br", request.getContextPath() + "/imgs/03ads.png"));
        lista.add(new Curso("Comunicação Institucional", "http://www.tci.ufpr.br", request.getContextPath() + "/imgs/04ci.png"));
        lista.add(new Curso("Gestão da Qualidade", "http://www.gestaodaqualidade.ufpr.br", request.getContextPath() + "/imgs/05gq.png"));
        lista.add(new Curso("Gestão Pública", "http://www.gestaopublica.ufpr.br", request.getContextPath() + "/imgs/06gp.png"));
        lista.add(new Curso("Luteria", "http://www.luteria.ufpr.br/portal/", request.getContextPath() + "/imgs/07l.png"));
        lista.add(new Curso("Negócios Imobiliários", "http://www.sept.ufpr.br/portal/negociosimobiliarios/", request.getContextPath() + "/imgs/08ni.png"));
        lista.add(new Curso("Produção Cênica", "http://www.tpc.ufpr.br", request.getContextPath() + "/imgs/09pc.png"));
        lista.add(new Curso("Secretariado", "http://www.sept.ufpr.br/portal/secretariado/", request.getContextPath() + "/imgs/10s.png"));
        lista.add(new Curso("Pós-Graduação em Bioinformática", "http://www.bioinfo.ufpr.br",  request.getContextPath() + "/imgs/11b.png"));
        lista.add(new Curso("Especialização em Inteligência Artificial", "http://www.iaa.ufpr.br", request.getContextPath() + "/imgs/12eia.png"));
        lista.add(new Curso("Especialização em Engenharia de Software", "http://www.engenhariadesoftware.ufpr.br:28080/engenhariadesoftware/", request.getContextPath() + "/imgs/13ees.png"));
        request.setAttribute("curso", lista);
        request.getServletContext().getRequestDispatcher("/curso.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

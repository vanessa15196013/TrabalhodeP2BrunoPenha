package br.com.aplicacao.controller;

import br.com.aplicacao.dao.EstudanteDao;
import br.com.aplicacao.dao.EstudanteDaoImplementation;
import br.com.aplicacao.model.Estudante;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "/EstudanteController", urlPatterns = {"/EstudanteController", "/EstudanteController.do"})
public class EstudanteController extends HttpServlet {

    private EstudanteDao dao;
    private static final long serialVersionUID = 1L;
    public static final String LIST_STUDENT = "/listaEstudante.jsp";
    public static final String INSERT_OR_EDIT = "/estudante.jsp";

    public EstudanteController() {
        dao = new EstudanteDaoImplementation();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        int estudanteId;
        
        switch(action){
            case "deleta": 
                forward = LIST_STUDENT;
                estudanteId = Integer.parseInt(request.getParameter("estudanteId").trim());
                dao.deleteEstudante(estudanteId);
                request.setAttribute("estudantes", dao.getAllEstudantes());
                break;
            case "edita":
                forward = INSERT_OR_EDIT;
                estudanteId = Integer.parseInt(request.getParameter("estudanteId").trim());
                Estudante estudante = dao.getEstudanteById(estudanteId);
                request.setAttribute("estudante", estudante);
                break;
            case "inseri":
                forward = INSERT_OR_EDIT;
                break;
            default:
                forward = LIST_STUDENT;
                request.setAttribute("estudantes", dao.getAllEstudantes());                
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Estudante estudante = new Estudante();
        estudante.setPrimeiroNome(request.getParameter("primeiroNome"));
        estudante.setUltimoNome(request.getParameter("segundoNome"));
        estudante.setCurso(request.getParameter("curso"));
        String estudanteId = request.getParameter("estudanteId");
      
        if (estudanteId == null || estudanteId.isEmpty()) {
            dao.addEstudante(estudante);
        } else {
            estudante.setIdEstudante(Integer.parseInt(estudanteId));
            dao.updateEstudante(estudante);
        }
        request.setAttribute("estudantes", dao.getAllEstudantes());
        RequestDispatcher view = request.getRequestDispatcher(LIST_STUDENT);
        view.forward(request, response);
    }
}

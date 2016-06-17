package br.com.aplicacao.controller;

import br.com.aplicacao.dao.UsuarioDao;
import br.com.aplicacao.dao.UsuarioDaoImplementation;
import br.com.aplicacao.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabiano
 */
@WebServlet(name = "/LoginController", urlPatterns = {"/LoginController", "/LogoutController"})
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher requestDispatcher;
        String msgErro; 
        
        Usuario usuario = new Usuario();
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        
        UsuarioDao dao = new UsuarioDaoImplementation();
        msgErro = dao.autenticar(usuario);
        if (msgErro.isEmpty()){
            usuario.setSenha("");
            HttpSession session = request.getSession();
            String nomeFormatado = usuario.getLogin();
            usuario.setLogin(nomeFormatado.replace(".", " "));
            session.setAttribute("usuarioLogado", usuario);           
            
            requestDispatcher = request.getRequestDispatcher("/menu.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("erro", msgErro);
            requestDispatcher = request.getRequestDispatcher("/formulario-login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formulario-login.jsp");
        requestDispatcher.forward(request, response);
    }
    
    
}

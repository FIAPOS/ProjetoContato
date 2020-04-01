package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ContatoDAO;
import br.fiap.entidade.Contato;

@WebServlet("/buscarEmail")
public class BuscarEmailServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   String email = request.getParameter("email");
	   ContatoDAO  dao = new ContatoDAO();
	   
	   Contato contato =dao.pesquisar(email);
	   
	   request.setAttribute("contato", contato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("alterar.jsp");
		dispatcher.forward(request, response);
	   
	   
	}

}

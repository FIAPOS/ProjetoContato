package br.fiap.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ContatoDAO;
import br.fiap.entidade.Contato;

@WebServlet("/cadastro")
public class ContatoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variável para encaminhar despacho
		RequestDispatcher dispatcher;
		
		//formato da data
		
		
		//obtem os dados da requisição
		String nome =request.getParameter("nome");
		String endereco =request.getParameter("endereco");
		String email =request.getParameter("email");

		String genero =request.getParameter("genero");
		
		
		
		Contato contato = new Contato(nome, email, endereco, genero);
		ContatoDAO dao = new ContatoDAO();
		dao.cadastrar(contato);
		List<Contato> lista = dao.listar();
		request.setAttribute("lista", lista);
		dispatcher = request.getRequestDispatcher("listagem.jsp");
		dispatcher.forward(request, response);
		dao.listar();
	}

}

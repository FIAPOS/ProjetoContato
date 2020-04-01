package br.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Contato;

public class ContatoDAO {
	private PreparedStatement ps;
	private Connection connection;
	private ResultSet rs;
	private String sql;

	public ContatoDAO() {
		connection = Conexao.getConnection();
	}

	public void cadastrar(Contato contato) {
		sql = "insert into java_contato values(?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			
			ps.setString(4, contato.getGenero());
			ps.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco");
		}
	}

	public List<Contato> listar() {
		List<Contato> lista = null;
		sql = "select * from java_contato";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			lista = gerarObjeto();

		} catch (SQLException e) {
			System.out.println("Falha na listagem");
		}
		return lista;
	}

	private List<Contato> gerarObjeto() throws SQLException {
		List<Contato> lista = new ArrayList<Contato>();
		String nome, email, endereco, genero;
	
		while (rs.next()) {
			nome = rs.getString("nome");
			email = rs.getString("email");
			endereco = rs.getString("endereco");
		
			genero = rs.getString("genero");

			lista.add(new Contato(nome, email, endereco, genero));
		}

		return lista;
	}

	public void remover(String email) {
		sql = "delete from java_contato where email = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Contato contato) {
		sql = "update java_contato set nome = ?, endereco = ?, genero = ? where email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEndereco());
			
			ps.setString(4, contato.getGenero());
			ps.setString(5, contato.getEmail());
			ps.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco");
		}
	}

	public Contato pesquisar(String email) {
		Contato contato = null;
		sql = "select * from java_contato where email = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				contato = new Contato(rs.getString("nome"), email, rs.getString("endereco"),
						rs.getString("genero"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contato;
	}

}

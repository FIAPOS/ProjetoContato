package br.fiap.entidade;

import java.sql.Date;

public class Contato {
  private String nome;
  private String email;
  private String endereco;

  private String genero;

	
public Contato(String nome, String email, String endereco, String genero) {
	super();
	this.nome = nome;
	this.email = email;
	this.endereco = endereco;

	this.genero = genero;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getEndereco() {
	return endereco;
}


public void setEndereco(String endereco) {
	this.endereco = endereco;
}




public String getGenero() {
	return genero;
}


public void setGenero(String genero) {
	this.genero = genero;
}


@Override
	public String toString() {
		String aux="Contato\n";
		aux+="nome ->"+nome;
		aux+="email ->"+email;
		aux+="Endereco ->"+endereco;
	
		aux+="Genero ->"+genero;
		return aux;
	}



}

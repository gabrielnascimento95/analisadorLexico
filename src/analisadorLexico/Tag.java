package analisadorLexico;

public class Tag {
	String nome;
	String conteudo;
	String tag;
	
	public Tag(String nome, String conteudo) {
		this.nome = nome;
		this.conteudo = conteudo;
		this.tag.concat(nome+conteudo);
	}
	
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

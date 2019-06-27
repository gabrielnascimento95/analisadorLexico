package analisadorLexico;

public class Tag {
	No info[];
	String nome;
	
	public Tag(String entrada) {
		int tam = entrada.length();
		for(int i = 0; i <tam; i++) {
			info[i] = new No(entrada.charAt(i));
		}
	}
	
	public No[] getInfo() {
		return info;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setInfo(No[] info) {
		this.info = info;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

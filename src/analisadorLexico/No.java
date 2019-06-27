package analisadorLexico;

public class No {
	char campo;
	No prox;
	
	public No(char valor) {
		this.prox = null;
		this.campo = valor;
	}
	
	public char getCampo() {
		return campo;
	}
	
	public No getProx() {
		return prox;
	}
	
	public void setProx(No prox) {
		this.prox = prox;
	}
	
	public void setCampo(char campo) {
		this.campo = campo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

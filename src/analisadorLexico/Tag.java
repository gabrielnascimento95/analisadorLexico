package analisadorLexico;

import java.util.ArrayList;

public class Tag {
	ArrayList<No> listaNos = new ArrayList();
	String nome;
	
	public Tag() {
		
	}
	
	public void insereNo(No aux) {
		this.listaNos.add(aux);
	}
	
	public ArrayList<No> getInfo() {
		return listaNos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setListaNos(ArrayList<No> listaNos) {
		this.listaNos = listaNos;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void imprimeTag() {
		for(int i = 0; i< listaNos.size(); i++) {
			System.out.print(listaNos.get(i).getCampo());
		}
		
	}
}

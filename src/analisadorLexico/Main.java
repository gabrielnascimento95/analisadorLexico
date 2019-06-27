package analisadorLexico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		boolean verificador = false;
		ArrayList<No> entrada = new ArrayList();
		entrada.add(new No('a'));
		entrada.add(new No('b'));
		entrada.add(new No('c'));
		entrada.add(new No('d'));
		entrada.add(new No('e'));
		entrada.add(new No('1'));
		entrada.add(new No('2'));
		
		
		Tag a = new Tag();
		a.insereNo(new No('a'));
		a.insereNo(new No('b'));
		a.insereNo(new No('+'));
		a.insereNo(new No('c'));
		a.insereNo(new No('+'));
		a.insereNo(new No('d'));
		a.insereNo(new No('+'));
		a.insereNo(new No('*'));
		
		for(int i = 0; i<entrada.size(); i++) {
			if(entrada.get(i).getCampo() == a.getInfo().get(i).getCampo()) {
				verificador = true;
			}
			// if else para as proximas tags definidas 
		}
		
		a.imprimeTag();
	}

}

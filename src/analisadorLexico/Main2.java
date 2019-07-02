package analisadorLexico;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {

	public static void main(String[] args) {
		List<Automato> automatos = AutomatoDAO.getInstance();
		String entradaUser; //"ab+c.*"; //ab.c.* // ab.*
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite uma tag: ");
		entradaUser = sc.nextLine();
		Reconhecedor rec = new Reconhecedor();
		Stack<Automato> pilhaAuto = new Stack<Automato>();
		Stack pilhaTag = new Stack();	
		char[] entradaForChar;
		entradaForChar = entradaUser.toCharArray();
		int aux = entradaForChar.length;
		System.out.print("Entrada: ");
		for (char a:entradaForChar) {
			System.out.print(a);
		}
		System.out.println();
		
		for(int i = 0; i < entradaForChar.length; i++) {
			if(entradaForChar[i] != '+' && entradaForChar[i] != '.' && entradaForChar[i] != '*') {
				pilhaTag.push(entradaForChar[i]); 
			}else if(entradaForChar[i] == '+') {
				if(pilhaTag.size() > 1) {
					char a = (char) pilhaTag.pop();
					char b = (char) pilhaTag.pop();
					pilhaTag.push(b + "+" + a);
				}else {
					System.out.print("erro");
					break;
				}
			}else if(entradaForChar[i] == '.') {
				if(pilhaTag.size() > 1) {
					char a = (char) pilhaTag.pop();
					char b = (char) pilhaTag.pop();
					pilhaTag.push(b + "." + a);
				}else {
					System.out.print("erro");
					break;
				}
			}else if(entradaForChar[i] == '*') {
				Automato a = pilhaAuto.pop();
				//Automato c = pilhaAuto.pop();
				Automato b = new Automato();
				b = a;
				b.fechoKleen(a);
				pilhaAuto.push(b);
			}
		}
		
		
		
		
		
		
		
		for(int i = 0; i < entradaForChar.length; i++) {
			if(entradaForChar[i] != '+' && entradaForChar[i] != '.' && entradaForChar[i] != '*') {
				Automato a = Automato.automatoSimples(entradaForChar[i]);
				pilhaAuto.push(a); 
			}else if(entradaForChar[i] == '+') {
				Automato a = pilhaAuto.pop();
				Automato b = pilhaAuto.pop();
				Automato c = Automato.automatoAuxiliar();
				c.construirAuto(b, a);
				pilhaAuto.push(c);
			}else if(entradaForChar[i] == '.') {
				Automato a = pilhaAuto.pop();
				Automato b = pilhaAuto.pop();
				Automato c = Automato.automatoAuxiliar();
				c.concatenaAuto(b, a);
				pilhaAuto.push(c);
			}else if(entradaForChar[i] == '*') {
				Automato a = pilhaAuto.pop();
				//Automato c = pilhaAuto.pop();
				Automato b = new Automato();
				b = a;
				b.fechoKleen(a);
				pilhaAuto.push(b);
			}
		}
		
		System.out.print("Tamanho da pilha: " + pilhaAuto.size());
		System.out.println();
		Automato a6 = pilhaAuto.pop();
		automatos.add(a6);
	}

}

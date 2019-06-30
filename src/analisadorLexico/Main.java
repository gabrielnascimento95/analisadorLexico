package analisadorLexico;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Reconhecedor rec = new Reconhecedor();
		Stack<Automato> pilhaAuto = new Stack<Automato>();
		//Scanner sc = new Scanner(System.in);
		String entradaUser = "ab+c+d+*";
		char[] entradaForChar;
		//System.out.print("Digite uma tag: ");
		//entradaUser = sc.nextLine();
		entradaForChar = entradaUser.toCharArray();
		//sc.close();
		System.out.print("Entrada: ");
		for (char a:entradaForChar) {
			System.out.print(a);
		}
		iniciaPilha(pilhaAuto, entradaForChar[0], entradaForChar[1]);
		for(int i = 2; i < entradaForChar.length; i++) {
			if(entradaForChar[i] == '+') {
				int index = i+1;
				Automato aux1 = pilhaAuto.pop();
				if(entradaForChar[index] != '*') {
					Automato aux0 = Automato.automatoAuxiliar();
					Automato aux10 = Automato.automatoSimples(entradaForChar[index]);
					aux0.construirAuto(aux1, aux10);
					pilhaAuto.push(aux0);
				}else{
					Automato aux0 = Automato.automatoAuxiliar();
					aux0 = aux1;
					aux0.fechoKleen(aux1);
				}
			}if(entradaForChar[i] == '.') {
				int index = i+1;
				Automato aux1 = pilhaAuto.pop();
				if(entradaForChar[index] != '*') {
					Automato aux0 = Automato.automatoAuxiliar();
					Automato aux10 = Automato.automatoSimples(entradaForChar[index]);
					aux0.concatenaAuto(aux1, aux10);
					pilhaAuto.push(aux0);
				}else{
					Automato aux0 = Automato.automatoAuxiliar();
					aux0 = aux1;
					aux0.fechoKleen(aux1);
				}
			}
		}
		
	}
	
	public static void iniciaPilha(Stack<Automato> pilhaAuto, char a, char b) {
		Automato a1 = Automato.automatoSimples(a);
	    Automato a2 = Automato.automatoSimples(b);
	    Automato a4 = Automato.automatoAuxiliar();
        a4.construirAuto(a1, a2);
        pilhaAuto.add(a4);
	}

}

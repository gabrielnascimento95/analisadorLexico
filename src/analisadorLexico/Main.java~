package analisadorLexico;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Automato> pilhaAuto = new Stack<Automato>();
		Scanner sc = new Scanner(System.in);
		String entradaUser;
		char[] entradaForChar;
		System.out.print("Digite uma tag: ");
		entradaUser = sc.nextLine();
		entradaForChar = entradaUser.toCharArray();
		sc.close();
		System.out.println("-------Entrada do usuário------------------");
		System.out.println(entradaUser);
		System.out.println("--------Conversor para vetor de char-------");
		for (char a:entradaForChar) {
			System.out.print(a);
		}
		for (char a:entradaForChar) {
			if(a != '.' && a != '+') {
				Automato auxA = Automato.automatoSimples(a);
				pilhaAuto.push(auxA);
			}else if (a == '+'){
				Automato auxA = pilhaAuto.pop();
				Automato auxB = pilhaAuto.pop();
				Automato auxC = Automato.automatoAuxiliar();
				auxC.construirAuto(auxA, auxB);
				pilhaAuto.push(auxC);
			}else if(a == '.') {
				Automato auxA = pilhaAuto.pop();
				Automato auxB = pilhaAuto.pop();
				Automato auxC = Automato.automatoAuxiliar();
				auxC.concatenaAuto(auxA, auxB);
			}else if(a == '*') {
				Automato auxA = pilhaAuto.pop();
				Automato auxC = Automato.automatoAuxiliar();
				auxC.fechoKleen(auxA);
			}
			
		}
		
		
		/*
		Automato a1 = Automato.automatoSimples('a');
        Automato a2 = Automato.automatoSimples('b');
        Automato a3 = Automato.automatoSimples('c');

        
        Automato a4 = Automato.automatoAuxiliar();
        a4.construirAuto(a1, a2);
        
        Automato a5 = Automato.automatoAuxiliar();
        a5.concatenaAuto(a4, a3);
       */ 	
	}

}

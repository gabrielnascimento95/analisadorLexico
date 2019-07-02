package analisadorLexico;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Reconhecedor rec = new Reconhecedor();
		Stack<Automato> pilhaAuto = new Stack<Automato>();
		String entradaUser = "ab+c.*"; //ab.c.* // ab.*
		char[] entradaForChar;
		entradaForChar = entradaUser.toCharArray();
		int aux = entradaForChar.length;
		System.out.print("Entrada: ");
		for (char a:entradaForChar) {
			System.out.print(a);
		}
		System.out.println();
			}

}

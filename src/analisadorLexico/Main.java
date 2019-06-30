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
		int i = 0;
		while(aux > 0) {
			if(pilhaAuto.isEmpty()) {
				Automato a = Automato.automatoSimples(entradaForChar[i]);
				Automato b = Automato.automatoSimples(entradaForChar[i+1]);
				Automato c = Automato.automatoAuxiliar();
			    c.construirAuto(a, b);
			    pilhaAuto.add(c);
			    aux = aux - 2;
			    i = i + 2;
			}else {
				if(entradaForChar[i] == '+') {
					Automato aux0 = pilhaAuto.pop();
					if(entradaForChar[i+1] != '*') {
						Automato aux1 = Automato.automatoSimples(entradaForChar[i+1]);
						Automato aux2 = Automato.automatoAuxiliar();
						aux2.construirAuto(aux0, aux1);
						pilhaAuto.push(aux2);
					}else {
						Automato aux1 = Automato.automatoAuxiliar();
						aux1 = aux0;
						aux1.fechoKleen(aux1);
						pilhaAuto.push(aux1);
					}
				}else if(entradaForChar[i] == '.') {
					Automato aux0 = pilhaAuto.pop();
					if(entradaForChar[i+1] != '*') {
						Automato aux1 = Automato.automatoSimples(entradaForChar[i+1]);
						Automato aux2 = Automato.automatoAuxiliar();
						aux2.concatenaAuto(aux0, aux1);
						pilhaAuto.push(aux2);
					}else {
						Automato aux1 = Automato.automatoAuxiliar();
						aux1 = aux0;
						aux1.fechoKleen(aux1);
						pilhaAuto.push(aux1);
					}
					
				}
				aux--;
				i++;
			}
		}
		System.out.print("Tamanho da pilha: " + pilhaAuto.size());
		System.out.println();
		Automato a6 = pilhaAuto.pop();
        rec.reconheceLinguagem("acac", a6);
        rec.reconheceLinguagem("abac", a6);
        rec.reconheceLinguagem("abacacc", a6);
        rec.reconheceLinguagem("abacac", a6);
        rec.reconheceLinguagem("abacac", a6);
        rec.reconheceLinguagem("abacad", a6);
        rec.reconheceLinguagem("abazcad", a6);
        rec.reconheceLinguagem("aba", a6);
        rec.reconheceLinguagem("abc", a6);
        rec.reconheceLinguagem("bcac", a6);
        rec.reconheceLinguagem("bcaa", a6);
        rec.reconheceLinguagem("ac", a6);
        rec.reconheceLinguagem("acacacaca", a6);
        rec.reconheceLinguagem("acbcac", a6);
	}

}

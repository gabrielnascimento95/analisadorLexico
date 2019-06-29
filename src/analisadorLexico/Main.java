package analisadorLexico;

public class Main {

	public static void main(String[] args) {
		Automato a1 = Automato.automatoSimples('a');
        Automato a2 = Automato.automatoSimples('b');
        Automato a3 = Automato.automatoSimples('c');

        
        Automato a4 = Automato.automatoAuxiliar();
        a4.construirAuto(a1, a2);
        
        Automato a5 = Automato.automatoAuxiliar();
        a5.concatenaAuto(a4, a3);	
	}

}

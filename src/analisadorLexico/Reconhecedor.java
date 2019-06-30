package analisadorLexico;

import java.util.ArrayList;
import java.util.List;

public class Reconhecedor {

	public Reconhecedor() {
		// TODO Auto-generated constructor stub
	}

	public static void reconheceLinguagem(String chave, Automato automato) {

		Estado inicial = automato.getInicial();
        
        int flag = 0;
        
        //toda vez que chamar o automato esse trem devera ser setado
        int flag_not_in=1;
        int flag_not_finals=0;
        
       for (int i = 0; i < chave.length(); i++) {
           flag = 0;
           char c = chave.charAt(i);
           
           List<Transicao> possiveisTransicoes = new ArrayList<>();
           
           for (int j = 0; j < automato.getTransicoes().size(); j++) {
               
               if (automato.getTransicoes().get(j).getSimbolo() == c ||automato.getTransicoes().get(j).getSimbolo() == '*' ) {
                   possiveisTransicoes.add(automato.getTransicoes().get(j));
               }
           }
           
          Estado auxiliar = new Estado();
          auxiliar = automato.getAtual();
       for (Transicao transicao:possiveisTransicoes){
           
           if(transicao.getOrigem() == automato.getAtual()){
               
               if(transicao.getSimbolo()=='*'){
                   automato.setAtual(transicao.getDestino());
                   flag = 1;
                   i=i-1;
                   break;
               }else{
                   automato.setAtual(transicao.getDestino());
                   flag = 1;
                   break;
                   }
               }
         
           }
       
       if(auxiliar==automato.getAtual()){
          flag_not_in=0; 
       }
       
         
       }
       
       
       for(Estado estado: automato.getFinais()){
           if(estado == automato.getAtual())
               flag_not_finals=1;
       }
       
       if(flag==0 || flag_not_in==0 || flag_not_finals==0){
           System.out.println("Não Reconhece: " + chave);
           
       }

       else{
           System.out.println("Reconhece: " + chave);
       }
       automato.setAtual(automato.getInicial());
   }
}

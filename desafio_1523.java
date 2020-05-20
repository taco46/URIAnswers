package desafio_semana_7;

import java.util.*;

/*
 * Nomes e nusps:
 * Arthur Croce Jeronimo 10259050
 * Pedro Victor Alves Ferreira 10284729
 * Victor Hugo Vieira Carlota 10374323
*/


public class Main{
	public static void main(String[] arges) {
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Integer> carros = new HashMap<Integer, Integer>();
		Stack<Integer> estacionamento = new Stack<Integer>();;
		
		String[] linha;		
		Integer ncarros, vagas, entrada, saida, saidamaistarde;
		boolean result;
		
		linha = sc.nextLine().split(" ");
		
		while (!linha[0].equals("0") && !linha[1].equals("0")) {
			saidamaistarde = 0;			
			result = true;
			ncarros = Integer.parseInt(linha[0]);
			vagas = Integer.parseInt(linha[1]);
			
			for(int i = 0; i<ncarros; i++) {
				linha = sc.nextLine().split(" ");
				entrada = Integer.parseInt(linha[0]);
				saida = Integer.parseInt(linha[1]);
				
				if(saida > saidamaistarde) saidamaistarde = saida;
				
				carros.put(entrada, saida);
			}

			for(Integer hora = 1; hora<=saidamaistarde; hora++) {
			
				if(!estacionamento.isEmpty() && estacionamento.lastElement() == hora) estacionamento.pop();
				
				if(carros.containsKey(hora)) estacionamento.push(carros.get(hora));
				
				if(estacionamento.size() > vagas || estacionamento.contains(hora)) result = false;
			}
			
			if(result) System.out.println("Sim");
			else System.out.println("Nao");
			
			linha = sc.nextLine().split(" ");
			carros.clear();
			estacionamento.clear();
		}	
	}
}
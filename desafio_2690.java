package desafio_2690;

import java.util.*;

public class Main{
	
	/*
	 * Nomes e nusps:
	 * Victor Hugo Vieira Carlota 10374323
	 */
	
	public static void main(String[] args) {
		Map<Character, Integer> codigos = new HashMap<Character, Integer>();
		
		for(int i = 0; i < 26; i++) codigos.put((char) (i+97), (i%10));
		codigos.put('G', 0);
		codigos.put('I', 1);
		codigos.put('E', 2);
		codigos.put('F', 3);
		codigos.put('J', 4);
		codigos.put('D', 5);
		codigos.put('A', 6);
		codigos.put('C', 7);
		codigos.put('B', 8);
		codigos.put('H', 9);
		codigos.put('Q', 0);
		codigos.put('S', 1);
		codigos.put('O', 2);
		codigos.put('P', 3);
		codigos.put('T', 4);
		codigos.put('N', 5);
		codigos.put('K', 6);
		codigos.put('M', 7);
		codigos.put('L', 8);
		codigos.put('R', 9);
		codigos.put('Y', 2);
		codigos.put('Z', 3);
		codigos.put('X', 5);
		codigos.put('U', 6);
		codigos.put('W', 7);
		codigos.put('V', 8);
		
		Scanner sc = new Scanner(System.in);
		String linha;
		String[] palavras;
		char[] letras;
		String resultado = "";
		int casosdeteste = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i<casosdeteste; i++) {
			resultado = "";
			linha  = sc.nextLine();
			//if(linha.length() <= 20) {
				palavras = linha.split(" ");
			
				for(String palavra : palavras) {
					
					letras = palavra.toCharArray();
				
					for(char letra : letras) if(resultado.length() < 12) resultado += codigos.get(letra);
				}
				
			//}
			
			System.out.println(resultado);

		}
		
		sc.close();
	}
}
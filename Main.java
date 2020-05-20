package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
 * Nomes e nusps:
 * Arthur Croce Jeronimo 10259050
 * Caio Silvestre Almeida da Silva
 * Pedro Victor Alves Ferreira 10284729
 * Victor Hugo Vieira Carlota 10374323
 */

class Palavra implements Comparable<Palavra>{
	
	private String palavra;
	private Integer tamanho;
	
	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public Palavra(String palavra) {
		this.palavra = palavra;
		tamanho = (palavra.length() -2);
	}
	@Override
	public int compareTo(Palavra outro) {
		if(this.tamanho != outro.getTamanho()) return outro.getTamanho().compareTo(this.tamanho);
		else return this.palavra.compareTo(outro.getPalavra());
	}	
	@Override
	public boolean equals(Object o2) {
		return this.getPalavra().equals(((Palavra) o2).getPalavra());
	}
	
	public String toString() {
		return "[" + this.palavra + " " + this.tamanho + "] - ";
	}
	
}

public class Main{
	public static void main(String[] args) throws IOException {
		Map<Character, LinkedList<Palavra>> luis;
		
		List<Palavra> palavras;
		
		Scanner sc = new Scanner(System.in);
		String frase;
		String aux [];
	    
//	    gravarArq.println("io");
//	    gravarArq.println("io");
//	    gravarArq.println("io");
//	    
//	    gravarArq.close();
	    
	    
		
		
		while(sc.hasNext() && !(frase = sc.nextLine()).equals(".")) {
			luis = new HashMap<Character, LinkedList<Palavra>>();
			palavras = new LinkedList<Palavra>();
			String frasefinal = "";
			aux = frase.split(" ");
			for(int i = 0; i<aux.length; i++) palavras.add(new Palavra(aux[i]));
			for(Palavra i : palavras) {
				Character letrainicial = i.getPalavra().charAt(0);
				if(luis.containsKey(letrainicial)) { //já iniciei a lista de palavras dessa letra
					if(luis.get(letrainicial).contains(i)) { //já adicionei uma palavra igual na lista dessa letra
						
						int index = luis.get(letrainicial).indexOf(i);
						int tamanho = luis.get(letrainicial).get(index).getTamanho() + i.getTamanho();
						luis.get(letrainicial).get(index).setTamanho(tamanho);
						
					}
					
					else luis.get(letrainicial).add(i); //ainda não add essa palavra na lista dessa letra
				}
				else if(i.getTamanho() > 0){ //ainda não criei a lista dessa letra
					luis.put(letrainicial, new LinkedList<Palavra>());
					luis.get(letrainicial).add(i);
				}
			}
			
			SortedSet<Character> listadevalores = new TreeSet<>(luis.keySet());
			
			
			for(Character i : listadevalores) {
				Collections.sort(luis.get(i));
			}
			
			for(Palavra i : palavras) {
				String palavra = i.getPalavra();
				int tamanho = i.getTamanho();
				if(frasefinal != "") {
					if(tamanho > 0 && luis.get(palavra.charAt(0)).getFirst().getPalavra().equals(palavra)  ) {
						frasefinal += " " + palavra.substring(0, 1) + ".";
					}
					else frasefinal += " " + palavra;
				}
				else {
					if(tamanho > 0 && luis.get(palavra.charAt(0)).getFirst().getPalavra().equals(palavra)  ) {
						frasefinal += palavra.substring(0, 1) + ".";
					}
					else frasefinal += palavra;
				}
			}
			

			
		    System.out.println(frasefinal);

		    System.out.println(listadevalores.size());
		    
			//System.out.println(frasefinal);
			//System.out.println(listadevalores.size());
			for(Character i : listadevalores) {
				String f = luis.get(i).getFirst().getPalavra();

				System.out.println(f.charAt(0) + "." + " = " + f);
				
				//System.out.println(f.charAt(0) + "." + " = " + f);
			
			}
		}	
	
	}
}
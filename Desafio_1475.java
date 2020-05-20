package principal;

import java.util.*;

class Circunferencia{
	private Integer comprimento;
	private Integer nfuros;
	private LinkedList<Integer> furos;
	
	public Circunferencia(Integer comprimento, Integer nfuros, LinkedList<Integer> furos){
		this.setComprimento(comprimento);
		this.setNfuros(nfuros);
		this.setFuros(furos);
	}

	public Integer getNfuros() {
		return nfuros;
	}

	public void setNfuros(Integer nfuros) {
		this.nfuros = nfuros;
	}

	public Integer getComprimento() {
		return comprimento;
	}

	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}

	public LinkedList<Integer> getFuros() {
		return furos;
	}

	public void setFuros(LinkedList<Integer> furos) {
		this.furos = furos;
	}
}

class Remendo{
	private Integer remendo1;
	private Integer remendo2;
	
	public Remendo(Integer remendo1, Integer remendo2) {
		this.setRemendo1(remendo1);
		this.setRemendo2(remendo2);
	}
	
	public Integer getRemendo1() {
		return remendo1;
	}
	public void setRemendo1(Integer remendo1) {
		this.remendo1 = remendo1;
	}
	public Integer getRemendo2() {
		return remendo2;
	}
	public void setRemendo2(Integer remendo2) {
		this.remendo2 = remendo2;
	}
	
	public Integer getMenor() {
		if(getRemendo1() < getRemendo2()) return remendo1;
		return remendo2;
	}
	
	public Integer getMaior() {
		if(getRemendo1() < getRemendo2()) return remendo2;
		return remendo1;
	}
}

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Circunferencia roda;
		LinkedList<Integer> furos = new LinkedList<Integer>();
		Remendo remendo;
		Integer soma;
		String linha;
		String linha2;
		String[] valores;
		
		while(sc.hasNext()) {
			soma = 0;
			linha = sc.nextLine();
			linha2 = sc.nextLine();
			valores = linha.split(" ");
			for(int i = 0; i < linha2.split(" ").length; i++) furos.add(Integer.parseInt(linha2.split(" ")[i]));

			remendo = new Remendo(Integer.parseInt(valores[2]), Integer.parseInt(valores[3]));
			roda = new Circunferencia(Integer.parseInt(valores[1]), Integer.parseInt(valores[0]), furos);
			
			Collections.sort(roda.getFuros());
			
			while(!roda.getFuros().isEmpty()) {
				Integer f1 = roda.getFuros().removeFirst();
				
				if(roda.getFuros().isEmpty()) {
					soma += remendo.getMenor();
					continue;
				}
				
				Integer f2 = roda.getFuros().removeFirst();
				
				while(f2-f1 < remendo.getMaior()) {
					if(!roda.getFuros().isEmpty()) f2 = roda.getFuros().removeFirst();
					
					if(f2 != null)
				}
				if(f2 == null) soma += remendo.getMenor();
				else {
					if((f2 - f1) <= remendo.getMenor()) soma += remendo.getMenor();
					else if((f2-f1) <= remendo.getMaior()) soma += remendo.getMaior();
					else soma += remendo.getMenor();
				}
			}
			
			System.out.println(soma);
			
		}
		
	}
}
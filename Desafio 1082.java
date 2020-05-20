import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/*Nomes e Nusps:
	Arthur Croce Jeronimo - 10259050
	Caio Silvestre de Almeida da Silva - 10430896
	Pedro Victor Alves Ferreira - 10284729
	Victor Hugo Vieira Carlota - 10374323
*/

class Grafo{
    List<Node> nos = new ArrayList<Node>();
    Integer nComp;
    Integer nNodes;
    Integer nEdges;
    
    public Grafo(Integer nNodes, Integer nEdges){
        this.nNodes = nNodes;
        this.nEdges = nEdges;
        this.nComp = 0;
        for(Integer i = 0; i < nNodes; i++) nos.add(new Node(i, (char) (i+97))); 
    }
    
    public void insertEdge(String nodes){
        char [] n = nodes.toCharArray();
        Integer n1 = -97 + (int) n[0];
        Integer n2 = -97 + (int) n[2];
        //System.out.println(n1);
        //System.out.println(n2);
        
        nos.get(n1).addAdjascente(nos.get(n2));
        nos.get(n2).addAdjascente(nos.get(n1));
    }
    
    public String BuscaProf(Node n, String result){
        if(n.visitado != 0) return result;
        n.visitado = 1;
        result += (n.letra);
        for(Integer i = 0; i < n.adjascentes.size(); i++){
            Node prox = n.adjascentes.get(i);
            if(prox.visitado != 1) result = BuscaProf(prox, result);
        }
        n.visitado = 2;
        return result;
    }
    
}

class Node{
    List<Node> adjascentes = new ArrayList<Node>();
    Integer id;
    Integer visitado;
    char letra;
    
    public Node(Integer id, char letra){
        this.id = id;
        this.letra = letra;
        visitado = 0;
    }
    
    public void addAdjascente(Node n){
        this.adjascentes.add(n);
    }
}

public class Main
{
    public static String reordena(String x){
        char [] result = x.toCharArray();
        char y;
        for(int j = result.length-1; j > 0; j--){
            for(int i = 0; i<j; i++){
                y = result[i];
                if(result[i]>result[i+1]) {
                    result[i] = result[i+1];
                    result[i+1] = y;
                }
            }
        }
        String z = new String();
        for(int i = 0; i<result.length; i++) z += result[i] + ",";
        return z;
    }
    
	public static void main(String[] args) throws IOException{
	    
	    Scanner sc = new Scanner(System.in);
	    Integer nCases = Integer.parseInt(sc.nextLine());
	    Grafo g;
	    String result = new String();
	    
	    for(Integer i = 0; i<nCases; i++){
	        String x = sc.nextLine();
	        String [] y = x.split(" ");
	        Integer v = Integer.parseInt(y[0]);
	        Integer a = Integer.parseInt(y[1]);
	        g = new Grafo(v, a);
	        System.out.println("Case #" + (i+1) + ":");
	        for(int j = 0; j<g.nEdges; j++) {
	            String teste = sc.nextLine();
	            //System.out.println(teste);
	            g.insertEdge(teste);
	        }
	        
	        for(int j = 0; j<g.nNodes; j++){
	            if(g.nos.get(j).visitado == 0){
	                g.nComp++;
	                System.out.println(reordena(g.BuscaProf(g.nos.get(j), result)));
	                
	            }
	        }
	        System.out.println(g.nComp + " connected components");
	        System.out.println();
	        
	    }
	    
	}
}

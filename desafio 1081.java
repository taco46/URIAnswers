import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

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
        for(Integer i = 0; i < nNodes; i++) nos.add(new Node(i)); 
    }
    
    public void insertEdge(String nodes){
        String [] n = nodes.split(" ");
        Integer n1 = Integer.parseInt(n[0]);
        Integer n2 = Integer.parseInt(n[1]);
        
        nos.get(n1).addAdjascente(nos.get(n2));
    }
    
    public void BuscaProf(Node n, int x){
        //System.out.println(x);
        n.visitado = 1;
        String blank = new String();
        for(Integer i = 0; i < n.adjascentes.size(); i++){
            Node prox = n.adjascentes.get(i);
            blank = "";
            for(int j = 0; j<x; j++) blank += "  ";
            //System.out.print(blank + n.id + "-" + prox.id);
            if(prox.visitado == 0){ 
                System.out.println(blank + n.id + "-" + prox.id + " pathR(G," + prox.id + ")"); //1-5 pathR(G,5)
                BuscaProf(prox, x+1);
            }
            else System.out.println(blank + n.id + "-" + prox.id);
            //x--;
        }
        n.visitado = 2;
        return;
    }
}

class Node implements Comparable<Node>{
    List<Node> adjascentes = new ArrayList<Node>();
    Integer id;
    Integer visitado;
    
    public Node(Integer id){
        this.id = id;
        visitado = 0;
    }
    
    public void addAdjascente(Node n){
        this.adjascentes.add(n);
        Collections.sort(adjascentes);
    }
    /*
    public String toString(){
        return this.id;
    }
    */
    public int compareTo(Node aluno) {
        return this.id.compareTo(aluno.id);
    }
}

public class Main
{

	public static void main(String[] args) throws IOException{
	    
	    Scanner sc = new Scanner(System.in);
	    Integer nCases = Integer.parseInt(sc.nextLine());
	    Grafo g;
	    String result = new String();
	    
	    for(Integer i = 0; i<nCases; i++){
	        String x = sc.nextLine();
	        //System.out.println(x);
	        String [] y = x.split(" ");
	        Integer v = Integer.parseInt(y[0]);
	        Integer a = Integer.parseInt(y[1]);
	        g = new Grafo(v, a);
	        System.out.println("Caso " + (i+1) + ":");
	        for(int j = 0; j<g.nEdges; j++) {
	            String teste = sc.nextLine();
	            //System.out.println(teste);
	            g.insertEdge(teste);
	        }
	        
	        for(int j = 0; j<g.nNodes; j++){
	            if(g.nos.get(j).visitado == 0){
	                g.nComp++;
	                g.BuscaProf(g.nos.get(j), 1);
	                if(g.nos.get(j).adjascentes.size() != 0) System.out.println();
	            }
	        }
	    }
	    
	}
}

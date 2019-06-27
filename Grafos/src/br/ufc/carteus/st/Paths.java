package br.ufc.carteus.st;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Paths {
	private final Graph GP;
	private final int S;
	
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public Paths(Graph GP, int S) {
		this.GP = GP;
		this.S = S;
	}
	
	private void hasPathToInternal(int s) {
		marked[s] = true;
		
		for(int i : GP.adj(s)) {
			if(!marked[i]) {
				hasPathToInternal(i);
				edgeTo[i] = s;
			}
		}
		
	}
	
	public boolean hasPathTo(int v) {
		marked = new boolean[GP.V()];
		edgeTo = new int[GP.V()];
		hasPathToInternal(S);
		return marked[v];
	}
	
	/*Busca em profundidade*/
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		
		int aux = v;
		Stack<Integer> pilha = new Stack<Integer>();
		while(aux != S) {
			pilha.push(aux);
			aux = edgeTo[aux];
		}
		pilha.push(aux);
		return pilha;
	}
	
	
	/*busca em largura*/
	private void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		marked = new boolean[GP.V()];
		distTo = new int[GP.V()];
		edgeTo = new int[GP.V()];
		
		
		q.add(v);
		marked[v] = true;
		distTo[v] = 0;
		
		while(!q.isEmpty()) {
			int m = q.remove();
			for(int w : GP.adj(m)) {
				if(!marked[w]) {
					q.add(w);
					marked[w] = true;
					edgeTo[w] = m;
					distTo[w] = distTo[m] + 1;
				}
			}
		}
	}
	
	public int menorDistancia(int v) {
		bfs(S);
		return distTo[v];
	}
}

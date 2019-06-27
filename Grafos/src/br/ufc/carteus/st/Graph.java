package br.ufc.carteus.st;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Graph {
	
	private class Node{
		int adj;
		Node next;
		
		Node(Node next, int adj){
			this.next = next;
			this.adj = adj;
		}
	}
	
	private final int V;
	private final Node[] edge;
	
	public Graph(int V) {
		this.V = V;
		this.edge = new Node[V];
	}
	
	public Graph(InputStream in) {
		Scanner scn = new Scanner(in);
		this.V = scn.nextInt();
		this.edge = new Node[this.V];
		int nE = scn.nextInt();
		for(int i = 0; i < nE; i++) {
			int v = Integer.parseInt(scn.next());
			int w = Integer.parseInt(scn.next());
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v, int w) {
		this.edge[v] = new Node(this.edge[v], w);
		this.edge[w] = new Node(this.edge[w], v);
	}
	
	public int V() {
		return this.edge.length;
	}
	
	public Iterable<Integer> adj(int v){
		Queue<Integer> adjs = new LinkedList<Integer>();
		for(Node l = this.edge[v]; l != null; l = l.next)
			adjs.add(l.adj);
		return adjs;
	}
	
	public int degree(int v) {
		int c = 0;
		for(int i : adj(v))
			c++;
		return c;
	}
} 

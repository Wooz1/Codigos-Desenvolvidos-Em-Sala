package br.ufc.carteus.st;

import java.util.Stack;

public class ComponentesConvexo {
	private final Graph GP;
	private int[] id;
	private int nextId = 0;
	
	public ComponentesConvexo(Graph GP) {
		this.GP = GP;
		id = new int[GP.V()];
		Stack<Integer> st = new Stack<Integer>();
		for(int v = 0; v < GP.V(); v++) st.push(v);
		nextId=0;
		while(st.isEmpty()) {
			int v = st.peek();
			id[v] = nextId;
			for(int i : GP.adj(v)) {
				id[i] = nextId;
				st.remove(i);
			}
			nextId++;
		}
	}
	
	public boolean connected(int v, int s) {
		Paths pt = new Paths(GP, v);
		return pt.hasPathTo(s);
	}
	
	public int count() {
		return nextId;
	}
	
}

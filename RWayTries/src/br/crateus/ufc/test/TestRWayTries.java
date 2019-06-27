package br.crateus.ufc.test;

import br.ufc.crateus.st.RWayTries;

public class TestRWayTries {

	public static void main(String[] args) {
		RWayTries<Integer> tree = new RWayTries<>();
			
		
		String l = "cgcgggcgcg";
		tree = tree.countSubString(l);
		
		for(String s : tree.keys()) {
			System.out.println(s);
		}	
	}
}

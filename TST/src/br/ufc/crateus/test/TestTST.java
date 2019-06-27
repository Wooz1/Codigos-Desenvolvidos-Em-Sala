package br.ufc.crateus.test;

import br.ufc.crateus.st.TST;

public abstract class TestTST {

	public static void main(String[] args) {
		TST<Integer> tst = new TST<Integer>();
		
		tst.put("Josefa", 12);
		tst.put("aline", 4);
		tst.put("Josevania", 17);
		
		System.out.println(tst.get("Josevania"));
	}

}

package br.ufc.crateus.test;

import br.ufc.crateus.st.LinearProbingHashMap;
import br.ufc.crateus.st.Map;
import br.ufc.crateus.st.SepareteChainingHashMap;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
		Map<Integer, Integer> mapa = new LinearProbingHashMap<>();
		for(int i = 0; i < 10000;i++)
			if(i%2==0)
		
		System.out.println(mapa.get(400));
	}

}

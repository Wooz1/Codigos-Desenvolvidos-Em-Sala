package br.ufc.carteus.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import br.ufc.carteus.st.ComponentesConvexo;
import br.ufc.carteus.st.Graph;
import br.ufc.carteus.st.Paths;

public class GraphTest {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream in = new FileInputStream("C:\\Users\\Aluno\\eclipse-workspace-2019-03\\Grafos\\src\\br\\ufc\\carteus\\test\\graph.txt");
		Graph gp = new Graph(in);
		int n = 10;
		Paths pt = new Paths(gp, n);
		System.out.println(pt.menorDistancia(12));
		
		ComponentesConvexo cc = new ComponentesConvexo(gp);
		
		System.out.println(cc.count());
	}

}

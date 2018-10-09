import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;



public class GraphTest {

	@Test
	public void testGraphCreation() {
	
		Set<Vertice> vertices = new HashSet<Vertice>();
		Vertice a = new Vertice("A");
		vertices.add(a);
		Vertice b = new Vertice("B");
		vertices.add(b);
		Vertice c = new Vertice("C");
		vertices.add(c);
		Vertice d = new Vertice("D");
		vertices.add(d);
		Vertice e = new Vertice("E");
		vertices.add(e);
		Vertice f = new Vertice("F");
		vertices.add(f);
		
		HashMap<Vertice, ArrayList<Edge>> comp = new HashMap<>();
		ArrayList<Edge> edgesA = new ArrayList<Edge>();
		edgesA.add(new Edge("ab", a, b, 1));
		edgesA.add(new Edge("ac", a, c, 2));
		comp.put(a, edgesA);
		
		ArrayList<Edge> edgesB = new ArrayList<Edge>();
		edgesB.add(new Edge("bd", b, d, 2));
		edgesB.add(new Edge("bf", b, f, 6));
		comp.put(b, edgesB);
		
		ArrayList<Edge> edgesC = new ArrayList<Edge>();
		edgesC.add(new Edge("ce", c, e, 3));
		comp.put(c, edgesC);

		ArrayList<Edge> edgesE = new ArrayList<Edge>();
		edgesE.add(new Edge("ef", e, f, 5));
		comp.put(e, edgesE);
		
		GraphDS graph = new GraphDS(comp);
		
		Assert.assertEquals(	"A-->ab 1-->B"
							+ 	"A-->ac 2-->C"
							+	"B-->bd 2-->D"
							+	"B-->bf 6-->F"
							+	"C-->ce 3-->E"
							+	"E-->ef 5-->F"
							,
							graph.toString());  
		
	}
	
}

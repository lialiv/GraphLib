import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GraphDS {

	HashMap<Vertice, ArrayList<Edge>> comp = new HashMap<>();
	
	public GraphDS(HashMap<Vertice, ArrayList<Edge>> comp) {
		super();
		this.comp = comp;
	}
	
	public boolean addEdge(Vertice vFrom, Vertice vTo, int weight) {
		
		Edge edge = new Edge(vFrom, vTo, weight);
		
		ArrayList<Edge> existingEdges = comp.get(vFrom);
		return existingEdges.add(edge);
	}

	public void addVertice(String name) {
			comp.put(new Vertice(name), null);
	}
	
	public void addVertice(String name, ArrayList<Edge> edges) {
		comp.put(new Vertice(name), edges);
	}
	 
	public void removeVertice(Vertice Vertice) {
	        if (!this.comp.containsKey(Vertice)) {
	            throw new IllegalArgumentException("This vertice doesn't exist!");
	        }
	        
	        this.comp.remove(Vertice);
	    }
	 
	 public void removeEdge(Edge edge) {
         
         ArrayList<Edge> edgesvFrom = comp.get(edge.getvFrom());
         if (edgesvFrom.size() > 0) edgesvFrom.remove(edge);
         else throw new IllegalArgumentException("This edge doesn't exist!");
         
         ArrayList<Edge> edgesvTo = comp.get(edge.getvTo());
         if (edgesvTo.size() > 0) edgesvTo.remove(edge);
         else throw new IllegalArgumentException("This edge doesn't exist!");

	 }
	
	 public void removeEdge(Vertice vFrom, Vertice vTo) {
        removeEdge(new Edge (vFrom, vTo));
	 }
	
	 public Set<Vertice> getAllVertices() {
			return comp.keySet();
		}
	 
	 public ArrayList<Edge> getNeighbors(Vertice Vertice) {
	        return this.comp.get(Vertice);
	    }
	 
	 
	 public boolean checkCompetability(Vertice vFrom, Vertice vTo) {
		
		 boolean compatible = false;
		 	for (Edge edge : this.comp.get(vFrom))
		 			if (edge.getvTo().equals(vTo))
		 				compatible = true;
		 				
		 return compatible;
	 }
	 
	 public ArrayList<Vertice> shortestPath(Vertice vFrom, Vertice vTo) {
		 ArrayList<Vertice> path = new ArrayList<>();
		 Edge shortest = shortestOfEdges(vFrom);
			
		 while (shortest.vTo != vTo ) {
				path.add(shortest.vTo);
				shortestOfEdges(shortest.vTo);
		 }
		 
		 return path;
	 }
	 
	 private Edge shortestOfEdges(Vertice vFrom) {
		 ArrayList<Edge> edges = this.comp.get(vFrom);
		 Edge shortest = null;
			for (int i=0; i<edges.size(); i++) {
				if (i==0)
					shortest = edges.get(i);
				if (edges.get(i).weight < shortest.weight )
					shortest = edges.get(i);
			}
			return shortest;
	 }
	 
	 @Override
	    public String toString() {
	     
		 for (Vertice vertice : comp.keySet()) {
	    	ArrayList<Edge> edges = comp.get(vertice);
	    	 
	    	for (Edge edge : edges)
	    	 System.out.println(vertice.name + "-->" + edge.lable + " " + edge.weight + "-->" + edge.vTo.name);
	     }
		 
		 return comp.toString();
	    }
	 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

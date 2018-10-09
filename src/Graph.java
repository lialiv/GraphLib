import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {

	Set<Vertice> Vertices = new HashSet<>();
	HashSet<Edge> edges = new HashSet<>();
	HashMap<Vertice, ArrayList<Edge>> comp = new HashMap<>();
	
	public boolean addEdge(Vertice vFrom, Vertice vTo, int weight) {
		
		Edge edge = new Edge(vFrom, vTo, weight);
		return edges.add(edge);
	}

	public boolean addVertice(String name) {
	        return Vertices.add(new Vertice(name));
	}
	
	 public void removeVertice(Vertice Vertice) {
	        if (!this.comp.containsKey(Vertice)) {
	            throw new IllegalArgumentException("This Vertice doesn't exist!");
	        }
	        
	        Vertices.remove(Vertice);
	        this.comp.remove(Vertice);
	        
	    }
	 
	 public void removeEdge(Edge edge) {
         if (!edges.remove(edge)) 
        	 throw new IllegalArgumentException("This edge doesn't exist!");
         
         ArrayList<Edge> edgesvFrom = comp.get(edge.getvFrom());
         if (edgesvFrom.size() > 0) edgesvFrom.remove(edge);

         ArrayList<Edge> edgesvTo = comp.get(edge.getvTo());
         if (edgesvTo.size() > 0) edgesvTo.remove(edge);

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
	 
	 
	 

	private class Vertice {
		String name;
			
		public Vertice(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
		
	}
	
	
	private class Edge {
		
		String lable;
		Vertice vFrom, vTo;
        int weight;
		
        public Edge(Vertice vFrom, Vertice vTo) {
        	super();
			this.vFrom = vFrom;
			this.vTo = vTo;
        }
        
        public Edge(Vertice vFrom, Vertice vTo, int weight) {
			super();
			this.vFrom = vFrom;
			this.vTo = vTo;
			this.weight = weight;
		}
        
        public Edge(String lable, Vertice vFrom, Vertice vTo, int weight) {
			super();
			this.lable = lable;
			this.vFrom = vFrom;
			this.vTo = vTo;
			this.weight = weight;
		}

		public Vertice getvFrom() {
			return vFrom;
		}

		public void setN1(Vertice vFrom) {
			this.vFrom = vFrom;
		}

		public Vertice getvTo() {
			return vTo;
		}

		public void setN2(Vertice vTo) {
			this.vTo = vTo;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getLable() {
			return lable;
		}

		public void setLable(String lable) {
			this.lable = lable;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

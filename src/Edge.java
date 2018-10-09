
public class Edge {
		
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

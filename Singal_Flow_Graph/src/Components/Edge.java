package Components;



public class Edge {
	
	private double weight;
	private Node from;
	private Node to;
	
	private Edge() {
		
	}
	
	public Edge(double weight,Node from , Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}


	
	@Override
	public boolean equals(Object obj) {
		Edge t = (Edge) obj;
		if(this.from.equals(t.from) && this.to.equals(t.to) && this.weight == t.weight)
			return true;
		return false;
	}
	
// getters and setters
///////////////////////////////////////////////////////////////////////////////////////////////////
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Node getFrom() {
		return from;
	}

	public void setFrom(Node from) {
		this.from = from;
	}

	public Node getTo() {
		return to;
	}

	public void setTo(Node to) {
		this.to = to;
	}
	
	
	@Override
	public String toString() {
		return "("+from.getID()+"-- "+weight+" -->"+to.getID()+")";
	}
	
	
}

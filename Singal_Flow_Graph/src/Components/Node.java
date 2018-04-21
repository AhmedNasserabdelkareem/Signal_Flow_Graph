package Components;


import gui.NodeGui;

import java.util.ArrayList;

public class Node {
	
	private int ID;
	private ArrayList<Edge> edges;
	
	private int currentIndex;//used for looping throw edges
	private NodeGui nodeGui;
	
	//used in BFS
	private boolean visited;
	private Edge parent;
	
	private Node() {
		
	}
	
	public Node(int id) {
		this.ID = id;
		edges = new ArrayList<Edge>();
		nodeGui = new NodeGui(ID); 
	}

	
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public void addEdge(int weight, Node to) {
		edges.add(new Edge(weight, this, to));
	}
	
	public void removeEdge(Edge e) {
		edges.remove(e);
	}

// use  these for looping throw edges
///////////////////////////////////////////////////////////////////////////
	public void startLooping() {
		currentIndex = 0;
	}
	
	
	
	public Edge getNextEdge() {
		
		Edge r;
		if(currentIndex == edges.size())
			r = null;
		else
			r = edges.get(currentIndex);
		
		currentIndex++;
		return r;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		
		if(obj == null ||  this.ID != ((Node)obj).ID)
			return false;
		return true;
	}
	
// getters and setters	
//////////////////////////////////////////////////////////////////////////////////////////////////
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public Edge getParent() {
		return parent;
	}

	public void setParent(Edge parent) {
		this.parent = parent;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String r = ""+ID;
		
		
		if(edges.size() == 0)
			return r+"()";
		
		r += "(";
		int i;
		for(i = 0; i < edges.size()-1; i++)
			r += edges.get(i).getTo().getID()+",";
		r += edges.get(i).getTo().getID()+")";
		
		return r;
	}
	
	
	public NodeGui getGUI() {
		return nodeGui;
	}
	
	
	
	
	
}

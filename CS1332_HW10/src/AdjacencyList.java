import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.javafx.geom.Edge;

import javafx.util.Pair;
import sun.security.provider.certpath.Vertex;


/**
 * @author D'MiriaCollins
 *
 */


public class AdjacencyList {

	private Map<Vertex, List<Pair>> adjacencyList;

	/**
	 * A list of edges will be passed in and the adjacency list will be prepared to use
	 */
	public AdjacencyList(List<Edge> edges) {
		adjacencyList = new HashMap<Vertex, List<Pair>>();
		
		for(Edge e : edges){
			if (!adjacencyList.containsKey(e.v)){
				adjacencyList.put(e.v, new LinkedList<Pair>());
				adjacencyList.get(e.v).add(new Pair(e.u,e.weight));

			} else {
				adjacencyList.get(e.v).add(new Pair(e.u,e.weight));

			}
			if(!adjacencyList.containsKey(e.u)){
				adjacencyList.put(e.u, new LinkedList<Pair>());
				adjacencyList.get(e.u).add(new Pair(e.v,e.weight));

			} else {
				adjacencyList.get(e.u).add(new Pair(e.v,e.weight));
			}
			
		}
	}

	/**
	 * @param vertex a vertex
	 * @return	a list of pair i.e. vertices and weights adjacent to vertex
	 */

	public List<Pair> adjacencies(Vertex vertex) {
		return adjacencyList.get(vertex);
	}

	/*
	 * Getters and setters
	 */

	public Map<Vertex, List<Pair>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<Vertex, List<Pair>> adjacencyList) {
		this.adjacencyList = adjacencyList;	
	}
}

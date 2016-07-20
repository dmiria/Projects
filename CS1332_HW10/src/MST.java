import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.sun.javafx.geom.Edge;
/**
 * 
 * @author D'MiriaCollins
 *
 */
public class MST {

	/**
	 * Find MST using Kruskal's algorithm. Follow the instructions in the pdf.
	 * 
	 * @param edges	the edge list that represents the graph
	 * @return 		a collection of edges that represent the MST
	 */
	public static Collection<Edge> kruskals(List<Edge> edges) {
		PriorityQueue<Edge> neighbors = new PriorityQueue<Edge>();
		List <Edge> collection = new LinkedList<Edge>();
		List<Vertex> list = new LinkedList<Vertex>();
		
		if (edges == null){
			return collection;
		}
		for (Edge e: edges){
			//edge.vertex
			list.add(e.u);
			list.add(e.v);
		}
		HashSet<Vertex> h = new HashSet<Vertex>();
		for(Edge e: edges){
			//vertex is not in the list
			if(!h.contains(e.u)){
				h.add(e.u);
			}
			//vertex is not in the list
			if(!h.contains(e.v)){
				h.add(e.v);
			}
		}
		DisjointSets<Vertex> set = new DisjointSets<Vertex>(h);
		
		for (Edge e: edges){
			neighbors.add(e);
		}
		while(!neighbors.isEmpty()){
			Edge temp = neighbors.poll();
			Vertex a = set.findParent(temp.u);
			Vertex b = set.findParent(temp.v);
			if(!a.equals(b)){
				collection.add(temp);
				set.merge(temp.u, temp.v);
			}
		}
		return collection;
		
	}

	/**
	 * Implement Prim's algo-rhythm!
	 * 
	 * @param start	the starting vertex of the MST, you are guaranteed that
	 * 				it is contained in the AdjacencyList
	 * @param graph	the adjacency list that represents the graph. You need to find MST for this graph 
	 * @return 		a collection of edges that represent the MST of the graph
	 */
	
	public static Collection<Edge> prims(Vertex start, AdjacencyList graph) {
		List <Edge> collection = new LinkedList<Edge>();
		PriorityQueue<Edge> neighbors = new PriorityQueue <Edge>();
		List<Vertex> visitedPath = new LinkedList<Vertex>();
		
		if (start == (null) || graph == (null)){
			return collection;
		}
		visitedPath.add(start);
		
		for(Pair pair: graph.adjacencies(start)){
			Edge e = new Edge(start,pair.vertex,pair.weight);
			neighbors.add(e);
		}
		while (!neighbors.isEmpty()){
			Edge temp = neighbors.poll();
			Vertex n = temp.u;
			if (!visitedPath.contains(n)){
				collection.add(temp);
				visitedPath.add(n);
			//}	
				if(graph.adjacencies(n) != (null)){
					for (Pair pair: graph.adjacencies(n)){
						Edge e = new Edge(n,pair.vertex,pair.weight);
						neighbors.add(e);
					}
				} 				
			}
		}
		return collection;
	}	
}

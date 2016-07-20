import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * In this class, you will be implementing three different types of graph algorithms.
 * Remember, it's the journey that counts - not the destination! Return a list of nodes
 * that are visited (in order) to reach the goal node. 
 * 
 * Note: You must add the vertices from least ID to greatest ID, otherwise you will lose
 * points on our JUnit Tests.
 * 
 * Example: let's say you wanted to add the neighbors of 2 into your fringe
 * 
 *          0 1 2 3 4
 *        0 1 0 0 1 1
 *        1 1 1 0 1 1 
 *        2 1 0 1 1 1 
 *        3 1 0 0 1 0
 *        4 1 0 1 1 1
 *        
 * You will simply add 0, 3, and 4 to the fringe in that order!
 * 
 * @author D'Miria Collins :)
 *
 */
public class GraphSearches {

	private static final int INF = Integer.MIN_VALUE;
	
	/**
	 * Perform Breadth First Search.
	 * 
	 * 
	 * All parameters will be valid, so you will never worry about either of the two vertices
	 * being out of the range of the matrix.
	 * 
	 * In the adjacency matrix, a 1 indicates that there is a connection, and a 0 indicates
	 * that there is not a connection.
	 * 
	 * @param graph an adjacency matrix that represents the graph
	 * @param v the number of vertices in the graph
	 * @param start the starting vertex
	 * @param goal the ending vertex
	 * @return
	 */
	public static List<Integer> breadthFirstSearch(int[][] graph, int v, int start, int goal) {
		LinkedList<VertexWrapper> f = new LinkedList<VertexWrapper>();
		HashSet<VertexWrapper> s = new HashSet<VertexWrapper>();
		VertexWrapper w = new VertexWrapper();
		w.setVertexID(start);
		f.add(w);	
		while(!f.isEmpty()){
			VertexWrapper wrap2 = f.remove();
			if (wrap2.getVertexID() == goal){
				List<Integer> visit = wrap2.getVisitedList();
				visit.add(goal);
				return visit;
			} else {
				s.add(wrap2);
				int id = wrap2.getVertexID();
				List<Integer> visit2 = wrap2.getVisitedList();
				visit2.add(id);
				for(int n: neighbors(graph,wrap2.getVertexID())){
					VertexWrapper wrap3 = new VertexWrapper(visit2,n);
					if (!s.contains(wrap3)){
						f.add(wrap3);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Perform Depth First Search.
	 * 
	 * All parameters will be valid, so you will never worry about either of the two vertices
	 * being out of range of the matrix.
	 * 
	 * In the adjacency matrix, a 1 indicates that there is a connection and a 0 indicates
	 * that there is not a connection.
	 * 
	 * @param graph an adjacency matrix that represents the graph
	 * @param v the number of vertices in the graph
	 * @param start the starting vertex
	 * @param goal the ending vertex
	 * @return
	 */
	
	public static List<Integer> depthFirstSearch(int[][] graph, int v, int start, int goal) {
		Stack<VertexWrapper> f = new Stack<VertexWrapper>();
		HashSet<VertexWrapper> s = new HashSet<VertexWrapper>();
		VertexWrapper wrap = new VertexWrapper();
		wrap.setVertexID(start);
		f.push(wrap);	
		while(!f.isEmpty()){
			VertexWrapper wrap2 = f.pop();
			if (wrap2.getVertexID() == goal){
				List<Integer> visit = wrap2.getVisitedList();
				visit.add(goal);
				return visit;
			} else {
				s.add(wrap2);
				int id = wrap2.getVertexID();
				List<Integer> visit2 = wrap2.getVisitedList();
				visit2.add(id);
				for(int n: neighbors(graph,wrap2.getVertexID())){
					VertexWrapper wrap3 = new VertexWrapper(visit2,n);
					if (!s.contains(wrap3)){
						f.push(wrap3);
					}
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @param graph
	 * @param v
	 * @return
	 */
	
	public static List<Integer> neighbors(int[][] graph, int v) {
		ArrayList<Integer> n = new ArrayList<Integer>();

		for (int i = 0; i < graph[0].length; i++) {
			if (graph[v][i] >=1) {
				if (i != v) {
					n.add(i);
				}
			}
		}
		return n;
	}
	
	/**
	 * Perform Dijkstra's Algorithm
	 * 
	 * All parameters will be valid, so you will never have to worry about either of the two
	 * vertices being out of range of the matrix.
	 * 
	 * In the adjacency matrix, a positive number indicates a connection with that amount of weight,
	 * and a value of INF indicates that there is no connection. I have provided you with a value for
	 * INF at the top of the file as a constant.
	 * 
	 * @param weightedGraph an adjacency matrix with weights for various graphs.
	 * @param v
	 * @param start
	 * @param goal
	 * @return
	 */
	
	public static List<Integer> dijkstrasAlgorithm(int[][] weightedGraph, int v, int start, int goal) {
		PriorityQueue<VertexWrapper> f = new PriorityQueue<VertexWrapper>();
		HashSet<VertexWrapper> s = new HashSet<VertexWrapper>();
		VertexWrapper w = new VertexWrapper();
		w.setVertexID(start);
		f.add(w);	
		while(!f.isEmpty()){
			VertexWrapper wrap2 = f.poll();
			if (wrap2.getVertexID() == goal){
				List<Integer> visit = wrap2.getVisitedList();
				visit.add(goal);
				return visit;
			} else {
//				s.add(wrap2);
				int id = wrap2.getVertexID();				
				int c = wrap2.getPathCost();
				List<Integer> visit2 = wrap2.getVisitedList();
				visit2.add(id);
				for(int n: neighbors(weightedGraph,id)){
					VertexWrapper wrap3 = new VertexWrapper(visit2,c+weightedGraph[id][n],n);
					if (!s.contains(wrap3)){
						f.remove(wrap3);
						f.add(wrap3);
					}
				}
			}
		}
		return new LinkedList<Integer>();
	}
	
	/**
	 * Wrapper class for vertices. Feel free to modify this. We won't be testing any of it.
	 * In fact, if you don't want to use this, feel free to make your own wrapper (or not).
	 */
	private static class VertexWrapper implements Comparable<VertexWrapper> {

		private List<Integer> visitedList;
		private int pathCost;
		private int vertexID;
		
		public VertexWrapper() {
			visitedList = new LinkedList<Integer>();
			pathCost = 0;
			vertexID = Integer.MIN_VALUE;
		}
		
		public VertexWrapper(List<Integer> list, int vertexID) {
			this();
			this.visitedList = new ArrayList<Integer>();
			
			for(Integer i : list) {
				visitedList.add(i);
			}
			
			this.vertexID = vertexID;
		}
		
		public VertexWrapper(List<Integer> list, int pathCost, int vertexID) {
			visitedList = new ArrayList<Integer>();
			
			for(Integer i : list) {
				visitedList.add(i);
			}
			
			this.pathCost = pathCost;
			this.vertexID = vertexID;
		}
		
		
		public int getPathCost() {
			return pathCost;
		}
		
		public List<Integer> getVisitedList() {
			return visitedList;
		}
		
		public int getVertexID() {
			return vertexID;
		}
		
		public void setPathCost(int pathCost) {
			this.pathCost = pathCost;
		}
		
		public void setVisitedList(List<Integer> visitedList) {
		    this.visitedList = new ArrayList<Integer>();

			for(Integer i : visitedList) {
			        visitedList.add(i.intValue());
			}
                 
		}
		
		public void setVertexID(int vertexID) {
			this.vertexID = vertexID;
		}
		
		@Override
		public int hashCode() {
			return vertexID;
		}
		
		@Override
		public int compareTo(VertexWrapper arg0) {
			return this.pathCost - arg0.pathCost;
		}
		
		@Override
		public boolean equals(Object o) {
			if(!(o instanceof VertexWrapper)) {
				return false;
			}
			else {
				return ((VertexWrapper)o).vertexID == this.vertexID;
			}
		}
		
	}
}

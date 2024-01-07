import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Adjacency Matrix Representation of an Undirected Graph
public class AdjacencyListGraph {
    public int V;   // number of vertices in the graph
    public int E;   // number of edges in the graph
    public LinkedList<Integer>[] adj; // adjacency list using LinkedList

    public AdjacencyListGraph(int nodes) {
        // Constructor; creates a graph of n number of nodes
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        // Add new edges (u, v) and (v, u) to the graph
        if (E == adj.length) resize(adj.length * 2);
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public void resize(int nodes) {
        // Increase the number of vertices (nodes) in the graph IF NECESSARY
        LinkedList<Integer>[] newAdj = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            newAdj[v] = adj[v];
        }
        for (int v = V; v < nodes; v++) {
            newAdj[v] = new LinkedList<>();
        }
        adj = newAdj;
        V = adj.length;
    }

    public String toString() {
        // Print the elements in the adjacency matrix
        String s = "";
        s += (V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s += (v + ": ");
            for (int w : adj[v]) {
                s += (w + " ");
            }
            s += "\n";
        }
        return s;
    }

    public void bfs(int s) {
        // Breadth-First Search traversal algorithm of a graph; takes a vertex 's' as the source
        boolean[] visited = new boolean[V]; // Determine the vertices to explore
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        int i = 0;
        String result = "";

        while (!q.isEmpty()) {
            int u = q.poll();   // get source vertex
            result += (i++ < V-1) ? (u + " --> ") : u;
            for (int v : adj[u]) {  // visit neighboring vertices
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        System.out.println("BFS Traversal: " + result);
    }

    public void dfsI(int s) {
        // Iterative Depth-First Search traversal algorithm of a graph; takes a vertex 's' as the source
        boolean[] visited = new boolean[V]; // Determine the vertices to explore
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        int i = 0;
        String result = "";
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                result += (i++ < V-1) ? (u + " --> ") : u;
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
        System.out.println("Iterative DFS Traversal: " + result);
    }

    private void dfsRHelper(int u, boolean[] visited) {
        // Helper function to perform DFS traversal recursively from a given source vertex
        visited[u] = true;
        System.out.print(u);
        if (visitedCount(visited) < V) System.out.print(" --> ");
        for (int v : adj[u]) {
            if (!visited[v]) dfsRHelper(v, visited);
        }
    }

    private int visitedCount(boolean[] visited) {
        // Helper function to count the number of visited vertices
        int count = 0;
        for (boolean v : visited) if (v) count++;
        return count;
    }

    // Public method to start the DFS traversal from a given source vertex
    public void dfsR(int s) {
        // Recursive Depth-First Search traversal algorithm of a graph; takes a vertex 's' as the source
        boolean[] visited = new boolean[V];
        System.out.print("Recursive DFS Traversal: ");
        dfsRHelper(s, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(6);
        g.addEdge(0, 1);    // (0, 1) and (1, 0)
        g.addEdge(1, 2);    // (1, 2) and (2, 1)
        g.addEdge(2, 3);    // (2, 3) and (3, 2)
        g.addEdge(3, 0);    // (3, 0) and (0, 3)
        g.addEdge(2, 4);    // (2, 4) and (4, 2)
        g.addEdge(4, 5);    // (4, 5) and (5, 4)

        System.out.println(g);

        int sourceVertex = 0;

        // Measure time for BFS
        long startTimeBFS = System.nanoTime();
        g.bfs(sourceVertex);
        long endTimeBFS = System.nanoTime();
        long timeTakenBFS = endTimeBFS - startTimeBFS;
        double timeInSecondsBFS = timeTakenBFS / 1_000_000.0;
        System.out.println("Time taken for BFS: " + timeInSecondsBFS + " milliseconds");

        // Measure time for Iterative DFS
        long startTimeDFSIterative = System.nanoTime();
        g.dfsI(sourceVertex);
        long endTimeDFSIterative = System.nanoTime();
        long timeTakenDFSIterative = endTimeDFSIterative - startTimeDFSIterative;
        double timeInSecondsDFSIterative = timeTakenDFSIterative / 1_000_000.0;
        System.out.println("Time taken for Iterative DFS: " + timeInSecondsDFSIterative + " milliseconds");

        // Measure time for Recursive DFS
        long startTimeDFSRecursive = System.nanoTime();
        g.dfsR(sourceVertex);
        long endTimeDFSRecursive = System.nanoTime();
        long timeTakenDFSRecursive = endTimeDFSRecursive - startTimeDFSRecursive;
        double timeInSecondsDFSRecursive = timeTakenDFSRecursive / 1_000_000.0;
        System.out.println("Time taken for Recursive DFS: " + timeInSecondsDFSRecursive + " milliseconds");
    }
}

// Adjacency Matrix Representation of an Undirected Graph
public class AdjacencyMatrixGraph {
    public int V;   // number of vertices in the graph
    public int E;   // number of edges in the graph
    public int[][] adjMatrix;   // adjacency matrix
                                // 0 indicates the absence of an edge and 1 indicates the presence of an edge

    public AdjacencyMatrixGraph(int nodes) {
        // Constructor; creates a graph of n number of nodes
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void resize(int nodes) {
        // Increase the number of vertices (nodes) in the graph
        int[][] newMatrix = new int[nodes][nodes];
        int minNodes = Math.min(nodes, V);  // Determine the number of nodes to copy
        for (int i = 0; i < minNodes; i++) {
            for (int j = 0; j < minNodes; j++) {
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newMatrix;
        V = adjMatrix.length;
    }

    public void addEdge(int u, int v) {
        // Add new edges (u, v) and (v, u) to the graph
        if (E == adjMatrix.length) resize(adjMatrix.length * 2);
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }

    public String toString() {
        // Print the elements in the adjacency matrix
        String s = "";
        s += (V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s += (v + ": ");
            for (int w : adjMatrix[v]) {
                s += (w + " ");
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4);
        g.addEdge(0, 1);    // (0, 1) and (1, 0)
        g.addEdge(1, 2);    // (1, 2) and (2, 1)
        g.addEdge(2, 3);    // (2, 3) and (3, 2)
        g.addEdge(3, 0);    // (3, 0) and (0, 3)
        g.addEdge(4, 5);    // (4, 5) and (5, 4)
        g.addEdge(5, 6);    // (5, 6) and (6, 5)
        g.addEdge(6, 7);    // (6, 7) and (7, 6)
        g.addEdge(7, 0);    // (7, 0) and (0, 7)
        System.out.println(g);
    }
}
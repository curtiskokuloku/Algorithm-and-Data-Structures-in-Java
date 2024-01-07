// Given an m x n 2D binary grid, which represents a map of '1's (land) and '0's (water),
// return the number of islands.
// An island is surrounded by water and if formed by connecting adjacent lands horizontally or
// vertically. You may assume all four edges of the grid are surrounded by water (0)
public class NumberOfIslands {
    public int m;   // number of rows in the grid
    public int n;   // number of columns in the grid
    public char[][] grid;   // 2D binary grid

    public NumberOfIslands(char[][] matrix) {
        grid = matrix;
        m = grid.length;
        n = grid[0].length;
    }
    public int numOfIslands() {
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length|| visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row, col-1, visited); // left
        dfs(grid, row-1, col, visited); // up
        dfs(grid, row, col+1, visited); // right
        dfs(grid, row+1, col, visited); // down
    }

    public void display() {
        // Print the elements in the grid as a matrix
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '1'}};

        NumberOfIslands n = new NumberOfIslands(grid);

        // Display the original grid
        System.out.println("Original Grid:");
        n.display();

        // Measure time for numOfIslands method
        long startTime = System.nanoTime();
        int numOfIslands = n.numOfIslands();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        // Display the number of islands
        System.out.println("Number of Islands: " + numOfIslands);

        // Display the time taken
        System.out.println("Time taken for numOfIslands: " + timeTaken / 1000000 + " milliseconds");
    }

}
